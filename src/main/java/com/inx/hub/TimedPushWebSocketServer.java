package com.inx.hub;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 带定时推送功能的WebSocket服务端
 * 核心：识别userId=1001，延迟1分钟推送指定消息
 */
public class TimedPushWebSocketServer extends WebSocketServer {

    // 核心映射：用户ID -> WebSocket连接（线程安全）
    private static final Map<String, WebSocket> USER_CONNECTIONS = new ConcurrentHashMap<>();
    // 反向映射：连接 -> 用户ID
    private static final Map<WebSocket, String> CONNECTION_USERS = new ConcurrentHashMap<>();
    // 所有在线连接
    private static final Set<WebSocket> ALL_CONNECTIONS = Collections.newSetFromMap(new ConcurrentHashMap<>());

    // 定时任务线程池（专门处理延迟/定时任务，避免阻塞WebSocket主线程）
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public TimedPushWebSocketServer(int port) {
        super(new InetSocketAddress(port));
    }

    /**
     * 客户端连接成功时触发：绑定用户ID + 针对1001用户添加定时推送任务
     */
    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        ALL_CONNECTIONS.add(conn);
        String clientIp = conn.getRemoteSocketAddress().getAddress().getHostAddress();

        // 解析用户ID
        String userId = parseUserIdFromUrl(conn.getResourceDescriptor());
        if (userId == null || userId.trim().isEmpty()) {
            conn.close(4001, "缺少用户ID，连接被拒绝");
            System.out.println("客户端 " + clientIp + " 连接失败：未传递用户ID");
            return;
        }

        // 踢掉旧连接（如果有）
        if (USER_CONNECTIONS.containsKey(userId)) {
            WebSocket oldConn = USER_CONNECTIONS.get(userId);
            if (oldConn != null && oldConn.isOpen()) {
                oldConn.close(4002, "账号在其他设备登录");
                CONNECTION_USERS.remove(oldConn);
                System.out.println("用户 " + userId + " 旧连接已被踢下线");
            }
        }

        // 绑定新连接
        USER_CONNECTIONS.put(userId, conn);
        CONNECTION_USERS.put(conn, userId);
        System.out.println("用户 " + userId + "（IP：" + clientIp + "）连接成功");
        conn.send("用户 " + userId + "，欢迎连接WebSocket服务端！当前在线人数：" + USER_CONNECTIONS.size());

        // ========== 核心逻辑：针对userId=1001，延迟1分钟推送消息 ==========
        if ("1001".equals(userId)) {
            System.out.println("检测到用户1001连接，将在1分钟后推送消息：你好张晓三");

            // 提交定时任务：延迟60秒执行
            scheduler.schedule(() -> {
                // 推送前再次检查连接是否有效（避免1分钟内用户断开连接）
                WebSocket targetConn = USER_CONNECTIONS.get("1001");
                if (targetConn != null && targetConn.isOpen()) {
                    String pushMessage = "你好张晓三";
                    // 1. 推送消息
//                    targetConn.send(pushMessage);
                    System.out.println("已向用户1001推送消息：" + pushMessage);

                    // 2. 推送成功后，主动断开连接（指定关闭码和原因）
                    // 关闭码1000：正常关闭；原因说明便于客户端排查
                    targetConn.close(1000, "推送消息后主动断开连接");
                    System.out.println("已主动断开与用户1001的连接");

                    // 3. 立即清理映射关系（避免内存泄漏）
                    USER_CONNECTIONS.remove("1001");
                    CONNECTION_USERS.remove(targetConn);
                    ALL_CONNECTIONS.remove(targetConn);
                } else {
                    System.out.println("用户1001已断开连接，取消消息推送");
                }
            }, 10, TimeUnit.SECONDS); // 延迟60秒（1分钟）
        }
    }

    /**
     * 收到客户端消息时触发
     */
    @Override
    public void onMessage(WebSocket conn, String message) {
        String senderId = CONNECTION_USERS.get(conn);
        if (senderId == null) {
            conn.send("错误：未识别的用户连接");
            return;
        }

        String clientIp = conn.getRemoteSocketAddress().getAddress().getHostAddress();
        System.out.println("用户 " + senderId + "（IP：" + clientIp + "）发送消息：" + message);

        // 回复当前用户
        conn.send("服务端已收到你的消息：" + message);
    }

    /**
     * 客户端断开连接时触发：清理映射 + 避免定时任务无效执行
     */
    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        ALL_CONNECTIONS.remove(conn);
        String userId = CONNECTION_USERS.get(conn);

        if (userId != null) {
            USER_CONNECTIONS.remove(userId);
            CONNECTION_USERS.remove(conn);
            System.out.println("用户 " + userId + " 断开连接，原因：" + reason);
            // 广播下线消息
            broadcastMessage("【系统】用户 " + userId + " 已下线，当前在线人数：" + USER_CONNECTIONS.size());
        } else {
            String clientIp = conn.getRemoteSocketAddress().getAddress().getHostAddress();
            System.out.println("未知用户（IP：" + clientIp + "）断开连接，原因：" + reason);
        }
    }

    /**
     * 连接异常时触发
     */
    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
        if (conn != null) {
            String userId = CONNECTION_USERS.get(conn);
            if (userId != null) {
                USER_CONNECTIONS.remove(userId);
                CONNECTION_USERS.remove(conn);
            }
            ALL_CONNECTIONS.remove(conn);
        }
    }

    @Override
    public void onStart() {
        System.out.println("带定时推送的WebSocket服务端已启动，监听端口：" + getPort());
        setConnectionLostTimeout(60); // 60秒无活动自动断开
    }

    // ---------------------- 工具方法 ----------------------

    /**
     * 从URL解析用户ID
     */
    private String parseUserIdFromUrl(String resourceDescriptor) {
        try {
            URI uri = new URI("ws://localhost" + resourceDescriptor);
            String query = uri.getQuery();
            if (query == null) return null;

            for (String param : query.split("&")) {
                String[] keyValue = param.split("=");
                if (keyValue.length == 2 && "userId".equals(keyValue[0])) {
                    return keyValue[1];
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 广播消息给所有用户
     */
    public void broadcastMessage(String message) {
        for (WebSocket conn : ALL_CONNECTIONS) {
            if (conn.isOpen()) {
                conn.send(message);
            }
        }
    }

    /**
     * 关闭服务端时，优雅关闭定时线程池
     */
    @Override
    public void stop() throws InterruptedException {
        scheduler.shutdown(); // 关闭定时线程池
        super.stop();
        System.out.println("服务端已停止，定时线程池已关闭");
    }

    // ---------------------- 启动服务端 ----------------------
    public static void main(String[] args) {
        int port = 8888;
        TimedPushWebSocketServer server = new TimedPushWebSocketServer(port);
        try {
            server.start();
            System.out.println("服务端启动成功，监听端口：" + port);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("服务端启动失败：" + e.getMessage());
        }
    }
}
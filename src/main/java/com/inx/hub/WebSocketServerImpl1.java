package com.inx.hub;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Java WebSocket 服务端
 * 功能：监听连接、接收客户端消息、向客户端发送消息、广播消息
 */
public class WebSocketServerImpl1 extends WebSocketServer {

    // 存储所有在线客户端连接（线程安全）
    private static final Set<WebSocket> CONNECTIONS = Collections.newSetFromMap(new ConcurrentHashMap<>());

    // 构造方法：指定服务端端口（例如 8888）
    public WebSocketServerImpl1(int port) {
        super(new InetSocketAddress(port));
    }

    // 客户端连接成功时触发
    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        CONNECTIONS.add(conn);
        String clientIp = conn.getRemoteSocketAddress().getAddress().getHostAddress();

        System.out.println("客户端连接成功：" + clientIp);
        System.out.println("客户端连接成功：" + conn.getRemoteSocketAddress().toString());

        // 向新连接的客户端发送欢迎消息
        conn.send("欢迎连接 WebSocket 服务端！");
    }

    // 收到客户端消息时触发
    @Override
    public void onMessage(WebSocket conn, String message) {
        String clientIp = conn.getRemoteSocketAddress().getAddress().getHostAddress();
        System.out.println("收到客户端 " + clientIp + " 的消息：" + message);

        // 示例1：回复当前客户端（echo 回声功能）
        conn.send("服务端已收到：" + message);

        // 示例2：广播消息（发给所有在线客户端）
        broadcast("客户端 " + clientIp + " 说：" + message);
    }

    // 客户端断开连接时触发
    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        CONNECTIONS.remove(conn);
        String clientIp = conn.getRemoteSocketAddress().getAddress().getHostAddress();
        System.out.println("客户端断开连接：" + clientIp + "，原因：" + reason);
    }

    // 连接发生异常时触发
    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
        if (conn != null) {
            CONNECTIONS.remove(conn);
            System.out.println("客户端连接异常，已移除连接");
        }
    }

    // 服务端启动成功时触发
    @Override
    public void onStart() {
        System.out.println("WebSocket 服务端已启动，监听端口：" + getPort());
        setConnectionLostTimeout(60); // 60秒无通信则自动断开连接
    }

    // 广播消息到所有在线客户端
    public void broadcast(String message) {
        for (WebSocket conn : CONNECTIONS) {
            if (conn.isOpen()) { // 确保连接是打开状态
                conn.send(message);
            }
        }
    }

    // 主方法：启动服务端
    public static void main(String[] args) {
        int port = 8888; // 服务端端口，需与客户端配置一致
        WebSocketServer server = new WebSocketServerImpl1(port);
        server.start(); // 启动服务
    }
}
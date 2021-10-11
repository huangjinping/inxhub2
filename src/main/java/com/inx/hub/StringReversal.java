package com.inx.hub;

public class StringReversal {
        /**
         * 反转字符串（循环交换）
         * 其他字符串反转的方法
         * 1、java的api：StringBuffer的reverse方法
         * 2、利用栈的特性（先进后出）
         * 3、反向遍历字符串
         * @param from
         * @return
         */
        public static String reChange(String from){
            char[] froms = from.toCharArray();
            int length = froms.length;
            for (int i = 0; i < length/2; i++){
                char temp = froms[i];
                froms[i] = froms[length - 1 -i];
                froms[length - 1 -i] = temp;
            }
            return String.valueOf(froms);
        }

        /**
         * 循环左移index位字符串
         * 思想：先部分反转，后整体反转
         * @param from
         * @param index
         * @return
         */
        public static String leftMoveIndex(String from,int index){
            String first = from.substring(0,index);
            String second = from.substring(index);
            first = reChange(first);
            second = reChange(second);
            from = first + second;
            from = reChange(from);
            return from;
        }

        /**
         * 循环右移index位字符串
         * 思想：先整体反转，后部分反转
         * @param from
         * @param index
         * @return
         */
        public static String rightMoveIndex(String from,int index){
            from = reChange(from);
            String first = from.substring(0,index);
            String second = from.substring(index);
            first = reChange(first);
            second = reChange(second);
            from = first + second;
            return from;
        }

//        public static void start() {
//            String leftString = "abcdefg11111111111";
//            System.out.println("左移2位字符串结果："+leftMoveIndex(leftString,2));
//            String rightString = "cdefg11111111111ab";
//            System.out.println("右移2位字符串结果："+rightMoveIndex(rightString,2));
//
//        }

    public static String encode(String data) {
    //把字符串转为字节数组
        byte[] b = data.getBytes();
        //遍历
        for(int i=0;i<b.length;i++) {
            b[i] += 1;//在原有的基础上+1
        }
        return new String(b);
    }

    public static String decode(String data) {
        //把字符串转为字节数组
        byte[] b = data.getBytes();
        //遍历
        for(int i=0;i<b.length;i++) {
            b[i] -= 1;//在原有的基础上-1
        }
        return new String(b);
    }

//    public static void start2() {
//        //加密英文
//        String data = "ABCDEFG";
//        String result = encode(data);
//        System.out.println("加密后:"+result);
//        //解密
//        String str = decode(result);
//        System.out.println("解密后:"+str);
//
//
//        //加密中文
//        data = "跳梁小豆tlxd666";
//        result = encode(data);
//        System.out.println("加密后:"+result);
//        String str1 = decode(result);
//        System.out.println("解密后:"+str1);
//    }


    public static String  parseFormat(String password,String ...args){
        StringBuffer buffer=new StringBuffer();
        password=decode(password);
            try {
                String[] split = password.split("[%]s");
                for (int i = 0; i < split.length; i++) {
                    buffer.append(split[i]);
                    if ((args.length)>i){
                        buffer.append(args[i]);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

return buffer.toString();
    }
}

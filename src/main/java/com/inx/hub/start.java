package com.inx.hub;

import com.google.gson.Gson;
import com.inx.hub.bean.Doc;
import com.inx.hub.callback.Callback;
import com.inx.hub.utils.Converter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class start {


    public static void main(String[] args) {



        String naisdhie="DC:BC:56:26:4F:13:D3:35:C7:0A:52:C8:EE:0D:C8:9C:83:79:E2:1F:0B:32:EF:56:E1:9F:C9:1A:5A:E0:51:54";
        System.out.println(naisdhie.toLowerCase());

//        List<Doc> docList = new ArrayList<>();
//        docList.add(new Doc());
//        docList.add(new Doc());
//        docList.add(new Doc());
//        docList.add(new Doc());
//        docList.add(new Doc());
//
//
//        List<Doc> mesgs = new ArrayList<>();
//        mesgs = docList.subList(0, 4);
//        Gson gson = new Gson();
//        System.out.println(gson.toJson(mesgs));
//
//        try {
//
//        }catch (Exception E){
//            E.printStackTrace();
//        }finally {
//
//        }

//        String[] mesg={"1","2","3","4"};
//        StringBuffer buffer=new StringBuffer();
//        for (int i = 0; i < mesg.length; i++) {
//            buffer.append("mesg"+i).append("\n");
//        }
//        witermessage(buffer.toString(),"shi.java");

//        Calendar calendar=Calendar.getInstance();

//        startFile();
//        actiona();
//        copyDir("/Users/huhuijie/Documents/git/indexmodel2023", "/Users/huhuijie/Downloads/jsonmode");


//        String str1 = "  1R.id.bottom1  R.id.bottom1  R.id.bottom 1R.id.bottom";
////        str = str.replace("R.string.name(?!<=[_0-9a-zA-Z])", "111");
//
//        String str = Pattern.compile("R.id.bottom(?![_0-9a-zA-Z])").matcher(str1).replaceAll("111");
//        System.out.println(str);
//
//        str = Pattern.compile("(?<![_0-9a-zA-Z])R.id.bottom").matcher(str1).replaceAll("111");
//        System.out.println(str);
//
//        str = Pattern.compile("(?<![_0-9a-zA-Z])R.id.bottom(?![_0-9a-zA-Z])").matcher(str1).replaceAll("111");
//
//        System.out.println(str);
//
//        testview1(new SimpleCallBack<List<User>>() {
//            @Override
//            public void onResponse(List<User> response, int id) {
//                for (User user : response) {
//                    System.out.println(user.toString());
//                }
//                System.out.println(response.toString());
//            }
//        });


//        deepCopy();


    }

    private static void testview1(Callback callback) {
        String json = "{\n" +
                "  \"code\": 10,\n" +
                "  \"msg\": \"文件处理\",\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"name\": \"test1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"test1\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
//        json = "{\n" +
//                "  \"code\": 12,\n" +
//                "  \"msg\": \"文件出力\",\n" +
//                "  \"data\": {\n" +
//                "    \"name\": \"测试\"\n" +
//                "  }\n" +
//                "}";
//        Object o = callback.parseNetworkResponse(json, 1);
//        callback.onResponse(o, 1);


    }


    public static void copyDir(String sourcePath, String newPath) {
        System.out.println("dddd");
        try {
            (new File(newPath)).mkdirs();
            // 与mkdir()都创建文件夹 ，mkdirs()如果父文件夹不存在也会创建
            File fileList = new File(sourcePath);
            String[] strName = fileList.list();
            File temp = null;//游标
            for (int i = 0; i < strName.length; i++) {
                // 如果源文件路径以分隔符File.separator /或者\结尾那就sourcePath
                if (sourcePath.endsWith(File.separator)) {
                    temp = new File(sourcePath + strName[i]);
                } else {
                    temp = new File(sourcePath + File.separator + strName[i]);
                }
                if (temp.isFile()) {
                    // 如果游标遇到文件
                    FileInputStream in = new FileInputStream(temp);
                    // 复制且改名
                    File file = new File(newPath + "/" + temp.getName().toString());
                    FileOutputStream out = new FileOutputStream(file);
                    byte[] buffer = new byte[1024 * 8];
                    int length;
                    while ((length = in.read(buffer)) != -1) {

                        out.write(buffer, 0, length);
                    }
                    out.flush();
                    out.close();
                    in.close();
                }
                // 如果游标遇到文件夹
                if (temp.isDirectory()) {
                    copyDir(sourcePath + "/" + strName[i], newPath + "/" + strName[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("文件夹复制失败!");
        }
    }


    private static void readFile() {

    }


//    /**
//     * 替换所有正则匹配的部分
//     *
//     * @param input       要替换的字符串
//     * @param regex       正则表达式
//     * @param replacement 代替者
//     * @return 替换所有正则匹配的部分
//     */
//    public static String getReplaceAll(final String input,
//                                       final String regex,
//                                       final String replacement) {
//        if (input == null) return null;
//        return Pattern.compile(regex).matcher(input).replaceAll(replacement);
//    }

    private static void actiona() {
        String line = "Collect contacts’ information to assess your risk and credit score as a part of\n" +
                "    our loan journey, we require references from the loan applicant. The more credible the\n" +
                "    references is, the lower risk associated with a User.\n" +
                "    The information of contacts will be uploaded to the server (https://www.lendonpk.com/)\n" +
                "    and it will not be shared with any other people or companies.";
//        line="\n" +
//                "Collect and monitor financial and non-personal SMS for transactional details and amounts. It will be used for calculating eligibility and assessing customer risk. Other SMS will not be evaluated. We verify and track users financial transactions in the background by analyzing their SMS to make a proper decision about the line of credit which is based on the evaluation of their spending budget and ability to pay. The SMS information will be uploaded to the server (https://www.lendonpk.com/) but it will not be shared with any other people or companies.";
//line="This account is your loan receiving account, please fill in accurately";
//        line="The account number entered for the second time is inconsistent";
//        System.out.println(StringReversal.encode(line));
//
//        line="The account number entered for the second time is inconsistent";
//        System.out.println(StringReversal.encode(line));
        String[] arr = {"Under Review", "Pending Repayment", "Overdue %s days"};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(StringReversal.encode(arr[i]));
        }
    }

    private static void startsFile() {
        File file = new File("./", "res/shi2");
        StringBuffer buffer = new StringBuffer();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                if (line.length() > 0) {
                    buffer.append("public static  final  String " + line.trim().toUpperCase() + " = StringReversal.decode(\"" + StringReversal.encode(line) + "\");");
                    buffer.append("\n");
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        witermessage(buffer.toString(), "ApiJson.java");

    }

    private static void startFile() {
        File file = new File("./", "res/shi2");
        StringBuffer buffer = new StringBuffer();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                if (line.length() > 0) {
                    String source = line.trim().toUpperCase();

                    buffer.append("public static  final  String " + "chburocredito" + source + "= Converter.toMap(\"" + Converter.toMap(line) + "\");");
//                    buffer.append("public static  final  String " + line.trim().toUpperCase() + " = AESUtil.decrypt(\"" + AESUtil.encrypt(line, "fc7b85511b89f52afa67f937436d158a") + "\");");
                    buffer.append("\n");
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        witermessage(buffer.toString(), "ApiJson.java");

    }

    private static void witermessage(String source, String fileName) {
        try {
            File drawableFile = new File("./", "res/" + fileName);
            if (!drawableFile.getParentFile().exists()) {
                drawableFile.getParentFile().mkdirs();
            }
            if (!drawableFile.exists()) {
                drawableFile.createNewFile();
            }
            FileWriter writer = null;
            try {
                writer = new FileWriter(drawableFile);
                writer.write(source);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void deepCopy(File srcFile, String destFile) {
        System.out.println("deepCopy");

        try {
            File file = srcFile;
            InputStream stream = new FileInputStream(file);
            byte[] content = new byte[(int) file.length()];
            stream.read(content);
            stream.close();

            File file2 = new File("file.txt");
            FileOutputStream fos = new FileOutputStream(file2);
            fos.write(content);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

package com.inx.hub;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InsertJunkCodeUtil {

    //////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 包名, 用于导包
     */
    private static final String pkgName = "com.limon.prestamo.android.es";

    /**
     * java/kotlin代码所在目录
     */
    private static final String PROJECT_PATH = File.separator
            + "app" + File.separator
            + "src" + File.separator
            + "main" + File.separator
            + "java" + File.separator
            + "com" + File.separator
            + "limon" + File.separator
            + "prestamo" + File.separator
            + "android" + File.separator
            + "es" + File.separator;

    /**
     * layout目录
     */
    private static final String PROJECT_PATH_RES_LAYOUT = File.separator
            + "app" + File.separator
            + "src" + File.separator
            + "main" + File.separator
            + "res" + File.separator
            + "layout" + File.separator;


    /**
     * 当前工具类所在目录不需插入垃圾代码
     */
    private static final String CODE_TEMPLATE = "builds";
    private static final String RES_TEMPLATE = "res";
    private static final String JAVA_TEMPLATE = "java";
    private static final String KOTLIN_TEMPLATE = "ftl/kotlin1.ftl";

    /**
     * 垃圾代码文件名
     */
    private static final String FILE_NAME_JAVA_CODE = "javaCode";
    private static final String FILE_NAME_RES_LAYOUT = "resLayout";
    private static final String FILE_NAME_KOTLIN_CODE = "kotlinCode";

    /**
     * 垃圾代码后面的数字， 用于随机获取垃圾代码文件
     */
    private static final int javaCodeLen = 100;
    private static final int kotlinCodeLen = 100;
    private static final int layoutCodeLen = 200;


    //////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {

        String rootPath = getProjectPath(); // D:\\workspace\\codeBackups\\RupeeAdda
        String path = rootPath + PROJECT_PATH;
        String pathRes = rootPath + PROJECT_PATH_RES_LAYOUT;
        System.out.println("rootPath" + rootPath);
        System.out.println("path" + path);
        // 遍历工程所有文件并插入垃圾代码
        insertJunkCode(path);
//        insertJunkRes(pathRes);
    }


    private static String getProjectPath() {
        File directory = new File("");//设定为当前文件夹
        return directory.getAbsolutePath();
    }

    /**
     * 读取垃圾代码
     *
     * @return
     */
    private static String readJavaJunkCodes() {
        Random ra = new Random();
        int nextInt = ra.nextInt(javaCodeLen);
        String readCode = readCode(getProjectPath() + PROJECT_PATH
                + CODE_TEMPLATE + File.separator
                + JAVA_TEMPLATE + File.separator
                + FILE_NAME_JAVA_CODE + nextInt);
        return readCode;
    }

    /**
     * 读取垃圾代码
     *
     * @return
     */
    private static String readLayoutJunkCodes() {
        Random ra = new Random();
        int nextInt = ra.nextInt(layoutCodeLen);
        String readCode = readCode(getProjectPath() + PROJECT_PATH
                + CODE_TEMPLATE + File.separator
                + RES_TEMPLATE + File.separator
                + FILE_NAME_RES_LAYOUT + nextInt);
        return readCode;
    }

    private static String readKotlinJunkCodes() {
        Random ra = new Random();
        int nextInt = ra.nextInt(kotlinCodeLen);
        String readCode = readCode(getProjectPath() + PROJECT_PATH
                + CODE_TEMPLATE + File.separator
                + KOTLIN_TEMPLATE + File.separator
                + FILE_NAME_KOTLIN_CODE + nextInt);
        return readCode;
    }

    /**
     * 读取指定路径文件代码
     *
     * @param Path
     * @return
     */
    public static String readCode(String Path) {
        BufferedReader reader = null;
        StringBuilder lastStr = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                lastStr.append(tempString).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("读取指定路径文件代码: " + e.toString());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lastStr.toString();
    }


    static int count = 0;

    /**
     * 遍历工程所有文件并插入垃圾代码
     *
     * @param path
     */
    public static void insertJunkCode(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File file2 : files) {
                    String absolutePath = file2.getAbsolutePath();
                    if (file2.isDirectory()) {
                        insertJunkCode(absolutePath);
                    } else {
                        count++;
                        if (!absolutePath.contains(CODE_TEMPLATE)) {
                            if (absolutePath.endsWith(".java")) {
                                // java
                                String s = readJavaFile(absolutePath);
                                writerFile(absolutePath, s);
                                String s1 = readFileJavaSuper(absolutePath);
                                writerFile(absolutePath, s1);
                                System.out.println(absolutePath + "\n------------------------------> Insert junk code is complete!!!");
                            } else if (absolutePath.endsWith(".kt")) {
                                // kotlin
                                String kotlinStr = readKotlinFile(absolutePath);
                                writerFile(absolutePath, kotlinStr);
                                String kotlinStr1 = readFileKotlinSuper(absolutePath);
                                writerFile(absolutePath, kotlinStr1);
                                System.out.println(absolutePath + "\n------------------------------> Insert junk code is complete!!!");
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在!!!");
        }
        System.out.println("file count: " + count);
    }

    private static void insertJunkRes(String pathRes) {

        File file = new File(pathRes);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File file2 : files) {
                    String absolutePath = file2.getAbsolutePath();
                    if (file2.isDirectory()) {
                        insertJunkCode(absolutePath);
                    } else {
                        count++;
                        if (!absolutePath.contains(CODE_TEMPLATE)) {
                            if (absolutePath.endsWith(".xml")) {
                                // layout
                                String s = readLayoutFile(absolutePath);
                                writerFile(absolutePath, s);
                                System.out.println(absolutePath + "\n------------------------------> Insert junk layout is complete!!!");
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在!!!");
        }
        System.out.println("file count: " + count);
    }

    private static String readLayoutFile(String absolutePath) {
        List<String> list = new ArrayList<>();
        BufferedReader reader = null;
        StringBuilder lastStr = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(absolutePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                list.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("readLayoutFile: " + e.toString());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String currentLine = list.get(i);
            if (currentLine.contains("<TextView")
                    || currentLine.contains("<" + pkgName + ".limon882view.LimTextView")) {
                newList.add(readLayoutJunkCodes());
            }
            newList.add(currentLine);
        }
        for (String s : newList) {
            lastStr.append(s).append("\n");
        }
        return lastStr.toString();
    }


    /**
     * 遍历工程所有文件, 将普通方法插入垃圾代码, 转出字符串
     *
     * @param path
     * @return
     */
    public static String readJavaFile(String path) {
        List<String> list = new ArrayList<>();
        BufferedReader reader = null;
        StringBuilder lastStr = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                list.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("readJavaFile: " + e.toString());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String currentLine = list.get(i);
            if (currentLine.endsWith("){") || currentLine.endsWith(") {")
                    || currentLine.endsWith(")  {") || currentLine.endsWith(")   {")) {
                if (currentLine.contains("void") || currentLine.contains("public")
                        || currentLine.contains("protected") || currentLine.contains("private")) {
                    String nextLine = list.get(i + 1);
                    if (!nextLine.contains("this(") && !nextLine.contains("super")
                            && !currentLine.contains("=") && !currentLine.contains("/")) {
                        newList.add(currentLine);
                        newList.add(readJavaJunkCodes());
                    } else {
                        newList.add(currentLine);
                    }
                } else {
                    newList.add(currentLine);
                }
            } else {
                newList.add(currentLine);
            }
            String importStr = "import java.util.ArrayList;\n" +
                    "import java.util.HashMap;\n" +
                    "import java.util.List;\n" +
                    "import java.util.List;\n" +
                    "import java.util.Collections;\n" +
                    "import android.util.Log;\n" +
                    "import java.util.Arrays;\n" +
                    "import java.util.Calendar;\n" +
                    "import android.os.Build;\n" +
                    "import " + pkgName + ".BuildConfig;\n" +
                    "import java.util.Map;";

            if (currentLine.contains("package ") && !currentLine.contains("_package")) {
                newList.add(importStr);
            }
        }
        for (String s : newList) {
            lastStr.append(s).append("\n");
        }
        return lastStr.toString();
    }

    public static String readKotlinFile(String path) {
        List<String> list = new ArrayList<>();
        BufferedReader reader = null;
        StringBuilder lastStr = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                list.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("readKotlinFile: " + e.toString());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String currentLine = list.get(i);
            if (currentLine.endsWith("){")
                    || currentLine.endsWith(") {")
                    || currentLine.endsWith(")  {")
                    || currentLine.endsWith(")   {")
                    || currentLine.endsWith("init{")
                    || currentLine.endsWith("init {")
                    || currentLine.endsWith("{")
            ) {
                if (currentLine.contains("fun")
                        || currentLine.endsWith("init{")
                        || currentLine.endsWith("init {")
                ) {
                    String nextLine = list.get(i + 1);
                    if (!nextLine.contains("this(")
                            && !nextLine.contains("super")
                            && !currentLine.contains("=")
                            && !currentLine.contains("/")
                            && !currentLine.contains("object")
                            && !currentLine.contains("constructor")
                            && !currentLine.contains("class")
                    ) {
                        newList.add(currentLine);
                        newList.add(readKotlinJunkCodes());
                    } else {
                        newList.add(currentLine);
                    }
                } else {
                    newList.add(currentLine);
                }
            } else {
                newList.add(currentLine);
            }
        }
        for (String s : newList) {
            lastStr.append(s).append("\n");
        }
        return lastStr.toString();
    }


    /**
     * 遍历工程所有文件, 将包含super()和this()的方法插入垃圾代码, 转出字符串
     *
     * @param absolutePath
     * @return
     */
    private static String readFileJavaSuper(String absolutePath) {
        List<String> list = new ArrayList<>();
        BufferedReader reader = null;
        StringBuilder lastStr = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(absolutePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                list.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("readFileJavaSuper: " + e.toString());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String currentLine = list.get(i);
            if ((currentLine.contains("this(") || (currentLine.contains("super")
                    && !currentLine.contains("return")))
                    && !currentLine.contains("/")) {
                newList.add(currentLine);
                newList.add(readJavaJunkCodes());
            } else {
                newList.add(currentLine);
            }
        }
        for (String s : newList) {
            lastStr.append(s).append("\n");
        }
        return lastStr.toString();
    }

    private static String readFileKotlinSuper(String absolutePath) {
        List<String> list = new ArrayList<>();
        BufferedReader reader = null;
        StringBuilder lastStr = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(absolutePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                list.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("readFileKotlinSuper: " + e.toString());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String currentLine = list.get(i);
            if ((currentLine.contains("this(") || (currentLine.contains("super")
                    && !currentLine.contains("return")))
                    && !currentLine.contains("/")
                    && !currentLine.contains("=")
                    && !currentLine.contains("constructor")
            ) {
                newList.add(currentLine);
                newList.add(readKotlinJunkCodes());
            } else {
                newList.add(currentLine);
            }
        }
        for (String s : newList) {
            lastStr.append(s).append("\n");
        }
        return lastStr.toString();
    }

    /**
     * 将插入垃圾代码的字符串, 写入到指定路径(覆盖工程原文件)
     *
     * @param path
     * @param content
     */
    public static void writerFile(String path, String content) {
        File file = new File(path);
        FileOutputStream out = null;
        try {
            if (!file.exists()) {
                // 先得到文件的上级目录，并创建上级目录，在创建文件
//                file.getParentFile().mkdir();
                file.createNewFile();
            }
            //创建文件输出流
            out = new FileOutputStream(file);
            //将字符串转化为字节
            byte[] byteArr = content.getBytes();
            out.write(byteArr);
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.toString());
        }
    }
}

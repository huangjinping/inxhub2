package com.inx.hub;

import com.inx.hub.bean.DocUtils;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class javaClient {


    private static final String PACKAGE = "com.imooc.sourcecode.java.javapoet.test2";

    public static void main(String[] args) {
//        testCreateUser();
//        testCreateClient();
//        testmessage();
        createClass();
    }


    private static void createClass() {
        TypeSpec.Builder typeBuilder = TypeSpec.classBuilder("temp");
        typeBuilder.addModifiers(Modifier.PUBLIC);
        MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(DocUtils.getRadomWord());
        generateMethods(methodBuilder);
        typeBuilder.addMethod(methodBuilder.build());
        JavaFile.Builder fileBuilder = JavaFile.builder("temp", typeBuilder.build());
        JavaFile javaFile = JavaFile.builder(PACKAGE, typeBuilder.build())
                .build();


        try {
            fileBuilder.build().writeTo(new File("template", "sss"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String source = javaFile.toString();
        //去掉类
        int start = source.indexOf("{");
        int end = source.lastIndexOf("}");
        source = source.substring(start + 1, end);
        System.out.println(source);

        //去掉方法
        start = source.indexOf("{");
        end = source.lastIndexOf("}");
        source = source.substring(start + 1, end);
        System.out.println(source);
    }


    private static void generateMethods(MethodSpec.Builder methodBuilder) {
        int index = DocUtils.getRandomInt(5);

        Random random = new Random();
        int temp = random.nextInt();
        methodBuilder.addParameter(Integer[].class, "show");
        methodBuilder.beginControlFlow("try")
                .addStatement("throw new Exception($S)", "input  Errir  unkown  exception" + temp)
                .nextControlFlow("catch ($T e)", Exception.class)
                .addStatement("throw new $T(e)", RuntimeException.class)
                .endControlFlow();
    }

    private static void testmessage() {
        final String PACKAGE = "com";
        CodeBlock mainCodeBlock = CodeBlock
                .builder()
                .build();
        MethodSpec methodSpec = MethodSpec.methodBuilder("cihise")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addCode(mainCodeBlock)
                .build();
        TypeSpec client = TypeSpec.classBuilder("suuehid")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(methodSpec)
                .build();
        JavaFile javaFile = JavaFile.builder(PACKAGE, client)
                .build();
        String source = javaFile.toString();
        try {
            javaFile.writeTo(new File("template", "sss"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int start = source.indexOf("{");
        String result = source.substring(start + 1, source.length() - 2);
        System.out.println(result);
        FileUtils.witermessage(result, "template/java/java1");

    }


//    //创建一个调用实体类的类
//    private static void testCreateClient() {
////定义实体类
//        ClassName user = ClassName.get(PACKAGE, "User");
////创建代码块
//        CodeBlock mainCodeBlock = CodeBlock
//                .builder()
//                .addStatement("$T $L = new $T", user, "user", user)
//                .addStatement("$T.out.println($L.$L())", System.class, "user", "getUserName")
//                .build();
////创建main方法
//        MethodSpec mainMethod = MethodSpec
//                .methodBuilder("main")
//                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
//                .returns(void.class)
//                .addParameter(String[].class, "args")
//                .addCode(mainCodeBlock)
//                .build();
////创建类
//        TypeSpec client = TypeSpec.classBuilder("javaClient")
//                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
//                .addMethod(mainMethod)
//                .build();
//
//        JavaFile javaFile = JavaFile.builder(PACKAGE, client)
//                .build();
//
//        System.out.println(javaFile.toString());
//    }
//
//
//    //创建一个带注解的实体类
//    private static void testCreateUser() {
//
////创建一个属性
//        FieldSpec userNameField = FieldSpec
//                .builder(String.class, "userName") // 定义属性类型和属性名称
//                .addModifiers(Modifier.PRIVATE)    // 定义属性修饰符
//                .build();
////创建一个无参构造方法
//        MethodSpec noArgsContructor = MethodSpec
//                .constructorBuilder()
//                .addModifiers(Modifier.PUBLIC)  // 定义属性修饰符
//                .build();
////创建一个参数
//        ParameterSpec userNameParam = ParameterSpec
//                .builder(String.class, "userName") // 定义参数类型和参数名称
//                .build();
////创建一个有参构造方法
//        MethodSpec allArgsContructor = MethodSpec
//                .constructorBuilder()
//                .addModifiers(Modifier.PUBLIC)
//                .addParameter(userNameParam)
//                .addStatement("this.$N = $N", userNameParam, userNameParam) // 定义语句
//                .build();
////创建一个注解
//        AnnotationSpec getterAnnotation = AnnotationSpec
//                .builder(Getter.class)
//                .build();
////创建一个注解
//        AnnotationSpec setterAnnotation = AnnotationSpec
//                .builder(Setter.class)
//                .build();
////创建一个类
//        TypeSpec user = TypeSpec.classBuilder("User")
//                .addModifiers(Modifier.PUBLIC, Modifier.FINAL) // 定义类修饰符
//                .addField(userNameField)                       // 添加属性
//                .addAnnotation(getterAnnotation)               // 添加注解
//                .addAnnotation(setterAnnotation)
//                .addMethod(noArgsContructor)                   // 添加构造方法
//                .addMethod(allArgsContructor)
//                .build();
//
//        JavaFile javaFile = JavaFile.builder(PACKAGE, user)
//                .build();
////代码生成，转换成字符串
//        System.out.println(javaFile.toString());
//    }
}

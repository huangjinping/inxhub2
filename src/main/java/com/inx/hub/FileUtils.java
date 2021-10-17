package com.inx.hub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileUtils {


    public static void witermessage(String source, String fileName) {
        try {
            File drawableFile = new File("./", fileName);
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


    public static String readFile(String fileName) {
        File file = new File("./", fileName);
        StringBuffer buffer = new StringBuffer();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                if (line.length()>0){
                    buffer.append(line);
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }

}

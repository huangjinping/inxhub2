package com.inx.hub;

import java.io.File;
import java.io.FileWriter;

public class FileUtils {


    public static void witermessage(String source, String fileName) {
        try {
            File drawableFile = new File("./",   fileName);
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
}

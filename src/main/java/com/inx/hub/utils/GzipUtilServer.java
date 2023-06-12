package com.inx.hub.utils;

import com.inx.hub.FileUtils;
import com.inx.hub.InsertJunkCodeUtil;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipUtilServer {


    public static String uncompress(InputStream gzippedResponse) throws IOException {

        InputStream decompressedResponse = new GZIPInputStream(gzippedResponse);
        Reader reader = new InputStreamReader(decompressedResponse, "UTF-8");
        StringWriter writer = new StringWriter();

        char[] buffer = new char[10240];
        for (int length = 0; (length = reader.read(buffer)) > 0; ) {
            writer.write(buffer, 0, length);
        }

        writer.close();
        reader.close();
        decompressedResponse.close();
        gzippedResponse.close();

        return writer.toString();
    }

    public static String uncompressToString(byte[] bytes, String encoding) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString(encoding);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String gzip(String data) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            byte[] buffer = data.getBytes("utf-8");
            try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)) {
                gzipOutputStream.write(buffer);
            }

            return new sun.misc.BASE64Encoder().encode(outputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            String outPath = "/Users/huhuijie/Downloads/254out/";
            String inputPath = "/Users/huhuijie/Downloads/254/";

            File file = new File(inputPath);
            if (file.exists()) {
                File[] files = file.listFiles();
                for (File cfile : files) {
                    System.out.println("=========" + cfile.getAbsolutePath());
                    String json = FileUtils.getTextByPath(cfile.getAbsolutePath());
                    String uncompress = GzipUtilServer.uncompressToString(Base64Utils.decode(json), "UTF-8");
                    System.out.println(uncompress);
                    InsertJunkCodeUtil.writerFile(outPath + cfile.getName(), uncompress);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

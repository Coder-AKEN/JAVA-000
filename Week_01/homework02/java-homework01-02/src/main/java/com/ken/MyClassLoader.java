package com.ken;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        final String filePath = "parse-files/Hello.xlass";
        final String className = "Hello";
        final int value = 255;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int readData;
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath);
            while ((readData=inputStream.read()) != -1) {
                readData = value - readData;
                byteArrayOutputStream.write(readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return defineClass(className, byteArray, 0, byteArray.length);
    }

}

package com.ken;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        final String className = "Hello";
        final String methodName = "hello";

        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> loadClass = myClassLoader.loadClass(className);

        Method method = loadClass.getDeclaredMethod(methodName);
        method.invoke(loadClass.getDeclaredConstructor().newInstance());

        System.out.println("OK!");
    }

}

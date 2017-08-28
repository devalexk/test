package edu.olezha.jsandbox;

/*
* JVM -verbose:class
* */
public class Classloader {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader currentClassloader = Classloader.class.getClassLoader();
        System.out.println("System Classloader: " + currentClassloader);

        ClassLoader contextClassloader = Thread.currentThread().getContextClassLoader();
        System.out.println("Context Classloader: " + contextClassloader);

        currentClassloader.loadClass("edu.olezha.jsandbox.math.Str");
    }

}

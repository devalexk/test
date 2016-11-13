package edu.olezha.jsandbox.multithreading.lang;

/**
 * Created by oleh on 13.11.16.
 * see cpu in terminal htop
 */
public class ExtendsThreadApp {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis() + " start without multithreading");

        for (int i = 0; i < 10; i++) {
            ExtendsThreadSingleProcess extendsThreadSingleProcess = new ExtendsThreadSingleProcess(i);
            extendsThreadSingleProcess.run();
        }

        System.out.println(System.currentTimeMillis() + " finish without multithreading\n");


        System.out.println(System.currentTimeMillis() + " start with multithreading");

        for (int i = 0; i < 10; i++) {
            ExtendsThreadSingleProcess extendsThreadSingleProcess = new ExtendsThreadSingleProcess(i);
            extendsThreadSingleProcess.start();
        }

        System.out.println(System.currentTimeMillis() + " finish with multithreading");
    }

}

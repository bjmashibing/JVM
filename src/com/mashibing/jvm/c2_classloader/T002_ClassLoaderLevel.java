package com.mashibing.jvm.c2_classloader;

public class T002_ClassLoaderLevel {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(sun.awt.HKSCS.class.getClassLoader());
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        System.out.println(T002_ClassLoaderLevel.class.getClassLoader());

        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());
        System.out.println(T002_ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());

        System.out.println(new T006_MSBClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}

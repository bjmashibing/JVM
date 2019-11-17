package com.mashibing.jvm.c3_jmm;

public class T02_PrintMemoryInfo {
    public static void main(String[] args) {
        printMemoryInfo();

        byte[] b = new byte[1024 * 1024];
        System.out.println("-----------------");

        printMemoryInfo();
    }

    private static void printMemoryInfo() {
        System.out.println("total:" + Runtime.getRuntime().totalMemory());
        System.out.println("free :" + Runtime.getRuntime().freeMemory());
    }
}

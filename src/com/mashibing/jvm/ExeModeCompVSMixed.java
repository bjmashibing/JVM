package com.mashibing.jvm;

/**
 * -Xcomp的作用，开启编译模式
 */

public class ExeModeCompVSMixed {
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        for(int i=0; i<1000; i++)
            getMemoryInfo();
        System.out.println(System.currentTimeMillis() - t);
    }

    static String getMemoryInfo() {
        double pi = 3.14;

        for (long i = 0; i < 1_0000L; i++) {
           pi = 3.14/2.58;
           pi = 3.14;
           long t = Runtime.getRuntime().totalMemory();
           new ExeModeCompVSMixed();
        }

        return "";

    }
}

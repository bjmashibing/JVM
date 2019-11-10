package com.mashibing.jvm.c0_basic;

public class TestIPulsPlus {
    public static void main(String[] args) {
        int i = 8;
        //int n = i++;
        //i = i++;
        i = ++i;
        //System.out.println(i);
    }

    void m() {
        new Runnable() {
            @Override
            public void run() {
                new Object();
            }
        };
    }
}

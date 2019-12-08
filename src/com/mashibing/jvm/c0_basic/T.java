package com.mashibing.jvm.c0_basic;

import java.util.ArrayList;
import java.util.List;

public class T {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Runtime r = Runtime.getRuntime();
        long l1 = r.freeMemory();
        for (int i = 0; i < 100_0000; i++) {
            list.add(new Object());
        }
        long l2 = r.freeMemory();
        System.out.println((l1 - l2)/100_0000);
    }
}

package com.mashibing.jvm.c5_gc;

import java.util.concurrent.TimeUnit;

public class T04_CMS_YGC {
    public static void main(String[] args) {
        for(int i=0; i<100000; i++) {
            Object o = new Object();
            o = null;
            try {
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

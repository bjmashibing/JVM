package com.mashibing.jvm.c5_gc;

public class LambdaGC {
    public static void main(String[] args) {
        for(;;) {
            I i = C::n;
        }
    }

    public static interface I {
        void m();
    }

    public static class C {
        static void n() {
            System.out.println("hello");
        }
    }
}

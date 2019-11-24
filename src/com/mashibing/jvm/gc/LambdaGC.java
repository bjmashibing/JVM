package com.mashibing.jvm.gc;


import com.mashibing.jvm.c4_RuntimeDataAreaAndInstructionSet.T05_InvokeDynamic;

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

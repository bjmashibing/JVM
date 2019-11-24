package com.mashibing.jvm.c4_RuntimeDataAreaAndInstructionSet;

public class Hello_04 {
    public static void main(String[] args) {
        Hello_04 h = new Hello_04();
        int i = h.m(3);
    }

    public int m(int n) {
        if(n == 1) return 1;
        return n * m(n-1);
    }
}

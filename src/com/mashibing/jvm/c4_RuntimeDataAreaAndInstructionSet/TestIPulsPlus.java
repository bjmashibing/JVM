package com.mashibing.jvm.c4_RuntimeDataAreaAndInstructionSet;

public class TestIPulsPlus {
    public static void main(String[] args) {
        int i = 8;
        //i = i++;
        i = ++i;
        System.out.println(i);
    }
}

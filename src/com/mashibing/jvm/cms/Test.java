package com.mashibing.jvm.cms;


import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {


        ArrayList<Student> list = new ArrayList<>();
        for(int i = 0;i<6000000;i++){
            list.add(new Student("msb"+i,i));
        }

        try {
            Thread.sleep(10000000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

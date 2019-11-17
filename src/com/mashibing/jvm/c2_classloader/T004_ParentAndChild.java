package com.mashibing.jvm.c2_classloader;

public class T004_ParentAndChild {
    public static void main(String[] args) {
        System.out.println(T004_ParentAndChild.class.getClassLoader());
        System.out.println(T004_ParentAndChild.class.getClassLoader().getClass().getClassLoader());
        System.out.println(T004_ParentAndChild.class.getClassLoader().getParent());
        System.out.println(T004_ParentAndChild.class.getClassLoader().getParent().getParent());
        //System.out.println(T004_ParentAndChild.class.getClassLoader().getParent().getParent().getParent());

    }
}

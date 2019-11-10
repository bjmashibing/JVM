package com.mashibing.jvm.c0_basic;

public class TestIndentityHashCode {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.hashCode());
        System.out.println(System.identityHashCode(o));

        System.out.println("-------------------------");

        T t = new T();
        System.out.println(t.hashCode());
        System.out.println(t.superHashCode());
        System.out.println(System.identityHashCode(t));

        System.out.println("-------------------------");

        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1.hashCode() == s2.hashCode());
        System.out.println(System.identityHashCode(s1) == System.identityHashCode(s2));

    }

    private static final class T {
        @Override
        public int hashCode() {
            return 1;
        }

        public int superHashCode() {
            return super.hashCode();
        }
    }
}

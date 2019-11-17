package com.mashibing.jvm.c3_jmm;

import java.util.ArrayList;
import java.util.List;

/**
 * 内存溢出
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath="c:/tmp/jvm.dump -XX:PrintGCDetails -Xms10M -Xmx10M
 */
public class TestHeapDump {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 100000000; i++) list.add(new byte[1024 * 1024]);

    }
}

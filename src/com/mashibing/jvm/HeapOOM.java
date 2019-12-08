package com.mashibing.jvm;

import java.util.LinkedList;
import java.util.List;

/**
 * test heap out of memory
 *
 * Options: -verbose:c5_gc -Xms20M -Xmx20M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 *
 */

public class HeapOOM {
    public static void main(String[] args) {
        List<Object> objects = new LinkedList<>();
        for (; ; ) objects.add(new Object());
    }
}

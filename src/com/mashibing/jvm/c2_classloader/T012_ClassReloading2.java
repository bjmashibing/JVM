package com.mashibing.jvm.c2_classloader;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 本类破坏了双亲委派模型
 * 打破双亲委派，只能重写loadclass
 */
public class T012_ClassReloading2 {
    private static class MyLoader extends ClassLoader {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            String filePath = getCurrentClassPath() + File.separator + name.replaceAll("\\.", File.separator).concat(".class");
            File f = new File(filePath);
            if (!f.exists()) return super.loadClass(name);

            try {

                InputStream is = new FileInputStream(f);

                byte[] b = new byte[is.available()];
                is.read(b);
                return defineClass(name, b, 0, b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return super.loadClass(name);
        }
    }

    public static void main(String[] args) throws Exception {
        String name = "com.mashibing.jvm.Hello";
        MyLoader m = new MyLoader();
        Class clazz = m.loadClass(name);

        m = new MyLoader();
        Class clazzNew = m.loadClass(name);

        System.out.println(clazz == clazzNew);
    }

    private static String getCurrentClassPath() {
        URL url = T012_ClassReloading2.class.getClassLoader().getResource("");
        File f = null;
        try {
            f = new File(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return f.getPath();
    }
}

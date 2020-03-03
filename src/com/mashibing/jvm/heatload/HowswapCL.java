package com.mashibing.jvm.heatload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;

/*
 *  实现热部署，自定义ClassLoader，加载的是.class
 */
class HowswapCL extends ClassLoader {

    private String basedir; // 需要该类加载器直接加载的类文件的基目录  
    private HashSet dynaclazns; // 需要由该类加载器直接加载的类名  

    public HowswapCL(String basedir, String[] clazns) {
        super(null); // 指定父类加载器为 null  
        this.basedir = basedir;
        dynaclazns = new HashSet();
        loadClassByMe(clazns);
    }

    private void loadClassByMe(String[] clazns) {
        for (int i = 0; i < clazns.length; i++) {
            loadDirectly(clazns[i]);
            dynaclazns.add(clazns[i]);
        }
    }

    private Class loadDirectly(String name) {
        Class cls = null;
        StringBuffer sb = new StringBuffer(basedir);
        String classname = name.replace('.', File.separatorChar) + ".class";
        sb.append(File.separator + classname);
        File classF = new File(sb.toString());
        try {
            cls = instantiateClass(name, new FileInputStream(classF), classF.length());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }
        return cls;
    }

    private Class instantiateClass(String name, InputStream fin, long len) {
        byte[] raw = new byte[(int) len];
        try {
            fin.read(raw);
            fin.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }

        return defineClass(name, raw, 0, raw.length);
    }

    protected Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class cls = null;
        cls = findLoadedClass(name);
        if (!this.dynaclazns.contains(name) && cls == null) {
            cls = getSystemClassLoader().loadClass(name);
        }
        if (cls == null) {
            throw new ClassNotFoundException(name);
        }
        if (resolve) {
            resolveClass(cls);
        }
        return cls;
    }
}

/*
 * 每隔500ms运行一次，不断加载class
 */
class Multirun implements Runnable {

    public void run() {
        try {
            while (true) {
                // 每次都创建出一个新的类加载器  
                // class需要放在自己package名字的文件夹下  
                String url = "D:\\D\\github\\JVM\\out\\production\\JVM\\";//System.getProperty("user.dir") + "/lib";// "/lib/yerasel/GetPI.jar";
                HowswapCL cl = new HowswapCL(url, new String[]{"com.mashibing.jvm.heatload.GetPI"});
                Class cls = cl.loadClass("com.mashibing.jvm.heatload.GetPI");
                System.out.println(cls.getClassLoader());
                System.out.println(GetPI.class.getClassLoader());
                GetPI foo = (GetPI) cls.newInstance();
                // 被调用函数的参数
                foo.Output();
//                Method m = foo.getClass().getMethod("Output", new Class[]{});
//                m.invoke(foo, new Object[]{});
                Thread.sleep(500);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}  
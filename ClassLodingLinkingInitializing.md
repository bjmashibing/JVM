## 3：类加载-初始化

1. 加载过程
   1. Loading
      
      1. 双亲委派，主要出于安全来考虑
      
      2. LazyLoading 五种情况
      
         1. –new getstatic putstatic invokestatic指令，访问final变量除外
      
            –java.lang.reflect对类进行反射调用时
      
            –初始化子类的时候，父类首先初始化
      
            –虚拟机启动时，被执行的主类必须初始化
      
            –动态语言支持java.lang.invoke.MethodHandle解析的结果为REF_getstatic REF_putstatic REF_invokestatic的方法句柄时，该类必须初始化
      
      3. ClassLoader的源码
      
         1. findInCache -> parent.loadClass -> findClass()
      
      4. 自定义类加载器
      
         1. extends ClassLoader
         2. overwrite findClass() -> defineClass(byte[] -> Class clazz)
         3. 加密
      
      5. 混合执行 编译执行 解释执行
      
         1. 检测热点代码：-XX:CompileThreshold = 10000
   2. Linking 
      1. Verification
      2. Preparation
      3. Resolution
   3. Initializing
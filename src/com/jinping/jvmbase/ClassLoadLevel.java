package com.jinping.jvmbase;

/**
 * @Classname ClassLoadLevel
 * @Description 类加载器
 * @Date 2020/8/12 9:30 下午
 * @Created by jinping
 */
public class ClassLoadLevel {

    public static void main(String[] args) {
        //查看是谁load到内存的，执行结果为null，为什么为空呢？bootstrap使用C++实现的，Java里并没有class和他对应
        System.out.println(String.class.getClassLoader());
        //这个是我们核心类库某个包里的类，执行结果为null，为什么他也是空呢？因为他也是被我们bootstrap类加载器加载的
        System.out.println(sun.awt.HKSCS.class.getClassLoader());
        //这个类是位于ext目录下某个jae文件里面，当你调用它执行结果也就是sun.misc.Launcher$ExtClassLoader@5e2de80c
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        //这个是我们自己写的ClassLoader加载器，它是由sun.misc.launcher$AppClassLoader加载的
        System.out.println(ClassLoadLevel.class.getClassLoader());
        //它是一个ext的classloader调用他的getClass()，他本身也是一个class，然后调用它的getClassLoader,它的classloader又是谁？
        //就这个classloader的classloader是我们最顶级的classLoaderBootstrap，执行结果为null
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());

        System.out.println(ClassLoadLevel.class.getClassLoader().getClass().getClassLoader());
    }
}

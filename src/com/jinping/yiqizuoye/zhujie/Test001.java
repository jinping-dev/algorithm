package com.jinping.yiqizuoye.zhujie;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author: jinping
 * @DATE: 2021/1/17 23:10
 * @Description
 **/
public class Test001 {

    private Inject1 inject1;
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        // 1.获取Class对象
        Class className = Class.forName("com.jinping.yiqizuoye.zhujie.Book");

        Method method = className.getMethod("sell");

        Annotation[] annotations = method.getAnnotations();

        for (Annotation annotation: annotations){
            System.out.println("annotation = " + annotation);
        }

    }
}
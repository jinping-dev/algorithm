package com.jinping.yiqizuoye.zhujie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: jinping
 * @DATE: 2021/1/17 23:10
 * @Description 自定义注解
 **/
//限定方法使用
@Target(ElementType.METHOD)
//活到运行时候
@Retention(RetentionPolicy.RUNTIME)
public @interface MoBook {

    String name();

    double price();

    String[] authors();
}

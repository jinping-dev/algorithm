package com.jinping.designModle.templateMethod;

/**
 * @Classname TemplateChild
 * @Description TemplateChild
 * @Date 2020/12/10 5:45 下午
 * @Created by tinner
 */
public class TemplateChild extends Template {

    @Override
    public void print(Cat cat) {
        System.out.println("hello!" + cat.getName());
    }
}

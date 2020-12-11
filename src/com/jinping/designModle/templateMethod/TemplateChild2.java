package com.jinping.designModle.templateMethod;

/**
 * @Classname TemplateChild2
 * @Description TemplateChild2
 * @Date 2020/12/10 5:46 下午
 * @Created by tinner
 */
public class TemplateChild2 extends Template{

    @Override
    public void print(Cat cat) {
        System.out.println("bye bye" + cat.getName());
    }
}

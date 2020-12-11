package com.jinping.designModle.templateMethod;

/**
 * @Classname Test
 * @Description Test
 * @Date 2020/12/10 5:45 下午
 * @Created by tinner
 */
public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("小芳");
        Template template = new TemplateChild2();
        template.print(cat);
        Template car1 = new TemplateChild();
        car1.print(cat);
    }
}

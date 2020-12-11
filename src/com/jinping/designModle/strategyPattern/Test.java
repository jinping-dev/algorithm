package com.jinping.designModle.strategyPattern;

/**
 * @Classname Test
 * @Description Test
 * @Date 2020/12/10 6:05 下午
 * @Created by tinner
 */
public class Test {

    public static void main(String[] args) {
        Context context = new Context(new StrategyA());
        context.doMethod();

        Context context1 = new Context(new StrategyB());
        context1.doMethod();

        Context context2 = new Context(new StrategyC());
        context2.doMethod();
    }
}

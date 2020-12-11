package com.jinping.designModle.strategyPattern;

/**
 * @Classname Context
 * @Description Context
 * @Date 2020/12/10 6:04 下午
 * @Created by tinner
 */
public class Context {

    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doMethod(){
        strategy.method();
    }
}

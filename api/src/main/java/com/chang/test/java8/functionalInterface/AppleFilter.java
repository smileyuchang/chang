package com.chang.test.java8.functionalInterface;

@FunctionalInterface
public interface AppleFilter {
    /**
     * 筛选条件抽象
     *
     * @param apple
     * @return
     */
    boolean accept(Apple apple);


    /**
     * java8默认方法
     */
    default void move(String str){
        System.out.println(str);
    }
}

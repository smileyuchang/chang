package com.chang.test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppleTest{
    /**
     * 将筛选条件封装成接口
     */
    public static List<Apple> filterApplesByAppleFilter(List<Apple> apples, AppleFilter filter) {
        List<Apple> filterApples = new ArrayList<>();
        for (final Apple apple : apples) {
            if (filter.accept(apple)) {
                filterApples.add(apple);
            }
        }
        return filterApples;
    }


    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        Apple apple1 = new Apple();
        apple1.setWeight(102);
        Apple apple2 = new Apple();
        apple2.setWeight(99);
        apples.add(apple1);
        apples.add(apple2);

        /**
         * 函数式接口筛选
         */
        List<Apple> filterApples = filterApplesByAppleFilter(apples, new AppleFilter() {
            @Override
            public boolean accept(Apple apple) {
                // 筛选重量大于100g的红苹果
                return apple.getWeight() > 100;
            }
        });
        filterApples.forEach(System.out::println);

        /**
         * lambda表达式的使用需要借助于函数式接口，也就是说只有函数式接口出现地方，我们才可以将其用lambda表达式进行简化。
         * lambda简化操作
         */
        List<Apple> lambdaFilterApples = filterApplesByAppleFilter(apples,
                (Apple apple) -> apple.getWeight() <= 100);
        lambdaFilterApples.forEach(System.out::println);


        /**
         * stream过滤
         */
        List<Apple> streamFilterApples = apples.stream().filter(a -> a.getWeight() >100).collect(Collectors.toList());
        streamFilterApples.forEach(System.out::println);
    }

}


/**
 * java8默认方法测试
 */
class DefaultMethod implements AppleFilter{

    @Override
    public boolean accept(Apple apple) {
        return false;
    }

    public static void main(String[] args) {
        DefaultMethod defaultMethod = new DefaultMethod();
        defaultMethod.move("I am moving");
    }
}
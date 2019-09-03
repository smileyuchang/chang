package com.chang.test.java8.forEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class forEachTest {
    public static void main(String[] args) {
        forEachTest forEachTest = new forEachTest();
        forEachTest.testList();
    }

    /**
     * java8 使用List的forEach
     */
    public void testList(){
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
      /*  Consumer<Integer> action = System.out::println;
        numberList.stream().filter(n -> n%2 == 0).forEach(action);
        numberList.stream().filter(n -> n%2 == 0).forEach(System.out::println);
        numberList.forEach(action);*/
        Consumer<Integer> test = a ->
        {
            //System.out.println(a.intValue());
            if (a.intValue() == 1){
                System.out.println(a.intValue());
            }
        };
        numberList.forEach(test);

    }

    /**
     * java8 使用Map的forEach操作
     */
    public void testMap(){
        HashMap<String, Integer> map = new HashMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        Consumer<Map.Entry<String, Integer>> action = entry ->
        {
            System.out.println("Key is : " + entry.getKey());
            System.out.println("Value is : " + entry.getValue());
        };

        map.entrySet().forEach(action);
    }
}

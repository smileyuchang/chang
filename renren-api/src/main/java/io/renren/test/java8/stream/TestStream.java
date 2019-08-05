package io.renren.test.java8.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Date;
public class TestStream {
    public static void main(String[] args) {
        TestStream testStream = new TestStream();
        //testStream.streamof();
        //testStream.streamofArry();
        //testStream.streamGenerate();
        testStream.streamBuilders();
    }

    /**
     * Stream.of（val1，val2，val3 ......）
     */
    public void streamof(){
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        stream.forEach(p -> System.out.println(p));
    }

    /**
     * Stream.of（arrayOfElements）
     */
    public void streamofArry(){
        Stream<Integer> stream = Stream.of(new Integer[]{1,2,3,4,5,6,7,8,9});
        stream.forEach(p -> System.out.println(p));
    }

    /**
     * Stream.generate（）或Stream.iterate（）
     */
    public void streamGenerate(){
        Stream<Date> stream = Stream.generate(() -> { return new Date(); });
        stream.forEach(p -> System.out.println(p));
    }

    /**
     * 去除字符中的特殊字符
     */
    public void streamBuilders(){
        /*IntStream stream = "12345_abcdefg".chars();
        stream.forEach(p -> System.out.println(p));*/
        //OR
        Stream<String> stream = Stream.of("A$B$C".split("\\$"));
        stream.forEach(p -> System.out.println(p));
    }
}

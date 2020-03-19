package com.chang.test.java8.stream;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        TestStream testStream = new TestStream();
        //testStream.streamof();
        //testStream.streamofArry();
        //testStream.streamGenerate();
        //testStream.streamBuilders();
        //testStream.streamToList();
        //testStream.streamToArry();
        //testStream.streamStartWith();
        //testStream.streamReduce();
        testStream.streamParallel();
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

    /**
     * 将流转换为列表 -Stream.collect(Collectors.toList())
     */
    public void streamToList(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Stream<Integer> stream = list.stream();
        List<Integer> evenNumbersList = stream.filter(i ->i%2 == 0).collect(Collectors.toList());
        evenNumbersList.forEach(i -> System.out.println(i));
    }

    /**
     * 将Stream转换为数组 - Stream.toArry(EntryType [] :: new)
     */
    public void streamToArry(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Stream<Integer> stream = list.stream();
        Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
        System.out.println(evenNumbersArr);
    }

    /**
     * Stream 中级操作
     */
    public void streamStartWith(){
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");
        //过滤器接受谓词以过滤流的所有元素
       /* memberNames.stream().filter(s -> s.startsWith("A"))
                .forEach(System.out::println);*/
        //将每个字符串转换为大写字符串 以下示例将每个字符串转换为大写字符串。但您也可以使用map将每个对象转换为另一种类型。
        /*memberNames.stream().filter((s) -> s.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);*/
        //Sorted是一个中间操作，它返回流的排序视图。除非您传递自定义比较器 (Comparator)，否则元素按自然顺序排序。
        /**
         * 下面代码以自然序排序一个list
         * list.stream().sorted()
         *
         * 自然序逆序元素，使用Comparator 提供的reverseOrder() 方法
         * list.stream().sorted(Comparator.reverseOrder())
         *
         * 使用Comparator 来排序一个list
         * list.stream().sorted(Comparator.comparing(Student::getAge))
         *
         * 把上面的元素逆序
         * list.stream().sorted(Comparator.comparing(Student::getAge).reversed())
         */
     /*   memberNames.stream().sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);*/
        //Stream.count() Count是一个终端操作，返回流中元素的数量为long。
       /* long totalMatched = memberNames.stream()
                .filter((s) -> s.startsWith("A"))
                .count();
        System.out.println("totalMatched=====" + totalMatched);*/

       //Stream.anyMatch（） 一旦条件传递为谓词满足，这将返回true。它不会再处理任何元素。
        boolean matched = memberNames.stream().anyMatch(s -> s.startsWith("A"));
        System.out.println(matched);

        //Stream.findFirst（）它将从流返回第一个元素，然后不再处理任何元素。
        String firstMatchedName = memberNames.stream().filter(s ->s.startsWith("L")).findFirst().get();
        System.out.println(firstMatchedName);



    }

    /**
     * Stream.reduce()操作
     */
    public void streamReduce(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int sum = list.stream().map(p -> p.intValue()).reduce(0,Integer::sum);
        System.out.println("intSum===== " + sum);

        List<BigDecimal> listBigdecimal = new ArrayList<>();
        listBigdecimal.add(new BigDecimal("1.2"));
        listBigdecimal.add(new BigDecimal("2"));
        BigDecimal total =  listBigdecimal.stream().map(m -> new BigDecimal(m.toString())).reduce(BigDecimal.ZERO,BigDecimal::add);
        System.out.println("bigDecimalSum==== " + total);
    }

    /**
     * java Stream中的并行性
     */
    public void streamParallel(){
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        //Here creating a parallel stream
        Stream<Integer> stream = list.parallelStream();
        Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
        System.out.print(evenNumbersArr);
    }


    /**
     * javaStream.parallelStream()出现线程不安全问题示例
     */
    public void streamParallelError(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Calendar> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Calendar startDay = new GregorianCalendar();
            Calendar checkDay = new GregorianCalendar();
            checkDay.setTime(startDay.getTime());//不污染入参
            checkDay.add(checkDay.DATE,i);
            list.add(checkDay);
        }

        list.stream().forEach(day ->  System.out.println(sdf.format(day.getTime())));
        System.out.println("-----------------------");
        list.parallelStream().forEach(day ->  System.out.println(sdf.format(day.getTime())));
        System.out.println("-----------------------");
    }

    /**
     * javaStream.parallelStream()解决线程线程不安全问题
     */
    public void streamParallelRight(){
        DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime date = LocalDateTime.now();
        List<LocalDateTime> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            LocalDateTime date1 = date.plusDays(i);
            list.add(date1);
        }
        list.stream().forEach(day ->  System.out.println(day.format(fmt)));
        System.out.println("-----------------------");
        list.parallelStream().forEach(day ->  System.out.println(day.format(fmt)));
    }

}

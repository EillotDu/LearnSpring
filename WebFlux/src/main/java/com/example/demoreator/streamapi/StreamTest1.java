package com.example.demoreator.streamapi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {

    //1. 筛选和切片
    @Test
    public void test1() {
        // limit 截断流
        Stream.iterate(0, t -> t + 2).limit(10).filter(t -> t < 10).forEach(System.out::println);
        System.out.println("-----------------");
        //skip(n)：返回一个扔掉前n个元素
        Stream.iterate(0, t -> t + 2).limit(10).skip(6).forEach(System.out::println);
        System.out.println("-----------------");

        //distinct()：筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        Stream.of(1, 1, 2, 2, 3, 3, 4).distinct().forEach(System.out::println);
        System.out.println("-----------------");
    }

    //2. 映射
    @Test
    public void test2() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "bb");
        list.stream().map(String::toUpperCase).forEach(System.out::println);


        // flatMap(Function f)--接受一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        Stream<Stream<Character>> streamStream = list.stream().map(StreamTest1::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        list.stream().flatMap(StreamTest1::fromStringToStream).forEach(System.out::println);

        Stream.of(1, 1, 2, 2, 3, 3, 4).reduce(Integer::sum).ifPresent(System.out::println);

    }

    //将字符串中的多个字符构成的集合转换为对应的Stream实例
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    //3. 排序
    @Test
    public void test4() {
        List<Integer> integers = Arrays.asList(123, 4, 3, 53, 67, 547, 23);
        integers.stream().sorted().forEach(System.out::println);
        integers.stream().sorted((t1, t2) -> -Integer.compare(t1, t2)).forEach(System.out::println);

    }

}

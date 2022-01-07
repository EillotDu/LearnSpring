package com.example.demoreator.streamapi;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class StreamTest2 {

    //1. 匹配和查找
    @Test
    public void test1() {

        //allMatch(Predicate p)-检查是否匹配所有元素
        System.out.println(Stream.of(1, 1, 2, 2, 3, 3, 4).allMatch(n -> n < 2));

        //anyMatch(Predicate p)-检查是否至少匹配一个元素
        System.out.println(Stream.of(1, 1, 2, 2, 3, 3, 4).anyMatch(n -> n < 2));

        //noneMatch(Predicate p)-检查是否没有匹配的元素
        System.out.println(Stream.of(1, 1, 2, 2, 3, 3, 4).noneMatch(n -> n < 2));

        //findFirst-返回第一个元素
        //findAny-返回当前流中的任意元素
        //count-返回流中元素的总个数
        System.out.println(Stream.of(1, 1, 2, 2, 3, 3, 4).count());
        //max(Comparator c)-返回流中最大值
        System.out.println(Stream.of(1, 1, 2, 2, 3, 3, 4).max(Integer::compare));
        //min(Comparator c)-返回流中最小值
        //forEach(Consumer c)-内部迭代
    }


}

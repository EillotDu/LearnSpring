package com.example.demoreator.reactor8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1. Stream关注的是对数据的运算，与CPU关联
 * 集合关注的是数据的存储，与内存关联
 * 2.
 * Stream 自己不会存储元素
 * Stream 不会改变源对象。想反，他们会返回一个持有结果的新Stream
 * Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 * <p>
 * 3. Stream 执行流程
 * Stream实例化
 * 一系列的中间操作（过滤、映射、。。。）
 * 终止操作
 */

public class StreamTest {

    private List<Integer> list = Arrays.asList(1, 2, 3, 4);

    //创建Stream方式一：通过集合
    @Test
    public void test1() {
        // 顺序流
        Stream<Integer> stream = list.stream();

        // 并行流
        Stream<Integer> parallelStream = list.parallelStream();

    }

    //创建Stream方式二：通过数组
    @Test
    public void test2() {
        Integer[] array = {1, 2, 3, 4};
        Stream<Integer> stream = Arrays.stream(array);
    }

    //创建Stream方式三：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

    }

    //创建Stream方式四：创建无限流
    //造数据
    @Test
    public void test4() {
        //迭代
        //public static <T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        //生成
        //public static <T> Stream<T> iterate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }
}

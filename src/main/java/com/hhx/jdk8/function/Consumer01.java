package com.hhx.jdk8.function;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * 单入参无返回值
 *
 * @author huhuixin3
 * @date 2020/7/22
 */
public class Consumer01 {

    public static void main(String[] args) {
        processStr(System.out::println);
        processWithChain(str -> System.out.println(str.toUpperCase()),
                str -> System.out.println(str.toLowerCase()));

        processTwoStr((s1, s2) -> System.out.println(s1 + " " + s2));

        processInt(i -> System.out.println(i + 1));
        //  ObjIntConsumer
    }

    private static void processStr(Consumer<String> consumer) {
        // 指定动作消费
        consumer.accept("this is a message");
    }

    private static void processWithChain(Consumer<String> consumer1, Consumer<String> consumer2) {
        // 连续消费
        consumer1.andThen(consumer2).accept("this is a message");
        // 任意组合
        consumer2.andThen(consumer1).andThen(consumer2).andThen(consumer1).accept("this is a message");
    }

    private static void processTwoStr(BiConsumer<String, String> consumer) {
        // 消费两个字符串
        consumer.accept("this is a message1", "this is a message2");
    }

    private static void processInt(IntConsumer consumer) {
        // 基本数据类型
        consumer.accept(9999);
    }
}

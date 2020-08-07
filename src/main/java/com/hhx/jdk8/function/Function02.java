package com.hhx.jdk8.function;

import java.util.function.*;

/**
 *
 *
 * @author huhuixin3
 * @date 2020/7/22
 */
public class Function02 {

    public static void main(String[] args) {
        processStrWithUnaryOperator(String::toUpperCase);
        // 原样返回
        processStrWithUnaryOperator(UnaryOperator.identity());

        processStrWithBinaryOperator((s1, s2) -> s1 + "_" + s2);
        // 给定比较器, 获取两个中较大的值
        processStrWithBinaryOperator(BinaryOperator.maxBy(String::compareTo));
        processStrWithBinaryOperator(BinaryOperator.minBy(String::compareTo));
        // LongUnaryOperator     DoubleBinaryOperator   ...
    }


    private static void processStrWithUnaryOperator(UnaryOperator<String> unaryOperator) {
        System.out.println(unaryOperator.apply("this is a message"));
    }

    private static void processStrWithBinaryOperator(BinaryOperator<String> binaryOperator) {
        System.out.println(binaryOperator.apply("this is a message1", "this is a message2"));
    }
}

package com.hhx.jdk8.function;

import java.util.function.*;

/**
 * 单入参有返回值
 *
 * @author huhuixin3
 * @date 2020/7/22
 */
public class Function01 {

    public static void main(String[] args) {
        processStrAndPrint(String::toUpperCase);
        processStrWithChinaAndPrint(String::toUpperCase, s -> s.substring(0, 4));
        // 基本类型
        IntFunction<String> intToStr = Integer::toString;
        ToIntFunction<String> strToInt = Integer::parseInt;
        IntToDoubleFunction intToDouble = i -> Integer.valueOf(i).doubleValue();
        // DoubleToIntFunction    DoubleToLongFunction   ...
        // 双入参的Function
        BiFunction<String, String, String> selectLonger = (s1, s2) -> s1.length() > s2.length() ? s1 : s2;
        // ToIntBiFunction ToDoubleBiFunction ....
    }


    private static void processStrAndPrint(Function<String, String> function) {
        System.out.println(function.apply("this is a message"));
    }

    private static void processStrWithChinaAndPrint(Function<String, String> function1, Function<String, String> function2) {
        System.out.println(function1.andThen(function2).apply("this is a message"));
        System.out.println(function1.compose(function2).apply("this is a message"));
    }
}

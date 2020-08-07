package com.hhx.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 流的基本使用
 *
 * @author huhuixin3
 * @date 2020/7/28
 */
public class Stream01 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "abc", "bbc");
        for (String s : list) {
            if(s.contains("a")) {
                System.out.println(s);
            }
        }

        // Spliterator 实现迭代
        list.stream()
                .filter(s -> s.contains("a"))
                .forEach(System.out::println);
    }
}

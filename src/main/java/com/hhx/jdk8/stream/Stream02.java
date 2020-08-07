package com.hhx.jdk8.stream;

import java.util.stream.Stream;

/**
 * 基Stream本原理解析
 *
 * 双向链表  {@link java.util.stream.AbstractPipeline}
 * 流源 Head
 * 中间操作 StatefulOp StatelessOp
 * 结束操作 TerminalOp
 *
 * @author huhuixin3
 * @date 2020/7/28
 */
public class Stream02 {

    public static void main(String[] args) {

        System.out.println("sum: " +
                Stream.of("1", "2", "3", "4", "5")
                .peek(System.out::println)
                .mapToInt(Integer::valueOf)
                .filter(i -> i % 2 == 0)
                .findFirst().orElse(0)
        );
    }
}

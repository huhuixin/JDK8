package com.hhx.jdk8.stream;


import java.util.concurrent.ForkJoinPool;

/**
 * 并行 stream 及其原理
 *
 * 分治思想
 *
 * ForkJoinPool通用线程池的线程数量，默认值为运行时计算机的处理器数量。可以通过设置
 * 系统属性：java.util.concurrent.ForkJoinPool.common.parallelism=N （N为线程数量），来调整ForkJoinPool的线程数量
 * @see ForkJoinPool#common
 *
 * 线程安全问题
 *
 * 适合非CPU密集型系统, 假如本身电脑CPU的负载很大，频繁使用并行流可能会有反作用
 *
 * @author huhuixin3
 * @date 2020/7/28
 */
public class Stream06 {

    public static void main(String[] args) {


    }
}

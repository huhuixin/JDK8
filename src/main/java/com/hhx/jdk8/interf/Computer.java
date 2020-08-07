package com.hhx.jdk8.interf;

/**
 * 计算机接口定义
 *
 * @author huhuixin3
 * @date 2020/7/21
 */
public interface Computer {

    void run();

    default void stop() {
        System.out.println("stop ...");
    }
}

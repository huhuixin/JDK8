package com.hhx.jdk8.interf;

/**
 * @author huhuixin3
 * @date 2020/7/21
 */
public class ThinkPad implements Computer {


    @Override
    public void run() {
        System.out.println("ThinkPad run.....");
    }

    // 可以重写
//    @Override
//    public void stop() {
//        System.out.println("ThinkPad stop.....");
//    }

    public static void main(String[] args) {
        Computer c = new ThinkPad();
        c.run();
        c.stop();
    }
}

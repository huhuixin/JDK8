package com.hhx.jdk8.lambda;

/**
 * lambda表达式
 *
 * Lambda在运行的时候会生成一个内部类，可以在运行时加上 -Djdk.internal.lambda.dumpProxyClasses
 *
 * @author huhuixin3
 * @date 2020/7/20
 */
public class Lambda01 {

    public static void main(String[] args) {
        // 内部类  javac src/main/java/com/hhx/jdk8/lambda/Lambda01.java
        // 编译后产生一个类 Lambda01$1.class
        run(new Task() {
            @Override
            public void run() {
                System.out.println("task...");
            }
        });
        // lambda 形式  运行时生成内部类  -Djdk.internal.lambda.dumpProxyClasses
        // Lambda01$$Lambda$1.class   lambda$main$0()
        run(() -> {
            System.out.println("lambda task...");
        });
        // Lambda01$$Lambda$2.class   lambda$main$1()
        run(() -> System.out.println("lambda task1..."));
    }

    /**
     * 方法的参数或局部变量类型必须为接口才能使用Lambda
     */
    private static void run(Task task) {
        task.run();
    }

    /**
     * 接口中有且仅有一个抽象方法
     * FunctionalInterface注解  编译器强制检查该接口是否确实有且仅有一个抽象方法
     */
    @FunctionalInterface
    public interface Task {
        void run();
    }
}

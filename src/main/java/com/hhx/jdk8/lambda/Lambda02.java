package com.hhx.jdk8.lambda;

/**
 * lambda语法糖
 *
 * @author huhuixin3
 * @date 2020/7/20
 */
public class Lambda02 {

    public static void main(String[] args) {
        test1(s -> {
            System.out.println(s);
        });
        test1(s -> System.out.println(s));
        // :: 方法引用  如果Lambda所要实现的方案 , 已经有其他方法存在相同方案，那么则可以使用方法引用
        test1(System.out::println);
        Interface1 sout = System.out::println;
        test1(sout);

        test2((s1, s2) -> System.out.println(s1 + " " + s2));
        test2((s1, s2) -> Lambda02.concatAndPrint(s1, s2));
        test2(Lambda02::concatAndPrint);
    }

    private static void concatAndPrint(String s1, String s2) {
        System.out.println(s1 + " " + s2);
    }

    private static void test1(Interface1 interface1){
        interface1.method1("this is a param");
    }

    private static void test2(Interface2 interface2){
        interface2.method2("this is param1", "this is param2");
    }

    interface Interface1{
       void method1(String param);
    }

    interface Interface2{
        void method2(String param1, String param2);
    }

}

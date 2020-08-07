package com.hhx.jdk8.function;

import java.util.function.Predicate;

/**
 * 返回boolean
 *
 * @author huhuixin3
 * @date 2020/7/22
 */
public class Predicate01 {

    public static void main(String[] args) {

        Predicate<String> containsA = s -> s.contains("a");
        isSuccess(containsA);
        // 对返回结果取反
        Predicate<String> notContainsA = containsA.negate();
        isSuccess(notContainsA);
        // 静态方法isEqual  返回一个Predicate
        Predicate<String> equalAbcd = Predicate.isEqual("abcd");
        isSuccess(equalAbcd);

        isSuccessWithChain(s -> s.contains("a"), s -> s.contains("b"));
        isSuccessWithChain(s -> s.contains("a"), s -> s.contains("e"));
        isSuccessWithChain(s -> s.contains("e"), s -> s.contains("f"));
    }

    private static void isSuccess(Predicate<String> predicate) {
        if(predicate.test("abcd")){
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }

    private static void isSuccessWithChain(Predicate<String> predicate1, Predicate<String> predicate2) {
        if(predicate1.and(predicate2).test("abcd")){
            System.out.println("and success");
        } else {
            System.out.println("and fail");
        }

        if(predicate1.or(predicate2).test("abcd")){
            System.out.println("or success");
        } else {
            System.out.println("or fail");
        }
    }

}

package com.hhx.jdk8.function;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * 无入参有出参
 *
 * @author huhuixin3
 * @date 2020/7/23
 */
public class Supplier01 {

    public static void main(String[] args) {
        System.out.println(getString(() -> RandomStringUtils.randomAlphabetic(10)));

        IntSupplier supplier = RandomUtils::nextInt;
        for (int i = 0; i < 10; i++) {
            System.out.println(supplier.getAsInt());
        }
    }

    private static String getString(Supplier<String> supplier) {
        return supplier.get();
    }
}

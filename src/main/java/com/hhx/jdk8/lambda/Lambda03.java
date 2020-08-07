package com.hhx.jdk8.lambda;

import org.apache.commons.lang3.RandomUtils;

import java.util.Comparator;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * 方法引用的用法
 *
 * @author huhuixin3
 * @date 2020/7/20
 */
public class Lambda03 {

    public static void main(String[] args) {
        Random random = new Random();
        // 1. instanceName::methodName 对象::方法名  表示引用这个对象的nextInt方法
        IntSupplier randomInt = random::nextInt;
        System.out.println(randomInt.getAsInt());

        // 2. ClassName::staticMethodName 类名::静态方法   表示引用这个类的静态方法
        randomInt = RandomUtils::nextInt;
        System.out.println(randomInt.getAsInt());

        // 3. ClassName::methodName 类名::普通方法  实际上是拿第一个入参当做方法的调用者
        // Comparator<Integer> integerComparator = (i, j) -> i.compareTo(j);
        Comparator<Integer> integerComparator = Integer::compareTo;
        System.out.println(integerComparator.compare(1, 2));

        // 4. ClassName::new 类名::new 调用的构造器
        Supplier<Random> randomSupplier = Random::new;
        Random random1 = randomSupplier.get();
        System.out.println(random1.nextInt());

        // 5. TypeName[]::new String[]::new 调用数组的构造器
        Function<Integer, String[]> strArrGenerator = String[]::new;
        String[] strArr = strArrGenerator.apply(5);
        System.out.println(strArr.length);
    }
}

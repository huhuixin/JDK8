package com.hhx.jdk8.stream;

import java.util.ArrayList;
import java.util.Spliterator;

/**
 * Spliterator 测试
 *
 * @author huhuixin3
 * @date 2020/7/29
 */
public class Spliterator01 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");

        Spliterator<String> spliterator = list.spliterator();

        // 该方法会处理每个元素并返回true，直至没有元素处理并返回false
        while(spliterator.tryAdvance(System.out::print)){
            System.out.println("  estimateSize: " + spliterator.estimateSize());
        }
        // 返回
        System.out.println("      ------------------      ");
        // 只能迭代一次
        System.out.println("  estimateSize: " + spliterator.estimateSize());
        spliterator.forEachRemaining(System.out::println);

        System.out.println("      ------------------      ");
        // 迭代
        spliterator = list.spliterator();
        // 剩余元素的值
        System.out.println("estimateSize: " + spliterator.estimateSize());
        spliterator.forEachRemaining(System.out::println);

        // 将一个Spliterator分割成多个Spliterator。分割的Spliterator被用于每个子线程进行处理，
        // 从而达到并发处理的效果
        spliterator = list.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        System.out.println("spliterator  estimateSize: " + spliterator.estimateSize());
        System.out.println("spliterator1  estimateSize: " + spliterator1.estimateSize());
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        System.out.println("spliterator2  estimateSize: " + spliterator2.estimateSize());
        Spliterator<String> spliterator3 = spliterator2.trySplit();
        // 不可再切割之后返回null
        System.out.println("spliterator3  " + spliterator3);
        spliterator.forEachRemaining(System.out::println);
        spliterator1.forEachRemaining(System.out::println);
        spliterator2.forEachRemaining(System.out::println);

        System.out.println("      ------------------      ");

        System.out.println("characteristics :" + spliterator.characteristics());

        System.out.println(Spliterator.DISTINCT);
        System.out.println(Spliterator.SORTED);
        System.out.println(Spliterator.ORDERED);
        System.out.println(Spliterator.SIZED);
        System.out.println(Spliterator.NONNULL);
        System.out.println(Spliterator.IMMUTABLE);
        System.out.println(Spliterator.CONCURRENT);
        System.out.println(Spliterator.SUBSIZED);

        System.out.println("      ------------------      ");

        System.out.println(spliterator.hasCharacteristics(Spliterator.SIZED));
        System.out.println(spliterator.hasCharacteristics(Spliterator.SORTED));
        System.out.println(spliterator.hasCharacteristics(Spliterator.DISTINCT));
    }
}

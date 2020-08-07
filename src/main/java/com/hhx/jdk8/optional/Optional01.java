package com.hhx.jdk8.optional;

import java.util.Optional;

/**
 * Optional 优雅解决空指针
 *
 * @author huhuixin3
 * @date 2020/8/6
 */
public class Optional01 {

    public static void main(String[] args) {

        // 构建 Optional
        String content = null;
        try {
            // 抛出异常, 对于明确不会为null的方法才可以用of
            Optional<String> optional = Optional.of(content);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException : " + e.getMessage());
        }

        // 允许为null
        Optional<String> optional = Optional.ofNullable(content);

        try {
            // 抛出异常, 不建议直接get
            optional.get();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException : " + e.getMessage());
        }

        //
        optional = Optional.of("111");
        // 如果存在则消费
        optional.ifPresent(System.out::println);
        // 为空返回默认值
        System.out.println(optional.orElse("222"));
        // 为空抛出异常
        System.out.println(optional.orElseThrow(() -> new RuntimeException("null")));
        // 自动映射为 Optional
        Optional<Integer> integer = optional.map(Integer::valueOf);
        // 手动映射为 Optional
        Optional<Integer> integer1 = optional.flatMap(s -> Optional.of(Integer.valueOf(s)));
    }
}

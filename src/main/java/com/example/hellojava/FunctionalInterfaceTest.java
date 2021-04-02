package com.example.hellojava;

import java.util.function.*;

public class FunctionalInterfaceTest {

    public static void main(String[] args) {
        /*
        // 익명 내부 클래스 anonymous inner clas
        MyFunctionalInterface run1 = new MyFunctionalInterface() {
            @Override
            public void doIt() {
                System.out.println("hello");
            }
        };
        run1.doIt();

        // 함수형 인터페이스를 구현할 때 lambda로 줄여쓸 수 있음
        MyFunctionalInterface run2 = () -> {
            System.out.println("hello");
            System.out.println("lambda");
        };
        run2.doIt();
        */
        /*
        // Functional Interface Function<T, R>을 구현한 클래스
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));
        */
        /*
        // Function<T, R> 는 매개변수는 T타입, 리턴 값은 R타입
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        System.out.println(plus10.apply(1));
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(2));    // 2 * 2 + 10 = 14

        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);
        System.out.println(plus10AndMultiply2.apply(2));    // (2 + 10) * 2 = 24
        */
        /*
        // Consumer<T> 는 매개변수는 T타입, 리턴 값은 없음
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        // Supplier<T> 는 매개변수는 없고, 리턴 값은 T타입
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        // Predicate<T> 는 매개변수는 T타입, 리턴 값은 Boolean타입
        Predicate<String> startsWithTest = (s) -> s.startsWith("test");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;

        // UnaryOperator<T> 는 매개변수와 리턴 값이 T 타입
        UnaryOperator<Integer> plus10 = (i) -> i + 10;
        UnaryOperator<Integer> multiply2 = (i) -> i * 2;
        System.out.println(plus10.andThen(multiply2).apply(2)); // (10 + 2) * 2 = 24
        */
    }
}



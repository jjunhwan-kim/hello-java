package com.example.hellojava;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReferenceTest {

    public static void main(String[] args) {
        UnaryOperator<String> hi = (s) -> "hi " + s;                // 람다
        UnaryOperator<String> hi2 = Greeting::hi;                   // 스태틱 메소드 참조

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;              // 인스턴스 메소드 참조
        System.out.println(hello.apply("test"));                 // apply를 호출해야 메소드가 실행됨

        // 생성자 참조
        Supplier<Greeting> newGreeting = Greeting::new;             // 인자가 없는 생성자 참조
        Greeting greeting2 = newGreeting.get();
        System.out.println(greeting2.getName());                    // null

        Function<String, Greeting> newGreeting2 = Greeting::new;    // 인자가 있는 생성자 참조
        Greeting greeting3 = newGreeting2.apply("test");
        System.out.println(greeting3.getName());                    // test

        // 임의 객체의 인스턴스 메소드 참조
        String[] names = {"toby", "abc", "java"};
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(names));

        Arrays.sort(names, (o1, o2) -> o1.compareTo(o2));
        System.out.println(Arrays.toString(names));

        Arrays.sort(names, String::compareToIgnoreCase);    // 임의 객체의 인스턴스 메소드 참조, 스태틱 메소드 참조 아님
        System.out.println(Arrays.toString(names));
    }
}

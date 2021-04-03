package com.example.hellojava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class JavaInterfaceTest {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();

        // Iterable
        name.add("abc");
        name.add("test");
        name.add("toby");
        name.add("foo");
        System.out.println("==========");
        name.forEach(s-> System.out.println(s));
        System.out.println("==========");
        name.forEach(System.out::println);
        System.out.println("==========");

        // Collection
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator2 = spliterator.trySplit();  // spliterator가 절반으로 줄고 나머지 절반이 spliterator2에 담기게 됨
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("==========");
        while(spliterator2.tryAdvance(System.out::println));
        System.out.println("==========");

        // stream
        List<String> list = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("==========");

        // removeIf
        name.removeIf(s -> s.startsWith("a"));
        name.forEach(System.out::println);
        System.out.println("==========");

        // Comparator
        name.sort(String::compareToIgnoreCase);
        name.forEach(System.out::println);
        System.out.println("==========");
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
    }
}

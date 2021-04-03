package com.example.hellojava;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("abc");
        names.add("toby");
        names.add("foo");
        names.add("boo");

        // 스트림은 연속된 데이터를 처리하는 Operation들의 모임
        // 스트림은 데이터를 담고 있는 저장소(컬렉션)이 아님
        // 스트림은 데이터소스를 변경하지 않음
        Stream<String> stringStream = names.stream().map(String::toUpperCase);

        names.forEach(System.out::println);
        stringStream.forEach(System.out::println);

        // Stream의 중개 오퍼레이션은 lazy하게 처리 됨, 중개 오퍼레이터는 Stream을 리턴 함
        // 종료 오퍼레이션이 오기전까지는 중개 오퍼레이션은 실행되지 않음
        names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        });
        System.out.println("==========");
        List<String> collect = names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        System.out.println("==========");
        collect.forEach(System.out::println);
        System.out.println("==========");
        // loop문은 병렬처리가 어려움
        for (String name : names) {
            if (name.startsWith("a")) {
                System.out.println(name.toUpperCase());
            }
        }
        System.out.println("==========");
        // Stream은 병렬처리가 가능함
        List<String> list = names.parallelStream().map(s -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        //list.forEach(System.out::println);
    }
}

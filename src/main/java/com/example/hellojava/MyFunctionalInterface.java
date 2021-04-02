package com.example.hellojava;

@FunctionalInterface
public interface MyFunctionalInterface {

    void doIt();                    // 추상 메서드가 단 한 개만 있으면 함수형 인터페이스임, static 메서드, default 메서드와 관계 없음
    //void doAgain();               // @FunctionalInterface 를 붙이면 추상 메서드를 단 한개만 선언해야함

    static void printName() {       // 인터페이스 안에 static 메서드 정의 가능함
        System.out.println("name");
    }

    default void printAge() {       // 인터페이스 안에 default 메서드 정의 가능함
        System.out.println("age");
    }
}
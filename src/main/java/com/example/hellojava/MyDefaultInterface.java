package com.example.hellojava;


/**
 * @implSpec
 * 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
 */

public interface MyDefaultInterface {

    void printName();

    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }
    /*
    default String toString() {
        // Object에서 제공하는 메소드들은 디폴트 메소드로 재정의 불가능함
    }
    */

    String toString();  // 모든 Object가 toString()을 구현하므로, 기본 구현체가 제공되므로 선언가능함

    static void printAnything() {
        System.out.println("Anything");
    }

    String getName();
}

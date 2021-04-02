package com.example.hellojava;

public class FunctionalInterfaceTest {

    public static void main(String[] args) {

        // 익명 내부 클래스 anonymous inner class
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
    }
}



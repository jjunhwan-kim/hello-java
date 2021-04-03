package com.example.hellojava;

public interface MyInterface extends MyDefaultInterface {

    void printNameUpperCase();  // MyDefaultInterface에서 제공하는 디폴트 메소드를 제공하고 싶지 않을 때 추상 메소드로 재정의 가능함

}

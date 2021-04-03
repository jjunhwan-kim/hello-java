package com.example.hellojava;

public interface MyDefaultInterface2 {

    default void printNameUpperCase() {
        System.out.println("test");
    }
}

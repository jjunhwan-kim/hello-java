package com.example.hellojava;

public class DefaultInterfaceTest implements MyDefaultInterface, MyDefaultInterface2 {

    String name;

    public static void main(String[] args) {
        DefaultInterfaceTest foo = new DefaultInterfaceTest("test");
        foo.printName();
        foo.printNameUpperCase();           // 디폴트 메소드

        MyDefaultInterface.printAnything(); // 인터페이스의 스태틱 메소드
    }

    public DefaultInterfaceTest(String name) {
        this.name = name;
    }

    // 두 개의 인터페이스로부터 같은 디폴트 메소드 상속시 둘 중에 어떤 메소드를 써야할 지 모르므로 재정의 해줘야함
    @Override
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());    // 디폴트 메소드도 재정의 가능함
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}

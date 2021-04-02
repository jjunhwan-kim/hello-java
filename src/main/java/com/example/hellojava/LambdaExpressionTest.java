package com.example.hellojava;

import java.util.function.*;

public class LambdaExpressionTest {

    public static void main(String[] args) {
        /*
        UnaryOperator<Integer> plus10 = (i) -> i + 10;
        UnaryOperator<Integer> multiply2 = (i) -> i * 2;
        System.out.println(plus10.andThen(multiply2).apply(2)); // (10 + 2) * 2 = 24

        Supplier<Integer> get10 = () -> 10;

        BinaryOperator<Integer> sum = (a, b) -> a + b;

        */

        LambdaExpressionTest lambdaTest = new LambdaExpressionTest();
        lambdaTest.run();

    }

    private void run() {
        int baseNumber = 10;

        // 로컬 클래스, 익명 클래스, 람다식 공통점은 외부의 변수를 참조할 수 있음
        // Java 8 이전에는 final 키워드가 반드시 명시되어 있어야 Local 클래스나 Anonymous 클래스에서 외부의 변수를 참조할 수 있음
        // Java 8 부터는 final 키워드를 생략할 수 있는 경우가 있음, 사실상 final인 경우(effectively final), 즉 변경이 없는 경우임

        // 차이점은 쉐도잉이 다름
        // 로컬 클래스나 익명 클래스는 run 메서드와 별도의 스코프이므로 쉐도잉이 됨
        // 람다식은 run 메서드와 동일 스코프이므로 쉐도잉이 안됨

        // Local Class
        class localClass {
            void printBaseNumber() {
                //int baseNumber = 11; // 11이 출력됨, 즉 run의 baseNumber를 가림
                System.out.println(baseNumber);
            }
        }

        // Anonymous Class
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber); // run의 baseNumber를 매개변수 baseNumber가 가림
            }
        };

        // Lambda Expression
        IntConsumer printInt = (i) -> {     // run과 같은 스코프이므로 i를 baseNumber로 바꿀 수 없음, 동일한 이름 사용불가
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
        //baseNumber++;   // baseNumber는 effectively final 이어야 참조 가능함
    }
}

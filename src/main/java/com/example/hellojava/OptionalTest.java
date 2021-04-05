package com.example.hellojava;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass springBoot = new OnlineClass(1, "spring boot", true);

        // progress가 null일 경우 NullPointerException 발생
        // Duration studyDuration = springBoot.getProgress().getStudyDuration();
        // System.out.println(studyDuration);

        Optional<OnlineClass> optianlOnlineClass = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = optianlOnlineClass.isPresent();
        System.out.println(present);


        // Optional 값이 있으면 어떤 일을 수행해야 할 때
        optianlOnlineClass.ifPresent(oc -> System.out.println(oc.getTitle()));


        /*
        orElse는 optionalOnlineClass가 값이 있던 없던 무조건 createNewClass가 실행됨
        따라서 이미 생성된 인스턴스가 있다면 orElse를 쓰고
        새로 생성해야 한다면 orElseGet을 쓰면됨
        */
        // OnlineClass onlineClass = optianlOnlineClass.orElse(createNewClass());
        OnlineClass onlineClass = optianlOnlineClass.orElseGet(() -> createNewClass());
        System.out.println(onlineClass.getTitle());

        /*
        OnlineClass onlineClass2 = optianlOnlineClass.orElseThrow(() -> {
            return new IllegalArgumentException();
        });

        // OnlineClass onlineClass2 = optianlOnlineClass.orElseThrow(IllegalStateException::new);
        */

        Optional<OnlineClass> onlineClass2 = optianlOnlineClass.filter(oc -> !oc.isClosed());
        System.out.println(onlineClass2.isEmpty());

        Optional<Integer> integer = optianlOnlineClass.map(oc -> oc.getId());
        System.out.println(integer.isPresent());

        // Optional 안에 Optional 이 있는 경우 flatMap 사용
        Optional<Optional<Progress>> progress = optianlOnlineClass.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElse(Optional.empty());
        // progress1.orElseThrow();

        Optional<Progress> progress2 = optianlOnlineClass.flatMap(OnlineClass::getProgress);
    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}

package com.example.hellojava;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
    }
}

package me.whiteship.java8to11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {


    public static void print(Collection<OnlineClass> classList) {
        for (OnlineClass classItem : classList) {
            System.out.println(classItem.getTitle());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);


        System.out.println("spring 으로 시작하는 수업");
        // TODO
        for (List<OnlineClass> onlineClassList : keesunEvents) {
            List<OnlineClass> startWithSpring = onlineClassList.stream()
                    .filter(classItem -> classItem.getTitle().startsWith("spring"))
                    .collect(Collectors.toList());

            App.print(startWithSpring);

        }

        System.out.println("close 되지 않은 수업");
        // TODO

        for (List<OnlineClass> onlineClassList : keesunEvents) {
            List<OnlineClass> notClosedClass = onlineClassList.stream()
                    .filter(classItem -> classItem.isClosed())
                    .collect(Collectors.toList());

            App.print(notClosedClass);

        }

        System.out.println("수업 이름만 모아서 스트림 만들기");
        // TODO

        Stream<String> newStreamFilterByClassName = Arrays.stream(new String[0]);
        for (List<OnlineClass> onlineClassList : keesunEvents) {
            Stream<String> stringStream = onlineClassList.stream()
                    .map(classItem -> classItem.getTitle());
            newStreamFilterByClassName = Stream.concat(newStreamFilterByClassName, stringStream);
        }

        newStreamFilterByClassName.forEach(System.out::println);


        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        // TODO

        Stream<Integer> newStreamFilterById = Arrays.stream(new Integer[0]);
        for (List<OnlineClass> onlineClassList : keesunEvents) {
            Stream<Integer> integerStream = onlineClassList.stream()
                    .map(classItem -> classItem.getId());
            newStreamFilterById = Stream.concat(newStreamFilterById, integerStream);
        }

        newStreamFilterById.forEach(System.out::println);


        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        // TODO

        List<Integer> collect = Stream.iterate(0, n -> n + 1).skip(10).limit(10).collect(Collectors.toList());

        for (Integer value: collect) {
            System.out.println(value);
        }


        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        // TODO

        List<OnlineClass> test = javaClasses.stream().filter(classItem -> classItem.getTitle().contains("Test")).collect(Collectors.toList());

        System.out.println(test.size() > 0 ? "true" : "false");


        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");
        // TODO

        List<OnlineClass> spring = springClasses.stream().filter(classItem -> classItem.getTitle().contains("spring")).collect(Collectors.toList());

        for(OnlineClass item : spring) {
            System.out.println(item.getTitle());
        }

    }

}

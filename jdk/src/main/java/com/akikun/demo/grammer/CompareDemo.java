package com.akikun.demo.grammer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author 李俊秋(龙泽)
 */

public class CompareDemo {

    public static void main(String[] args) {

        Random random = new Random();
        
        
        List<Person> list = new ArrayList<>();
        list.add(new Person("张三", 18));
        list.add(new Person(null, 14));
        list.add(new Person(null, random.nextInt(100)));
        list.add(new Person("李四", 100));
        list.add(new Person(null, random.nextInt(100)));

//        list = list.stream().sorted((a, b) -> {
//
//            if (Objects.nonNull(a.getName())) {
//                return -1;
//            }
//            if (Objects.nonNull(b.getName())) {
//                return 1;
//            }
//
//            return a.getAge().compareTo(b.getAge());
//
//        }).collect(Collectors.toList());

        Collections.sort(list, (a, b) -> {
            if (Objects.nonNull(a.getName())) {
                return -1;
            }
            if (Objects.nonNull(b.getName())) {
                return 1;
            }

            return a.getAge().compareTo(b.getAge());
        });


        for (Person person : list) {
            System.out.println(person);
        }

    }

    static class Person {
        private String name;

        private Integer age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }


        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}

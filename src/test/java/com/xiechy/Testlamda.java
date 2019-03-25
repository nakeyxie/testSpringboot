package com.xiechy;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 */
public class Testlamda {













    public static void main(String[] agrs) {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person(1, "zhangsan"));
        list.add(new Person(2, "lisi"));
        Map testMap2 = getMap(list);
        System.out.println(testMap2.toString());
        System.out.println();
        System.out.println();
        System.out.println();
        try {

        } catch (Exception e) {

        }


    }

    private static Map getMap(List<Person> list) {
        Map testMap = list.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println(testMap.toString());
        return list.stream().collect(Collectors.toMap(Person::hashCode, Function.identity()));
    }


}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

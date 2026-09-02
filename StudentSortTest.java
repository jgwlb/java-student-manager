//package HashMap;
//import java.util.*;
//public class StudentSortTest {
//    TreeMap<Person, String> map = new TreeMap<>() {
//    for(
//        int i = 0;
//        i<3;i++){
//
//        }
//
//
//
//
//
//    }
//}
package HashMap;

import java.util.TreeMap;

public class StudentSortTest {

    // 内部类:一个人,有名字和年龄
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + "(" + age + "岁)";
        }
    }

    public static void main(String[] args) {
        TreeMap<Person, String> map = new TreeMap<>();

        map.put(new Person("张三", 20), "a");
        map.put(new Person("李四", 25), "b");
        map.put(new Person("王五", 18), "c");

        System.out.println(map);
    }
}
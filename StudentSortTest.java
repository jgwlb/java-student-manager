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
    static class Person implements Comparable<Person> {

        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public int compareTo(Person o){
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return name + "(" + age + "岁)";
        }
    }

    public static void main(String[] args) {
        TreeMap<Person, String> byAge = new TreeMap<>((a,b)->a.age-b.age);
        TreeMap<Person, String> byName = new TreeMap<>((a, b) -> a.name.compareTo(b.name));
        TreeMap<Person, String> byAgeDesc = new TreeMap<>((a, b) -> b.age - a.age);
        byAge.put(new Person("张三", 20), "a");
        byAge.put(new Person("李四", 25), "b");
        byAge.put(new Person("王五", 18), "c");

        System.out.println("按年龄   : " + byAge.keySet());
        System.out.println("按姓名   : " + byName.keySet());
        System.out.println("按年龄倒序: " + byAgeDesc.keySet());
    }
}
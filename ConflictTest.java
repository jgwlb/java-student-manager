package HashMap;
import  java.util.HashMap;
public class ConflictTest  {
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();

        map.put(new Person("张三", 20), "北京");
        map.put(new Person("李四", 20), "上海");
        map.put(new Person("王五", 20), "广州");

        System.out.println("size="+map.size());
        System.out.println("桶下标="+((16-1)&0));
        System.out.println(map.get(new Person("张三", 20)));

    }
}

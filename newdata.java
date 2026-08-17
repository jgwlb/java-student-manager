package HashMap;
import java.util.HashMap;
public class newdata {
    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("张三",88);
        map1.put("李四",99);
        map1.put("王五",77);
        System.out.println(map1.get("李四"));
        map1.put("李四",10);
        System.out.println(map1.get("李四"));
        //map1.remove("张三");
        System.out.println(map1.containsKey("张三"));
        System.out.println(map1.size());
        for(String k: map1.keySet()) {
            System.out.println(k+"="+map1.get(k));
        }
        //原理待理解
        for(HashMap.Entry<String, Integer> e: map1.entrySet()) {
            System.out.println(e.getKey()+"="+e.getValue());
        }
        map1.forEach((k,v)-> System.out.println(k+"="+v));

    }
}

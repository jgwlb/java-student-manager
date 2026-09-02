package HashMap;
import java.util.*;
public class MapFamilyTest {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
        TreeMap<String,Integer> treeMap = new TreeMap<>();
        String[] keys ={"banana", "apple", "cherry", "date"};
        for(String k:keys){
            hashMap.put(k,1);
            linkedHashMap.put(k,1);
            treeMap.put(k,1);
        }

        System.out.println("HashMap:"+hashMap.keySet());
        System.out.println("LinkedHashMap:"+linkedHashMap.keySet());
        System.out.println("TreeMap:"+treeMap.keySet());

    }
}

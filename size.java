package HashMap;

import java.lang.reflect.Field;
import java.util.HashMap;

public class size {
    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> map = new HashMap<>();

        Field f = HashMap.class.getDeclaredField("table");
        f.setAccessible(true);

        for (int i = 0; i < 15; i++) {
            map.put("key" + i, i);
            Object[] table = (Object[]) f.get(map);
            System.out.println("第 " + (i + 1) + " 个 put 后:size=" + map.size()
                    + ", 数组长度=" + table.length);
        }
    }
}
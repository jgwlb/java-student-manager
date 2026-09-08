package HashMap;
import java.util.Iterator;
import java.util.ArrayList;
public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String name = it.next();
            if (name.equals("李四")) {
                it.remove();
            }
        }
        System.out.println(list);


    }
}

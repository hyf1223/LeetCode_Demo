import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: heyifeng
 * @time: 2020/1/12 19:42
 * @description:map的遍历&&测试final
 */
public class map的遍历 {
    public static void main(String[] args) {
        final HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1, "value1");
        map2.put(2, "value2");
        map2.put(3, "value3");
        map2.put(4, "value4");
        System.out.println("keyset遍历：两次取值");
        for (Integer num : map2.keySet()) {
            System.out.println("key：" + num + " value:" + map2.get(num));
        }
        System.out.println("————————");

        System.out.println("entrySet遍历");
        for (Map.Entry<Integer, String> entry : map2.entrySet()) {
            System.out.println("key：" + entry.getKey() + " value:" + entry.getValue());
        }
        System.out.println("————————");

        System.out.println("entrySet通过iterator遍历");
        final Iterator<Map.Entry<Integer, String>> iterator = map2.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<Integer, String> next = iterator.next();
            System.out.println("key：" + next.getKey() + " value：" + next.getValue());
        }
        System.out.println("————————");

        map2.put(1, "change");
        System.out.println("测试自动生成的final关键字的作用：修改之后遍历");
        final Iterator<Map.Entry<Integer, String>> testIterator = map2.entrySet().iterator();
        while (testIterator.hasNext()) {
            final Map.Entry<Integer, String> next = testIterator.next();
            System.out.println("key：" + next.getKey() + " value：" + next.getValue());
        }
    }
}

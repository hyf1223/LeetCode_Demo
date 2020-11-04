import java.util.HashMap;

/**
 * @author: heyifeng
 * @time: 2020/10/27 17:18
 * @description:
 */
public class Test1 {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1};
        System.out.println(CalculateLength(input));
    }

    /**
     * 计算图中环的长度。
     *
     * @param input int整型一维数组 按题目描述中表达的图
     * @return int整型
     */
    public static int CalculateLength(int[] input) {
        // write code here
//        int index = 0;
        int start = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                // posi
                start = map.get(input[i]);
            }
            map.put(input[i], i);
        }
        return input.length - start - 1;
    }
}

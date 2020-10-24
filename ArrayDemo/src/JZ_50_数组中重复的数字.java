import SortingAlgorithm.SortingUtils;

/**
 * @author: heyifeng
 * @time: 2020/9/22 10:09
 * @description:
 */
public class JZ_50_数组中重复的数字 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5};
        int[] duplication = new int[1];
        boolean flag = duplicate(nums, nums.length, duplication);

        System.out.println("是否发现重复数:"+flag);
        System.out.println("重复数字为:" + duplication[0]);

    }

    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            // 注意此处使用while!! while使得该次遍历num[i] == i
            // 或者直接找到重复数
            while (i != numbers[i]) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                // 交换数组元素
                SortingUtils.swapArrayElem(numbers, i, numbers[i]);
            }
        }
        return false;
    }
}

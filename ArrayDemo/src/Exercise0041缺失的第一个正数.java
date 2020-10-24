/**
 * @author: heyifeng
 * @time: 2020/8/7 20:19
 * @description:https://leetcode-cn.com/problems/first-missing-positive/
 */
public class Exercise0041缺失的第一个正数 {
    public static void main(String[] args) {
        // 测试用例2
        // 输入:3 4 -1 1
        // 输出:2
        int[] nums2 = new int[]{3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums2));
    }

    // 法1:找到自己的位置法
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 进入while循环条件:数字处于0<n<=length之间;位置和数字不配对;要交换的两个数字不相等
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    // 法2:原地hash法
    // 使用负号-作为hash标识:
    // 1.将所有负数变成正数M
    // 2.遍历每个位置,将位置上的值代表的本位变成负数
    // 3.再遍历,取出第一个非负的序号i,返回i+1;
    public static int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}

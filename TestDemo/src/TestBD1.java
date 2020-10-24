/**
 * @author: heyifeng
 * @time: 2020/9/27 13:52
 * @description:
 */
public class TestBD1 {
    public static void main(String[] args) {
       int[] nums = new int[10];
       maxLength(nums);
    }

    private static void maxLength(int[] nums) {
        int length = nums.length;
        int result = 0;
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
//                if ()
            }
        }
    }


}

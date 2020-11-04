import java.util.Arrays;

/**
 * @author: heyifeng
 * @time: 2020/9/29 15:46
 * @description:给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class LC_300_最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

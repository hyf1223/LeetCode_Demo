import java.util.Arrays;

/**
 * @author: heyifeng
 * @time: 2020/9/24 10:58
 * @description:现在这只青蛙已经可以跳上n级台阶了! 现在我们需要采用动态规划了!!
 */
public class JZ_9_变态跳台阶_fibonacci变种 {
    // 动态规划
    // dp[n]的计算需要之前每一步的结果!
    public int JumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target-1];
    }
}

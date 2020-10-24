import java.util.Arrays;

/**
 * @author: heyifeng
 * @time: 2020/9/26 14:12
 * @description: https://leetcode-cn.com/problems/integer-break/solution/zheng-shu-chai-fen-by-leetcode-solution/
 * <p>
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */
public class LC_343_整数拆分 {
    public static void main(String[] args) {
        LC_343_整数拆分 test = new LC_343_整数拆分();
        int n = 6;
        int res = test.integerBreak(n);
        System.out.println(res);
    }

    public int integerBreak(int n) {
        // 由于每个正整数对应的最大乘积取决于比它小的正整数对应的最大乘积，因此可以使用动态规划求解。
        
        // dp[i]表示i拆分成至少两个正整数的和之后，这些正整数的最大乘积
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        if (n <= 1) {
            return dp[n];
        }
        // i>=2时,可以拆分为j,i-j;对于i-j有两种情况
        // 1. 不能再拆分了:dp = j * (i-j)
        // 2. 还能拆分:dp = j * dp[i-j]
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            // 拆分出来的实数j取值范围[1,i-1],若i=j则不符合拆分两个的要求
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];

    }
}

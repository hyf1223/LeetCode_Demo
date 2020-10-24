package 一步步发明DP_知乎;

import java.util.Scanner;

/**
 * @author: heyifeng
 * @time: 2020/9/29 16:49
 * @description:
 */
public class zh_1_最小钞票数 {
    // 用1\5\11三种面额的钱凑出一定数字的总额
    // 使得用到的钞票数最少;
    // f(n) = min{f(n-1),f(n-5),f(n-11)}+1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = minNumOfMoney(n);
        System.out.println("当金额为" + n + "时,使用的钞票数目最少是:" + result);
    }

    private static int minNumOfMoney(int n) {
        // dp数组用来保存状态,代表金额i时最优的策略
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int cost = 0;
        for (int i = 1; i <= n; i++) {
            // cost在每次循环开始时保存当前最糟糕的情况(全是一元纸币?)
            cost = i;
            if (i - 1 >= 0) cost = Math.min(cost, dp[i - 1] + 1);
            if (i - 5 >= 0) cost = Math.min(cost, dp[i - 5] + 1);
            if (i - 11 >= 0) cost = Math.min(cost, dp[i - 11] + 1);
            dp[i] = cost;
        }

        return dp[n];
    }

    // 请稍微修改代码，输出我们凑出w的方案
    private static int minNumOfMoney2(int n) {
        return 0;
    }

    // dp自带剪枝,尽可能缩小解空间
}

package 一步步发明DP_知乎;

import java.util.Scanner;

/**
 * @author: heyifeng
 * @time: 2020/10/6 16:09
 * @description:https://www.luogu.com.cn/problem/solution/P1541 记忆化搜索
 * 洛谷提交答案 LTE
 */
public class zh_3_P1541 {
    static int n;
    static int m;
    static int[] cheersboard;
    static int[] cards;
    static int[] sums;
    static int[][][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        cheersboard = new int[n + 1];
        cards = new int[m + 1];
        sums = new int[5];
        dp = new int[41][41][41][41];
        for (int i = 1; i < cheersboard.length; i++) {
            cheersboard[i] = sc.nextInt();
        }
        for (int i = 1; i < cards.length; i++) {
            cards[i] = sc.nextInt();
            sums[cards[i]]++;
        }
        int res = dfs(0, 0, 0, 0) + cheersboard[1];
        System.out.println(res);
    }

    private static int dfs(int i1, int i2, int i3, int i4) {
        if (i1 == sums[1] && i2 == sums[2] && i3 == sums[3] && i4 == sums[4]) {
            return 0;
        }
        int p = i1 * 1 + i2 * 2 + i3 * 3 + i4 * 4 + 1;
        int dfsMax = 0;
        if (i1 < sums[1]) dfsMax = Math.max(dfsMax, dfs(i1 + 1, i2, i3, i4) + cheersboard[p + 1]);
        if (i2 < sums[2]) dfsMax = Math.max(dfsMax, dfs(i1, i2 + 1, i3, i4) + cheersboard[p + 2]);
        if (i3 < sums[3]) dfsMax = Math.max(dfsMax, dfs(i1, i2, i3 + 1, i4) + cheersboard[p + 3]);
        if (i4 < sums[4]) dfsMax = Math.max(dfsMax, dfs(i1, i2, i3, i4 + 1) + cheersboard[p + 4]);
        return dp[i1][i2][i3][i4] = dfsMax;
    }

}

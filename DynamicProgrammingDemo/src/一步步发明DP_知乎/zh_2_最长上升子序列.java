package 一步步发明DP_知乎;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: heyifeng
 * @time: 2020/10/4 10:06
 * @description:
 */
public class zh_2_最长上升子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        int result = lengthOfLIS(array);
        System.out.println("最长上升子序列:" + result);
    }

    private static int lengthOfLIS(int[] list) {
        int len = list.length;
        if (len <= 1) {
            return len;
        }

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (list[j] < list[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            System.out.println("dp[" + i + "]=" + dp[i]);
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

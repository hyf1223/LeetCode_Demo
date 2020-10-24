import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] result = new int[t];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] nums = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    nums[j][k] = sc.nextInt();
                }
            }
            // 0 28  5  j 1/2-2 1/2+3    5  5
            // 1 17  7  j 1/2 1/2+1      0 0
            // 2 22  6  j 1/2 1/2+1      2 2
            // 3 24  5 1/2-1 7 1/2+1     2 4
            // 4 24  7  i 1/2 +1         3 1   6 2
            // 5 25                      5 3
            // 6 25                      5 2
            // 7 22                      3 3
            // 8 28  7  j 1/2-1 1/2+2    4 4
            // 9 25                      2 5
            int k = n / 10;
            int a1 = 0;
            int a2 = 0;
            for (int i1 = 0; i1 < n; i1++) {
                a1 += nums[i1][3 * k - 1];
                a2 += nums[i1][n - 3 * k];
            }
            if (a1 == 0) {
                result[i] = 1;
            } else if (a1 == 5 * k) {
                if (a2 == 5 * k) {
                    result[i] = 0;
                } else if (a2 == 3 * k) {
                    result[i] = 5;
                } else {
                    result[i] = 6;
                }
            } else if (a1 == 2 * k) {
                if (a2 == 2 * k) {
                    result[i] = 2;
                } else if (a2 == 4 * k) {
                    result[i] = 3;
                } else {
                    result[i] = 9;
                }
            } else if (a1 == 3 * k) {
                if (a2 == k) {
                    result[i] = 4;
                } else {
                    result[i] = 7;
                }
            } else if (a1 == 4 * k) {
                result[i] = 8;
            } else return;

        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

import java.util.Scanner;

/**
 * @author: heyifeng
 * @time: 2020/10/6 18:35
 * @description:
 */
public class LC_62_不同路径 {
    static int m;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        LC_62_不同路径 test = new LC_62_不同路径();
        int res = test.uniquePaths(m, n);
        System.out.println("到达F点有路径:" + res);
    }

    public int uniquePaths(int m, int n) {
        // 答案似乎不需要校验啊?
        // ...

        
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 似乎横着遍着填和纵着填都可以
        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];

    }
}

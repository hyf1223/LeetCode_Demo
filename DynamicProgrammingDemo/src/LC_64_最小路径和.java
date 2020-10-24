import javax.swing.*;
import java.util.Scanner;

/**
 * @author: heyifeng
 * @time: 2020/10/6 19:06
 * @description:
 */
public class LC_64_最小路径和 {
    static int m;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        LC_64_最小路径和 test = new LC_64_最小路径和();
        int res = test.minPathSum(matrix);
        System.out.println("最小路径和为:" + res);
    }

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (rows <= 0 || cols <= 0) {
            return 0;
        }

        int[][] dp = new int[rows][cols];
        // 初始化起始点
        dp[0][0] = grid[0][0];
        // 初始化行
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 初始化列
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // 状态转移
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                dp[r][c] = Math.min(dp[r][c - 1], dp[r - 1][c]) + grid[r][c];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}

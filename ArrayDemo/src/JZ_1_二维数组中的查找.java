/**
 * @author: heyifeng
 * @time: 2020/9/22 10:45
 * @description:
 */
public class JZ_1_二维数组中的查找 {
    public static boolean findTarget(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 设置r,c来标注当前位置
        int r = 0;
        int c = cols - 1;
        // 针对每个位置进行判定
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c]) {// 相等,则为true
                return true;
            } else if (target > matrix[r][c]) {// 目标数大于当前数则向下移动
                r++;
            } else {// 目标数小于当前数则向左移动
                c--;
            }
        }
        return false;
    }
}

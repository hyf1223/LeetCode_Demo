/**
 * @author: heyifeng
 * @time: 2020/9/25 15:26
 * @description:回溯\递归\dfs
 */
public class JZ_65_矩阵中路径 {
    private int rows;
    private int cols;

    public static void main(String[] args) {
        char[] chars = new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'};
        int rows = 3;
        int cols = 4;
        char[] chars2 = new char[]{'b','c','c','e','d'};
        JZ_65_矩阵中路径 test = new JZ_65_矩阵中路径();
        boolean flag = test.hasPath(chars, rows, cols, chars2);
        System.out.println("找到了吗? " + flag);

    }
    
    public  boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) {
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        char[][] charsMatrix = buildMatrix(matrix);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(charsMatrix, str, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] charsMatrix, char[] str, int r, int c, int k) {
        // 没有找到word的条件们
        // 包括r和c的越界,字符不匹配
        if (r >= rows || r < 0 || c >= cols || c < 0 || charsMatrix[r][c] != str[k]) {
            return false;
        }
        // 找到了word的条件
        // k从零开始,所以length-1
        if (k == str.length - 1) {
            return true;
        }
        char temp = charsMatrix[r][c];
        // 当前位置注释为'/'就不会走回头路了
        charsMatrix[r][c] = '/';
        // 从下上右左开始遍历
        boolean res = dfs(charsMatrix, str, r + 1, c, k + 1) || dfs(charsMatrix, str, r - 1, c, k + 1) || dfs(charsMatrix, str, r, c + 1, k + 1) || dfs(charsMatrix
                , str, r, c - 1, k + 1);
        // 恢复它
        charsMatrix[r][c]  = temp;
        return res;
    }

    private char[][] buildMatrix(char[] matrix) {

        char[][] result = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[index++];
            }
        }
        return result;
    }
}

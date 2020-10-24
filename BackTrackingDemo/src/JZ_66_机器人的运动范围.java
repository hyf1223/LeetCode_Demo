/**
 * @author: heyifeng
 * @time: 2020/9/25 16:39
 * @description:dfs/回溯 https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
 */
public class JZ_66_机器人的运动范围 {
    private int threshold;
    private int rows;
    private int cols;
    private boolean[][] visited;

    public static void main(String[] args) {
        JZ_66_机器人的运动范围 test = new JZ_66_机器人的运动范围();
        int rows = 3;
        int cols = 4;
        int threshold = 2;
        int res = test.movingCount(threshold,rows,cols);
        System.out.println("可移动的范围为:" + res);
    }

    // DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
    public int movingCount(int threshold, int rows, int cols) {
        this.threshold = threshold;
        this.rows = rows;
        this.cols = cols;
        this.visited = new boolean[rows][cols];
        int res = dfs(0, 0, 0, 0);
        return res;
    }

    // dfs方法
    private int dfs(int i, int j, int si, int sj) {
        // 终止条件： 当 ① 行列索引越界 或 ② 数位和超出目标值 k 或 ③ 当前元素已访问过 时，返回 00 ，代表不计入可达解。
        if (i >= rows || j >= cols || this.threshold < si + sj || visited[i][j]) {
            return 0;
        }
        // 3.递推工作：
        // 3.1.标记当前单元格 ：将索引 (i, j) 存入 Set visited 中，代表此单元格已被访问过。
        visited[i][j] = true;
        // 3.2.搜索下一单元格： 计算当前元素的 下、右 两个方向元素的数位和，并开启下层递归 。
        // 回溯返回值： 返回 1 + 右方搜索的可达解总数 + 下方搜索的可达解总数，代表从本单元格递归搜索的可达解总数。
        return 1 + dfs(i + 1, j, (i + 1) % 10 == 0 ? si - 8 : si + 1, sj) + dfs(i, j + 1, si, (j + 1) % 10 == 0 ? sj - 8 : sj + 1);
    }

    // bfs方法:利用队列
}

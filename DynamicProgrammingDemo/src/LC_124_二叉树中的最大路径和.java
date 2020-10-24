/**
 * @author: heyifeng
 * @time: 2020/10/7 16:34
 * @description:https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * dfs方法
 */
public class LC_124_二叉树中的最大路径和 {
    // 注意max的取值,如果初始化为0 会导致树[-10]输出0
    private int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        LC_124_二叉树中的最大路径和 test = new LC_124_二叉树中的最大路径和();
        int res = test.maxPathSum(node1);
        System.out.println("最大路径和为:" + res);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);// 它的返回值是以root为路径首形成的路径
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 计算左边分支最大值，左边分支如果为负数还不如不选择
        int leftMax = Math.max(0, dfs(root.left));
        // 计算右边分支最大值，右边分支如果为负数还不如不选择
        int rightMax = Math.max(0, dfs(root.right));
        // 以x为顶点的路径的长度拿去与当前最大的路径长度作比较
        // left->root->right 作为路径与已经计算过历史最大值做比较
        // max = Math.max(max, root.val + leftMax + rightMax);
        int pathXAsRoot = root.val + leftMax + rightMax;
        if (pathXAsRoot > max) {
            max = pathXAsRoot;
        }
        // 返回经过root的单边最大分支给当前root的父节点计算使用
        return root.val + Math.max(leftMax, rightMax);

    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * @author: heyifeng
 * @time: 2020/9/23 16:30
 * @description:递归方法,比较难
 */
public class JZ_4_重建二叉树 {
    // 用来缓存中序遍历每个值对应的索引
    // 注意private修饰
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    //pre:前序遍历结果 in:中序遍历结果
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // 缓存中序遍历每个值对应的索引 {key=值, value=序号}
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        // 注意此处调用了递归函数
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);

    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        // 递归退出条件/入参检查
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        // 计算root在中序遍历中的索引index
        int inIndex = indexForInOrders.get(root.value);
        // 计算root左子树大小
        int leftTreeSize = inIndex - inL;
        // 先递归重构左子树
        // preL已经作为根,所以要排除(?)
        root.lchild = reConstructBinaryTree(pre, preL - 1, preL + leftTreeSize, inL);
        // 再递归重构右子树
        root.rchild = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;

    }
}

class TreeNode {
    int value;
    TreeNode lchild;
    TreeNode rchild;

    TreeNode(int value) {
        this.value = value;
    }
}

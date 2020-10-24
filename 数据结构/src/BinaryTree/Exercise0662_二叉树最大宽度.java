package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: heyifeng
 * @time: 2020/9/17 10:05
 * @description:
 */
public class Exercise0662_二叉树最大宽度 {
    public static void main(String[] args) {
        TreeNode[] node = new TreeNode[10];
        for (int i = 0; i < 10; i++) {
            node[i] = new TreeNode(i);
        }
        for (int i = 0; i < 10; i++) {
            if (2 * i + 1 < 10) {
                node[i].lchild = node[2 * i + 1];
            }
            if (2 * i + 2 < 10) {
                node[i].rchild = node[2 * i + 2];
            }
        }

        System.out.println("树的最大宽度为:" + widthOfBiTree(node[0]));
        System.out.println("--------");
    }

    public static int widthOfBiTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        int num = 0;
        int res = 0;
        int depth = 0;
//        int depthOfMaxWidth = 0;//如何记录最大宽度的树深呢?
        // 设定根节点编号为0
        node.value = 0;
        queue.offer(node);
        TreeNode current;
        while (!queue.isEmpty()) {
            // 一层一层处理,使用num来标识一层的节点个数
            num = queue.size();
            depth++;
            res = Math.max(res, queue.getLast().value - queue.getFirst().value + 1);
            while (num > 0) {
                current = queue.poll();
                if (current.lchild != null) {
                    current.lchild.value = current.value * 2 + 1;
                    queue.offer(current.lchild);
                }
                if (current.rchild != null) {
                    current.rchild.value = current.value * 2 + 2;
                    queue.offer(current.rchild);
                }
                num--;
            }
        }
        System.out.println("树的深度为:" + depth);
        return res;
    }

}

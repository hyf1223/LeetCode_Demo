package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: heyifeng
 * @time: 2020/9/15 09:07
 * @description: 树的层次遍历
 */
public class BFS {

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
        levelTraversal(node[0]);
    }

    public static void levelTraversal(TreeNode node) {

        if (node == null) {
            return;
        }
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(node);
        TreeNode current;
        while (!list.isEmpty()) {
            current = list.poll();
            System.out.println(current.value);
            if (current.lchild != null) {
                list.offer(current.lchild);
            }
            if (current.rchild != null) {
                list.offer(current.rchild);
            }
        }

    }
}

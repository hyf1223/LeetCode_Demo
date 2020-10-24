package BinaryTree;

import java.util.Stack;

/**
 * @author: heyifeng
 * @time: 2020/9/11 16:46
 * @description:
 */
public class traversalNLR {
    public static void main(String[] args) {
        // 以数组形式生成一棵完全二叉树
        TreeNode[] node = new TreeNode[10];
        for (int i = 0; i < 10; i++) {
            node[i] = new TreeNode(i);
        }

        for (int i = 0; i < 10; i++) {
            if (2 * i + 1 < 10) {
                node[i].lchild = node[i * 2 + 1];
            }
            if (2 * i + 2 < 10) {
                node[i].rchild = node[i * 2 + 2];
            }
        }

        preOrderTr(node[0]);
        System.out.println("\n------");
        preOrderTr2(node[0]);
        System.out.println("\n------");
        preOrderTr3(node[0]);
    }

    // 二叉树的先序遍历 递归方法
    public static void preOrderTr(TreeNode biTree) {
        System.out.print(biTree.value + "  ");
        TreeNode leftTree = biTree.lchild;
        if (leftTree != null) {
            preOrderTr(leftTree);
        }
        TreeNode rightTree = biTree.rchild;
        if (rightTree != null) {
            preOrderTr(rightTree);
        }
    }

    // 二叉树的先序遍历 非递归方法
    public static void preOrderTr2(TreeNode biTree) {
        Stack<TreeNode> treeNodes = new Stack<>();
        while (!treeNodes.empty() || biTree != null) {
            if (biTree != null) {
                System.out.print(biTree.value + "  ");
                treeNodes.push(biTree);
                biTree = biTree.lchild;
            } else {
                biTree = treeNodes.pop();
                biTree = biTree.rchild;
            }
        }
    }

    // 非递归实现 网上法2
    public static void preOrderTr3(TreeNode biTree) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (biTree != null || !stack.isEmpty()) {
            while (biTree != null) {
                System.out.print(biTree.value + "  ");
                stack.push(biTree);
                biTree = biTree.lchild;
            }
            if (!stack.isEmpty()) {
                biTree = stack.pop();
                biTree = biTree.rchild;
            }
        }
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

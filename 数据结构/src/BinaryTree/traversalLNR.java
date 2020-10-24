package BinaryTree;

import java.util.Stack;

/**
 * @author: heyifeng
 * @time: 2020/9/11 18:54
 * @description:
 */
public class traversalLNR {
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

        midOrderRe(node[0]);
        System.out.println("--------");
        midOrder(node[0]);
    }


    public static void midOrderRe(TreeNode biTree) {//中序遍历递归实现
        if (biTree == null)
            return;
        else {
            midOrderRe(biTree.lchild);
            System.out.println(biTree.value);
            midOrderRe(biTree.rchild);
        }
    }


    public static void midOrder(TreeNode biTree) {//中序遍历费递归实现
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (biTree != null || !stack.empty()) {
            while (biTree != null) {
                stack.push(biTree);
                biTree = biTree.lchild;
            }
            if (!stack.isEmpty()) {
                biTree = stack.pop();
                System.out.println(biTree.value);
                biTree = biTree.rchild;
            }
        }
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * @author: heyifeng
 * @time: 2020/9/26 15:05
 * @description: https://leetcode-cn.com/problems/path-sum-ii/solution/
 */
public class LC_113_路径总和2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs1(root, sum, new ArrayList<Integer>(), result);
        dfs2(root, sum, new ArrayList<Integer>(), result);
        return result;

    }


    // 不优化,正常的dfs
    private void dfs1(TreeNode root, int sum, List<Integer> list,
                      List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        //因为list是引用传递，为了防止递归的时候分支污染，我们要在每个路径中都要新建一个subList
        List<Integer> subList = new ArrayList<>(list);
        subList.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                result.add(subList);
            }
            return;
        }
        // 如果没有到达叶子节点
        dfs1(root.left, sum - root.val, subList, result);
        dfs1(root.right, sum - root.val, subList, result);
    }

    private void dfs2(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        // 为了防止分支污染我们还可以把使用过的值在返回的时候把它给remove掉，这就是大家常提的回溯算法
        // !!!!
        list.add(root.val);
        if (root.right == null && root.left == null) {
            if (sum == root.val) {
                result.add(list);
            }
            // 回溯:这个值没用了,就把它移除掉
            list.remove(list.size() - 1);
            return;
        }
        dfs2(root.left, sum - root.val, list, result);
        dfs2(root.right, sum - root.val, list, result);
        // 我们要理解递归的本质，当递归往下传递的时候他最后还是会往回走，
        // 我们把这个值使用完之后还要把它给移除，这就是回溯
        // !!!!
        list.remove(list.size() - 1);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

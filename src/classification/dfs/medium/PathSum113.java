package classification.dfs.medium;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        if (root == null) {
            return result;
        }
        return dfs(root, path, 0, sum, result);
    }

    private List<List<Integer>> dfs(TreeNode node, Stack<Integer> path, int currentSum, int sum, List<List<Integer>> result) {
        if (node != null && node.left == null && node.right == null) {
            path.push(node.val);
            if (currentSum + node.val == sum) {
                result.add(new ArrayList<>(path));
            }
            path.pop();
            return result;
        }
        path.push(node.val);
        if (node.left != null) {
            dfs(node.left, path, currentSum + node.val, sum, result);
        }
        if (node.right != null) {
            dfs(node.right, path, currentSum + node.val, sum, result);
        }
        path.pop();
        return result;
    }
}

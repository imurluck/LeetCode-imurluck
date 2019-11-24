package classification.dfs.easy;

import model.TreeNode;

public class PathSum112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum, 0);
    }

    private boolean dfs(TreeNode currentNode, int sum, int currentSum) {
        if (currentNode != null && currentNode.left == null && currentNode.right == null) {
            return currentSum + currentNode.val == sum;
        }
        if (currentNode == null) {
            return false;
        }
        return dfs(currentNode.left, sum, currentSum + currentNode.val) ||
                dfs(currentNode.right, sum, currentSum + currentNode.val);
    }


}

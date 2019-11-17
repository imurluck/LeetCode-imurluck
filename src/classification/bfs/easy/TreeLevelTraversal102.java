package classification.bfs.easy;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeLevelTraversal102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        doTraversal(currentLevel, result);
        return result;
    }

    private void doTraversal(List<TreeNode> currentLevel, List<List<Integer>> result) {
        if (currentLevel == null || currentLevel.size() == 0) {
            return;
        }
        List<Integer> valueList = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();
        for (TreeNode node : currentLevel) {
            valueList.add(node.val);
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }
        result.add(valueList);
        doTraversal(nextLevel, result);
    }
}

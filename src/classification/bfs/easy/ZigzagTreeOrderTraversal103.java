package classification.bfs.easy;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ZigzagTreeOrderTraversal103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        if (root != null) {
            doTraversal(currentLevel, result, 1);
        }
        return result;
    }

    private void doTraversal(List<TreeNode> currentLevel, List<List<Integer>> result, int orientation) {
        if (currentLevel == null || currentLevel.size() == 0) {
            return;
        }
        List<Integer> valueList = new ArrayList<>();
        if (orientation == 1) {
            for (TreeNode node : currentLevel) {
                valueList.add(node.val);
            }
        } else {
            for (int i = currentLevel.size() - 1; i >= 0; i--) {
                valueList.add(currentLevel.get(i).val);
            }
        }
        result.add(valueList);
        List<TreeNode> nextLevel = new ArrayList<>();
        for (TreeNode node : currentLevel) {
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }
        doTraversal(nextLevel, result, ++orientation % 2);
    }
}

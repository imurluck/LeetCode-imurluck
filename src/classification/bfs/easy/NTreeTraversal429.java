package classification.bfs.easy;

import model.Node;
import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NTreeTraversal429 {

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Node> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        traversalEachLevel(currentLevel, result);
        return result;
    }

    private static void traversalEachLevel(List<Node> currentLevel, List result) {
        if (currentLevel == null || currentLevel.size() == 0) {
            return;
        }
        List<Integer> valueList = new ArrayList<>();
        List<Node> nextLevel = new ArrayList<>();
        for (Node node : currentLevel) {
            valueList.add(node.val);
            for (Node childNode : node.children) {
                nextLevel.add(childNode);
            }
        }
        result.add(valueList);
        traversalEachLevel(nextLevel, result);
    }

    public static void main(String[] args) {

    }
}

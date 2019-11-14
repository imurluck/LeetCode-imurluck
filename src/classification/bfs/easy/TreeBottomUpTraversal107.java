package classification.bfs.easy;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeBottomUpTraversal107 {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstList = new ArrayList<>();
        List<TreeNode> firstNodeList = new ArrayList<>();
        if (root == null) {
            return result;
        }
        firstNodeList.add(root);
        traversalEachLevel(firstNodeList, result);
        return result;
    }

    private static void traversalEachLevel(List<TreeNode> parentNodeList, List<List<Integer>> result) {
        if (parentNodeList == null || parentNodeList.size() == 0) {
            return;
        }
        List<Integer> valueList = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        for (TreeNode node : parentNodeList) {
            valueList.add(node.val);
            if (node.left != null) {
                nodeList.add(node.left);
            }
            if (node.right != null) {
                nodeList.add(node.right);
            }
        }
        result.add(0, valueList);
        traversalEachLevel(nodeList, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(TreeBottomUpTraversal107.levelOrderBottom(root));
    }
}

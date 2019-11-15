package classification.bfs.easy;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinDeepTree111 {

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        return realMinDepth(currentLevel, 1);
    }

    private static int realMinDepth(List<TreeNode> currentLevel, int currentDepth) {
        if (currentLevel == null || currentLevel.size() == 0) {
            return currentDepth;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        for (TreeNode node : currentLevel) {
            if (node.left == null && node.right == null) {
                return currentDepth;
            }
            if (node.left != null) {
                nodeList.add(node.left);
            }
            if (node.right != null) {
                nodeList.add(node.right);
            }
        }
        return realMinDepth(nodeList, ++currentDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(3);
        System.out.println(MinDeepTree111.minDepth(root));
    }
}

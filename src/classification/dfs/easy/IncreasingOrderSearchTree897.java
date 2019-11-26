package classification.dfs.easy;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree897 {

    public TreeNode increasingBST(TreeNode root) {
        TreeNode result = new TreeNode(0);
        TreeNode tmpNode = result;
        List<Integer> nodeList = new ArrayList<>();
        dfs(root, nodeList);
        for (int i = 0; i < nodeList.size(); i++) {
            tmpNode.right = new TreeNode(nodeList.get(i));
            tmpNode = tmpNode.right;
        }
        return result.right;
    }

    private void dfs(TreeNode node, List<Integer> nodeList) {
        if (node == null) {
            return;
        }
        dfs(node.left, nodeList);
        nodeList.add(node.val);
        dfs(node.right, nodeList);
    }

    public static void main(String[] args) {
        IncreasingOrderSearchTree897 increasingOrderSearchTree897 = new IncreasingOrderSearchTree897();

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(1);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(9);

        System.out.println(increasingOrderSearchTree897.increasingBST(root1));
    }
}

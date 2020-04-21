package classification.dfs.easy;

import model.TreeNode;

public class SumOfLeftLeaves404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        if (left != null) {
            if (left.left == null && left.right == null) {
                return left.val + sumOfLeftLeaves(root.right);
            }
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(new SumOfLeftLeaves404().sumOfLeftLeaves(node));
    }
}

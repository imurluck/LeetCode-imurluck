package classification.dfs.easy;

import model.TreeNode;

public class BalanceBinaryTree110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getTreeHeight(root, 0) != -1;
    }

    private int getTreeHeight(TreeNode root, int i) {
        if (root == null) {
            return i;
        }
        int left = getTreeHeight(root.left, i + 1);
        int right = getTreeHeight(root.right, i + 1);
        if (left == -1 || right == -1) {
            return -1;
        }
        return Math.abs(left - right) >= 2 ? -1 : Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        BalanceBinaryTree110 balanceBinaryTree110 = new BalanceBinaryTree110();
        System.out.println(balanceBinaryTree110.isBalanced(root));
    }
}

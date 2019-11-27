package classification.dfs.medium;

import model.TreeNode;

public class ValidateBinaryTree98 {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode node, Integer lower, Integer limit) {
        if (node == null) {
            return true;
        }
        int nodeValue = node.val;
        if (lower != null && nodeValue <= lower) return false;
        if (limit != null && nodeValue >= limit) return false;
        if (!dfs(node.left, lower, nodeValue)) return false;
        if (!dfs(node.right, nodeValue, limit)) return false;
        return true;
    }


    public static void main(String[] args) {
        ValidateBinaryTree98 validateBinaryTree98 = new ValidateBinaryTree98();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(1);
//        root1.right = new TreeNode(3);
//        root1.left.left = new TreeNode(6);
//        root1.left.right = new TreeNode(2);
//        root1.right.left = new TreeNode(9);
//        root1.right.right = new TreeNode(8);
//        root1.left.right.left = new TreeNode(7);
//        root1.left.right.right = new TreeNode(4);
        System.out.println(validateBinaryTree98.isValidBST(root1));
    }
}

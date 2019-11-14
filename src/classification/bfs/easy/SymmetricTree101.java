package classification.bfs.easy;


import model.TreeNode;

public class SymmetricTree101 {

    public static boolean isSummetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return realCompare(root.left, root.right);
    }

    private static boolean realCompare(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return realCompare(left.left, right.right) && realCompare(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(SymmetricTree101.isSummetric(root));
    }
}

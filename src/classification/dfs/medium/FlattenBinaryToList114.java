package classification.dfs.medium;

import model.TreeNode;

public class FlattenBinaryToList114 {

    private TreeNode lastRight;

    public void flatten(TreeNode root) {
        if (root != null && root.left == null && root.right == null) {
            lastRight = root;
        }
        if (root == null) {
            return;
        }
        flatten(root.left);
        TreeNode rightChild = root.right;
        if (root.left != null) {
            root.right = root.left;
            lastRight.right = rightChild;
            root.left = null;
            if (rightChild != null) {
                lastRight = rightChild;
            }
        }
        flatten(rightChild);
    }


    public static void main(String[] args) {
        FlattenBinaryToList114 flattenBinaryToList114 = new FlattenBinaryToList114();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(6);
        flattenBinaryToList114.flatten(root1);
    }
}

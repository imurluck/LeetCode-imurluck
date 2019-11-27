package classification.dfs.medium;

import model.TreeNode;

import java.util.HashMap;

public class BuildBinaryTree105 {

    private int preorderIndex = 0;

    private int[] preorder;
    private int[] inorder;

    private HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return dfs(0, inorder.length - 1);
    }

    private TreeNode dfs(int left, int right) {
        if (left > right) {
            return null;
        }
        Integer preValue = preorder[preorderIndex++];
        TreeNode treeNode = new TreeNode(preValue);
        int index = inorderIndexMap.get(preValue);
        treeNode.left = dfs(left, index - 1);
        treeNode.right = dfs(index + 1, right);
        return treeNode;
    }
}

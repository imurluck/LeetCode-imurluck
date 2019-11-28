package classification.dfs.medium;

import model.TreeNode;

import java.util.HashMap;

public class BuildBinaryTree106 {

    private int[] inorder;
    private int[] postOrder;
    private HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postOrder = postorder;
        this.postIndex = postOrder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return dfs(0, inorder.length - 1);
    }

    private TreeNode dfs(int left, int right) {
        if (left > right) {
            return null;
        }
        Integer postValue = postOrder[postIndex--];
        int index = inorderIndexMap.get(postValue);
        TreeNode node = new TreeNode(postValue);
        node.right = dfs(index + 1, right);
        node.left = dfs(left, index - 1);
        return node;
    }

    public static void main(String[] args) {
        int[] inOrder = new int[] {9, 3, 15, 20, 7};
        int[] postOrder = new int[] {9, 15, 7, 20, 3};
        BuildBinaryTree106 buildBinaryTree106 = new BuildBinaryTree106();
        System.out.println(buildBinaryTree106.buildTree(inOrder, postOrder));
    }
}

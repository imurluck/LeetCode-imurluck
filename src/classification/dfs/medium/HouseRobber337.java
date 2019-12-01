package classification.dfs.medium;

import model.TreeNode;

public class HouseRobber337 {


    public int rob(TreeNode root) {
        int[] result = dfsAndDp(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfsAndDp(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] leftMax = dfsAndDp(root.left);
        int[] rightMax = dfsAndDp(root.right);
        int[] result = new int[2];
        result[0] = Math.max(leftMax[1], leftMax[0]) + Math.max(rightMax[0], rightMax[1]);
        result[1] = leftMax[0] + rightMax[0] + root.val;
        return result;
    }
}

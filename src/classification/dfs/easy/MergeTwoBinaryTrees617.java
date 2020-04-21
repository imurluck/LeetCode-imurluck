package classification.dfs.easy;

import model.TreeNode;

public class MergeTwoBinaryTrees617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode notNullNode;
        if (t1 != null) {
            notNullNode = t1;
        } else {
            notNullNode = t2;
        }
        int leftValue = t1 != null ? t1.val : 0;
        int rightValue = t2 != null ? t2.val : 0;
        notNullNode.val = leftValue + rightValue;
        notNullNode.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
        notNullNode.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
        return notNullNode;
    }
}

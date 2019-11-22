package classification.dfs;

import model.TreeNode;

public class SameTree100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == q) {
                return true;
            } else {
                return false;
            }
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

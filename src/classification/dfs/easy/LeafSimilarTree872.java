package classification.dfs.easy;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTree872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> value1List = new ArrayList<>();
        List<Integer> value2List = new ArrayList<>();
        dfs(value1List, root1);
        dfs(value2List, root2);
        if (value1List.size() != value2List.size()) {
            return false;
        }
        for (int i = 0; i < value1List.size(); i++) {
            if (!value1List.get(i).equals(value2List.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<Integer> valueList, TreeNode node) {
        if (node != null && node.left == null && node.right == null) {
            valueList.add(node.val);
        }
        if (node.left != null) {
            dfs(valueList, node.left);
        }
        if (node.right != null) {
            dfs(valueList, node.right);
        }
    }

    public static void main(String[] args) {
        LeafSimilarTree872 leafSimilarTree872 = new LeafSimilarTree872();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        System.out.println(leafSimilarTree872.leafSimilar(root1, root2));
    }
}

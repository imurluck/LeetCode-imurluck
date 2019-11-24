package classification.dfs.easy;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BinaryTreePath257 {

    public List<String> binaryTreePaths(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        dfs(stack, root, result);
        return result;
    }

    private void dfs(Stack<Integer> stack, TreeNode currentNode, List<String> result) {
        if (currentNode != null && currentNode.left == null && currentNode.right == null) {
            stack.push(currentNode.val);
            result.add(createPath(stack));
            stack.pop();
            return;
        }
        if (currentNode == null) {
            return;
        }
        stack.push(currentNode.val);
        dfs(stack, currentNode.left, result);
        dfs(stack, currentNode.right, result);
        stack.pop();
    }

    private String createPath(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            if (i == stack.size() - 1) {
                sb.append(stack.get(i));
            } else {
                sb.append(stack.get(i)).append("->");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        BinaryTreePath257 binaryTreePath257 = new BinaryTreePath257();
        System.out.println(binaryTreePath257.binaryTreePaths(root));
    }
}

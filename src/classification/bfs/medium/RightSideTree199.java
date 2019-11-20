package classification.bfs.medium;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideTree199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        TreeNode lastNode = root;
        TreeNode nLastNode = root;
        queue.offer(root);
        result.add(root.val);
        bfs(queue, lastNode, nLastNode, result);
        return result;
    }

    private void bfs(Queue<TreeNode> queue, TreeNode lastNode, TreeNode nLastNode, List<Integer> result) {
        if (queue.size() == 0) {
            return;
        }
        result.add(lastNode.val);
        TreeNode node;
        do {
            node = queue.poll();
            if (node.left != null) {
                nLastNode = node.left;
                queue.offer(nLastNode);
            }
            if (node.right != null) {
                nLastNode = node.right;
                queue.offer(nLastNode);
            }
        } while (node != lastNode);
        lastNode = nLastNode;
        bfs(queue, lastNode, nLastNode, result);
    }
}

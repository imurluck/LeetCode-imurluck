package classification.bfs.easy;

import model.Node;
import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDeepTree559 {

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> currentLevel = new LinkedList<>();
        Node lastNode = root;
        Node nLastNode = root;
        currentLevel.offer(root);
        return realMaxDepth(currentLevel, lastNode, nLastNode, 1);
    }

    private static int realMaxDepth(Queue<Node> currentLevel, Node lastNode, Node nLastNode, int currentDepth) {
        Node node;
        do {
            node = currentLevel.poll();
            for (Node childNode : node.children) {
                nLastNode = childNode;
                currentLevel.offer(nLastNode);
            }
        } while (node != lastNode);
        lastNode = nLastNode;
        if (currentLevel.size() == 0) {
            return currentDepth;
        }
        return realMaxDepth(currentLevel, lastNode, nLastNode, ++currentDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
    }
}

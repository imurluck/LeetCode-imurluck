package classification.dfs.medium;

import classification.dfs.Node;

public class PopulatingNextRightNode117 {

    public Node connect(Node root) {
        Node currentNode = root;
        while (currentNode != null) {
            Node dummyNode = new Node();
            Node tailNode = dummyNode;
            while (currentNode != null) {
                if (currentNode.left != null) {
                    tailNode.next = currentNode.left;
                    tailNode = tailNode.next;
                }
                if (currentNode.right != null) {
                    tailNode.next = currentNode.right;
                    tailNode = tailNode.next;
                }
                currentNode = currentNode.next;
            }
            currentNode = dummyNode.next;
        }
        return root;
    }
}

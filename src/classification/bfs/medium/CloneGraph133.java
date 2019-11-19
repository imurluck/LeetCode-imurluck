package classification.bfs.medium;

import java.util.*;

public class CloneGraph133 {

    class Node {

        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node result = new Node(node.val, new ArrayList<>());
        Node currentNode;
        HashMap<Integer, Node> alreadyMap = new HashMap<>();
        alreadyMap.put(result.val, result);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Node tempNode;
        while ((tempNode = queue.poll()) != null) {
            if (alreadyMap.containsKey(tempNode.val)) {
                currentNode = alreadyMap.get(tempNode.val);
            } else {
                currentNode = new Node(tempNode.val, new ArrayList<>());
            }
            if (tempNode.neighbors == null) {
                continue;
            }
            for (Node neighbor : tempNode.neighbors) {
                if (alreadyMap.containsKey(neighbor.val)) {
                    currentNode.neighbors.add(alreadyMap.get(currentNode.val));
                } else {
                    Node nextNode = new Node(neighbor.val, new ArrayList<>());
                    currentNode.neighbors.add(nextNode);
                    queue.offer(neighbor);
                    alreadyMap.put(nextNode.val, nextNode);
                }
            }
        }
        return result;
    }
}

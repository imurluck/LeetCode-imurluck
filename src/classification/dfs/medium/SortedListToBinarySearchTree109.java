package classification.dfs.medium;

import model.ListNode;
import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SortedListToBinarySearchTree109 {

    private List<Integer> listToArray(ListNode head) {
        List<Integer> valueList = new ArrayList<>();
        ListNode tmpNode = head;
        while (tmpNode != null) {
            valueList.add(tmpNode.val);
            tmpNode = tmpNode.next;
        }
        return valueList;
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> valueList = listToArray(head);
        if (valueList.size() == 0) {
            return null;
        }
        return dfs(valueList, 0, valueList.size() - 1);
    }

    private TreeNode dfs(List<Integer> valueList, int left, int right) {
        if (left > right) {
            return null;
        }
        int midIndex = (left + right) / 2;
        TreeNode node = new TreeNode(valueList.get(midIndex));
        node.left = dfs(valueList, left, midIndex - 1);
        node.right = dfs(valueList, midIndex + 1, right);
        return node;
    }
}

package interview.medium;

import model.ListNode;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        ListNode tmpNode = null;
        while (true) {
            int minValue = Integer.MAX_VALUE;
            ListNode minNode = null;
            int index = 0;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node != null && node.val < minValue) {
                    minValue = node.val;
                    minNode = node;
                    index = i;
                }
            }
            if (minNode == null) {
                break;
            } else {
                if (result == null) {
                    result = minNode;
                    tmpNode = minNode;
                } else {
                    tmpNode.next = minNode;
                    tmpNode = tmpNode.next;
                }
                lists[index] = lists[index].next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
//        node1.next.next = new ListNode(5);

        MergeKSortedList solution = new MergeKSortedList();
        solution.mergeKLists(new ListNode[]{node1, node2, node3});
    }
}

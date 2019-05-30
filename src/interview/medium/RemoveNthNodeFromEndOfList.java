package interview.medium;

import model.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node = head;
        ListNode targetNode = null;
        ListNode preTargetNode = head;
        int count = 0;
        while (node != null) {
            count++;
            if (count >= (n + 2)) {
                preTargetNode = preTargetNode.next;
            }
            node = node.next;
        }
        if (preTargetNode == head && count - n < 1) {
            preTargetNode = preTargetNode.next;
            return preTargetNode;
        }
        targetNode = preTargetNode.next;
        preTargetNode.next = targetNode.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        solution.removeNthFromEnd(head, 1);
    }
}

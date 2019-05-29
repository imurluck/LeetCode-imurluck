package easy

import model.ListNode

object MergeTwoSortedLists {

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var tmpL1 = l1
        var tmpL2 = l2
        var header = ListNode(0)
        val result = header
        while (tmpL1 != null && tmpL2 != null) {
            if (tmpL1.`val` <= tmpL2.`val`) {
                header.next = tmpL1
                tmpL1 = tmpL1.next
            } else {
                header.next = tmpL2
                tmpL2 = tmpL2.next
            }
            header = header.next!!
        }
        if (tmpL1 != null) {
            header.next = tmpL1
        } else if (tmpL2 != null) {
            header.next = tmpL2
        }
        return result.next
    }
}

fun main() {
    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next!!.next = ListNode(4)

    val l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next!!.next = ListNode(4)

    MergeTwoSortedLists.mergeTwoLists(l1, l2)
}
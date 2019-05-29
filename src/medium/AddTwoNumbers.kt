package medium

import extensions.print
import model.ListNode

internal fun addTwoNumbers(l1: ListNode?, l2: ListNode): ListNode? {
    val l1Len = getListLength(l1)
    val l2Len = getListLength(l2)
    val maxList = if (l1Len > l2Len) l1 else l2
    val minList = if (l1Len <= l2Len) l1 else l2
    var destLen = Math.abs(l1Len - l2Len)
    var result = ListNode(0)
    var resultTmp: ListNode? = result
    var currentMaxNode = maxList
    var currentMinNode = minList
    var add = 0
    while (currentMaxNode != null && currentMinNode != null) {
        val value = currentMaxNode.`val` + currentMinNode.`val` + add
        resultTmp!!.next = ListNode(value % 10)
        resultTmp = resultTmp.next
        add = value / 10
        currentMaxNode = currentMaxNode.next
        currentMinNode = currentMinNode.next
    }
    if (destLen > 0) {
        while (currentMaxNode != null) {
            val value = currentMaxNode!!.`val` + add
            resultTmp!!.next = ListNode(value % 10)
            resultTmp = resultTmp.next
            currentMaxNode = currentMaxNode.next
            add = value / 10
        }
    }
    if (add > 0) {
        resultTmp!!.next = ListNode(add)
        resultTmp = resultTmp.next
    }
    return result.next
}

internal fun getListLength(header: ListNode?): Int {
    var len = 0
    var node = header
    while (node != null) {
        len++
        node = node.next
    }
    return len
}

fun main() {
    val l1 = ListNode(9)
    l1.next = ListNode(1)
    l1.next!!.next = ListNode(6)

    val l2 = ListNode(0)
//    l2.next = ListNode(6)
//    l2.next!!.next = ListNode(4)

    addTwoNumbers(l1, l2)?.print()
}
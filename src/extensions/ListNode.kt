package extensions

import model.ListNode

internal fun ListNode.print() {
    var tmpNode: ListNode? = this
    while (tmpNode != null) {
        if (tmpNode.next == null) {
            print("${tmpNode.`val`}\n")
        } else {
            print("${tmpNode.`val`} ")
        }
        tmpNode = tmpNode.next
    }
}
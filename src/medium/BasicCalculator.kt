package medium

import java.util.*

fun calculate(str: String): Int {
    if (str.isEmpty()) return 0
    val stack = Stack<Int>()
    var lastOperation = ' '
    var i = 0
    while (i < str.length) {
        if (str[i] == ' ') {
            i++
            continue
        }
        when (str[i]) {
            '+' -> {
                if (stack.size >= 2) {

                } else lastOperation = '+'
            }
            '-' -> {
                if (stack.size >= 2) {

                } else lastOperation = '-'
            }
            '*' -> {
                i++
                stack.push(stack.pop() * (str[i].toInt() - '0'.toInt()))
            }
            '/' -> {
                i++
                stack.push(stack.pop() / (str[i].toInt() - '0'.toInt()))
            }
            else -> stack.push((str[i].toInt() - '0'.toInt()))
        }
        i++
    }
    return calculateLast(stack, lastOperation)
}

private fun calculateLast(stack: Stack<Int>, lastOperation: Char): Int {
    return if (stack.size >= 2) {
        when (lastOperation) {
            '+' -> stack.pop() + stack.pop()
            '-' -> stack.pop() - stack.pop()
            else -> 0
        }
    } else {
        stack.pop()
    }
}

fun main() {
    println(calculate("3 + 2 * 2"))
}
package easy

import java.util.*

object ValidParentheses {

    private fun isInLeft(c: Char): Boolean {
        return c == '(' || c == '{' || c == '['
    }

    private fun isInRight(c: Char): Boolean {
        return c == ')' || c == '}' || c == ']'
    }

    private fun isTogether(c1: Char, c2: Char): Boolean {
        return (c1 == '(' && c2 == ')')
                || (c1 == '{' && c2 == '}')
                || (c1 == '[' && c2 == ']')
    }

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (c in s) {
            if (isInLeft(c)) {
                stack.push(c)
            } else if (!stack.empty() && isTogether(stack.peek(), c)) {
                stack.pop()
            } else {
                return false
            }
        }
        return stack.empty()
    }
}

fun main() {
    println(ValidParentheses.isValid("]]"))
}
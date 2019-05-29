package easy

object PalindromeNumber {

    fun isPalindrome(x: Int): Boolean {
        val str = x.toString()
        for (i in 0 until str.length) {
            if (str[i] != str[str.length - i - 1]) {
                return false
            }
        }
        return true
    }
}

fun main() {
    println(PalindromeNumber.isPalindrome(123))
}
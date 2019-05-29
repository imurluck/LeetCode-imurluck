package easy

object LongestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        var result = ""
        var minLength = Int.MAX_VALUE
        for (str in strs) {
            minLength = Math.min(str.length, minLength)
        }

        for (i in 0 until minLength) {
            val c = strs[0][i]
            for (j in 1 until strs.size) {
                if (strs[j][i] != c) {
                    return result
                }
            }
            result += c
        }
        return result
    }
}

fun main() {
    println(LongestCommonPrefix
            .longestCommonPrefix(arrayOf("flower","flow","flight")))
}
package easy

object ImplementStrStr {

    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) {
            return 0
        }
        for (i in 0 until haystack.length) {
            var yes = true
            for (j in 0 until needle.length) {
                if ((i + j) >= haystack.length || needle[j] != haystack[i + j]) {
                    yes = false
                    break
                }
            }
            if (yes) return i
        }
        return -1
    }
}
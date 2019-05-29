package easy

object RomanToInteger {

    private val map = HashMap<Char, Int>()

    private fun initMap() {
        map['I'] = 1
        map['V'] = 5
        map['X'] = 10
        map['L'] = 50
        map['C'] = 100
        map['D'] = 500
        map['M'] = 1000
    }

    fun romanToInt(s: String): Int {
        map.clear()
        initMap()
        if (s == null || s.isEmpty()) {
            return 0
        }
        var result = map[s[s.length - 1]]!!
        var lastC = s[s.length - 1]
        for (c in (s.length - 2) downTo 0) {
            if (map[s[c]]!! >= map[lastC]!!) {
                result += map[s[c]]!!
            } else {
                result -= map[s[c]]!!
            }
            lastC = s[c]
        }
        return result
    }
}

fun main() {
    println(RomanToInteger.romanToInt("MCMXCIV"))
}
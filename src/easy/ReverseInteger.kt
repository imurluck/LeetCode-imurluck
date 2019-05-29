package easy

class ReverseInteger {

    fun reverse(x: Int): Int {
        var result = 0
        var arg = x
        while (arg != 0) {
            val tmp = result * 10.toLong() + arg % 10
            if (tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE) {
                return 0
            }
            result = result * 10 + (arg % 10)
            arg /= 10
        }
        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val rt = ReverseInteger()
            System.out.println(rt.reverse(-2143847412))
        }
    }
}


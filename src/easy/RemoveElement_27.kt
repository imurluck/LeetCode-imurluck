package easy


object RemoveElement {

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var length = nums.size
        var lastEmptyIndex = 0
        for (i in 0 until nums.size) {
            if (nums[i] == `val`) {
                length--
            } else {
                nums[lastEmptyIndex] = nums[i]
                lastEmptyIndex++
            }
        }
        return length
    }
}

fun main() {
    val nums = intArrayOf(0,1,2,2,3,0,4,2)
    val len = RemoveElement.removeElement(nums, 2)
    for (i in 0 until len) {
        print("${nums[i]} ")
    }
}

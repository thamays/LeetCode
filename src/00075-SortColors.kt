//75. Sort Colors
//https://leetcode.com/problems/sort-colors
//
fun main() {
    sortColors(intArrayOf(2, 0, 2, 1, 1, 0))
}

fun sortColors(nums: IntArray): Unit {
    var zeros = 0
    var ones = 0

    for (i in nums.indices) {
        if (nums[i] == 0) {
            zeros += 1
        }

        if (nums[i] == 1) {
            ones += 1
        }
    }

    for (i in 0..<zeros) {
        nums[i] = 0
    }

    for (i in zeros..<zeros + ones) {
        nums[i] = 1
    }

    for (i in zeros + ones..<nums.size) {
        nums[i] = 2
    }

    nums.forEach { println(it) }
}

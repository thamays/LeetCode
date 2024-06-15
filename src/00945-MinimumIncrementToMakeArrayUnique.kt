//945. Minimum Increment to Make Array Unique
//https://leetcode.com/problems/minimum-increment-to-make-array-unique
//
fun main() {
    println(minIncrementForUnique(intArrayOf(1, 2, 2)))
    println(minIncrementForUnique(intArrayOf(3, 2, 1, 2, 1, 7)))
}

fun minIncrementForUnique(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var moves = 0

    nums.sort()

    for (i in 1..<nums.size) {
        if (nums[i] <= nums[i - 1]) {
            val increment = nums[i - 1] + 1 - nums[i]
            nums[i] = nums[i - 1] + 1
            moves += increment
        }
    }

    return moves
}
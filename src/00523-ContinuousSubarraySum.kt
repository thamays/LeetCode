//523. Continuous Subarray Sum
//https://leetcode.com/problems/continuous-subarray-sum
//
fun main() {
    println(continuousSubarraySum(intArrayOf(23, 2, 4, 6, 7), 6))
}

fun continuousSubarraySum(nums: IntArray, k: Int): Boolean {
    val remainderMap = mutableMapOf<Int, Int>()
    remainderMap[0] = -1

    var currentSum = 0

    for (i in nums.indices) {
        currentSum += nums[i]

        val remainder = currentSum % k

        println(remainder)

        if (remainderMap.containsKey(remainder)) {
            if (i - remainderMap[remainder]!! > 1) {
                return true
            }
        } else {
            remainderMap[remainder] = i
        }
    }

    return false
}

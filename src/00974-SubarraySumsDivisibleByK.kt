//974. Subarray Sums Divisible by K
//https://leetcode.com/problems/subarray-sums-divisible-by-k
//
fun main() {
    println(subarraySumsDivisibleByK(intArrayOf(4, 5, 0, -2, -3, 1), 5))
    println(subarraySumsDivisibleByK(intArrayOf(5), 9))
}

fun subarraySumsDivisibleByK(nums: IntArray, k: Int): Int {
    val remainderCount = mutableMapOf<Int, Int>()
    remainderCount[0] = 1  // A remainder of 0 is initially counted once.

    var prefixSum = 0
    var count = 0

    for (num in nums) {
        prefixSum += num
        var remainder = prefixSum % k

        // Adjust remainder to be positive
        if (remainder < 0) {
            remainder += k
        }

        // If this remainder has been seen before, it means we found some subarrays
        // whose sum is divisible by k
        count += remainderCount.getOrDefault(remainder, 0)

        // Update the map with the current remainder
        remainderCount[remainder] = remainderCount.getOrDefault(remainder, 0) + 1
    }

    return count
}

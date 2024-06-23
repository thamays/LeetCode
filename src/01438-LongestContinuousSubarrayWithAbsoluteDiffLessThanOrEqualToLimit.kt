import java.util.*

//1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
//
fun main() {
    println(longestSubarray(intArrayOf(8, 2, 4, 7), 4))
    println(longestSubarray(intArrayOf(10, 1, 2, 4, 7, 2), 5))
    println(longestSubarray(intArrayOf(4, 2, 2, 2, 4, 4, 2, 2), 0))
}

fun longestSubarray(nums: IntArray, limit: Int): Int {
    val maxDeque: Deque<Int> = LinkedList() // To store the indices of the elements in non-increasing order
    val minDeque: Deque<Int> = LinkedList() // To store the indices of the elements in non-decreasing order
    var left = 0
    var result = 0

    for (right in nums.indices) {
        // Maintain the maxDeque
        while (maxDeque.isNotEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
            maxDeque.pollLast()
        }
        maxDeque.addLast(right)

        // Maintain the minDeque
        while (minDeque.isNotEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
            minDeque.pollLast()
        }
        minDeque.addLast(right)

        // Ensure the current window is valid
        while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
            if (maxDeque.peekFirst() == left) {
                maxDeque.pollFirst()
            }
            if (minDeque.peekFirst() == left) {
                minDeque.pollFirst()
            }
            left++
        }

        // Calculate the maximum length of the valid window
        result = maxOf(result, right - left + 1)
    }

    return result
}
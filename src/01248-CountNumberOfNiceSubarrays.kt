//1248. Count Number of Nice Subarrays
//https://leetcode.com/problems/count-number-of-nice-subarrays
//
fun main() {
    println(numberOfSubarrays(intArrayOf(1, 1, 2, 1, 1), 3))
    println(numberOfSubarrays(intArrayOf(2, 4, 6), 1))
    println(numberOfSubarrays(intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2), 2))
}

fun numberOfSubarrays(nums: IntArray, k: Int): Int {
    var currSum = 0
    var subArrays = 0

    val prefixSum = HashMap<Int, Int>()
    prefixSum[currSum] = 1

    for (element in nums) {
        currSum += element % 2

        if (prefixSum.containsKey(currSum - k)) {
            subArrays += prefixSum[currSum - k]!!
        }

        prefixSum[currSum] = prefixSum.getOrDefault(currSum, 0) + 1
    }

    return subArrays
}
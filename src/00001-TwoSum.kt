//1. Two Sum
//https://leetcode.com/problems/two-sum/description/
fun main() {
    val twoSum = twoSum(intArrayOf(1, 3, 3), 6)
    println("${twoSum.size}")
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val numMap = mutableMapOf<Int, Int>()

    for (i in nums.withIndex()) {
        if (numMap.containsKey(target - i.value)) {
            return intArrayOf(numMap[target - i.value]!!, i.index)
        }
        numMap[i.value] = i.index
    }

    return intArrayOf()
}
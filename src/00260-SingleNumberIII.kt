//260. Single Number III
//https://leetcode.com/problems/single-number-iii
//
fun main() {
    val array = singleNumberIII(
        intArrayOf(4, 1, 2, 1, 2)
    )
//    println("[${array[0]},${array[1]}]")
}

fun singleNumberIII(nums: IntArray): IntArray {
//    second
    return nums.groupBy { it }.filterValues { it.size == 1 }.keys.toIntArray()

//    first
//    val map: HashMap<Int, Int> = hashMapOf()
//    for (i in nums.indices) {
//        if (map.containsKey(nums[i])) {
//            map[nums[i]] = map[nums[i]]!! + 1
//        } else {
//            map[nums[i]] = 1
//        }
//    }
//
//    return map.filterValues { it == 1 }.keys.toIntArray()
}

//330. Patching Array
//https://leetcode.com/problems/patching-array
//
fun main() {
    println(minPatches(intArrayOf(1, 5, 10), 20))
}

fun minPatches(nums: IntArray, n: Int): Int {
    var patches = 0
    var miss = 1
    var i = 0

    while (miss <= n) {
        if (i < nums.size && nums[i] <= miss) {
            miss += nums[i]
            i += 1
        } else {
            miss += miss
            patches += 1
        }
    }

    return patches
}
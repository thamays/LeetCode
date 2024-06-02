//88. Merge Sorted Array
//https://leetcode.com/problems/merge-sorted-array
//
fun main() {
    println(mergeSortedArray(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3))
}

fun mergeSortedArray(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    for (i in 0..<m + n) {
        nums1[i] = if (m > i) nums1[i] else nums2[i - m]
    }

    nums1.sort()
    nums1.forEach {
        println(it)
    }
}

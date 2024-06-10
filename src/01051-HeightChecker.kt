//1051. Height Checker
//https://leetcode.com/problems/height-checker
//
fun main() {
    println(heightChecker(intArrayOf(1, 1, 4, 2, 1, 3)))
    println(heightChecker(intArrayOf(5, 1, 2, 3, 4)))
    println(heightChecker(intArrayOf(1, 2, 3, 4, 5)))
}

fun heightChecker(heights: IntArray): Int {
    val sortedH = heights.sorted()
    var count = 0

    for (i in sortedH.indices) {
        if (sortedH[i] != heights[i]) {
            count += 1
        }
    }

    return count
}

//1791. Find Center of Star Graph
//https://leetcode.com/problems/find-center-of-star-graph
//
fun main() {
    findCenter(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(4, 2)))
}

fun findCenter(edges: Array<IntArray>): Int {
    val first = edges[0][0]
    val second = edges[0][1]

    return if (edges[1][0] == first || edges[1][1] == first) {
        first
    } else {
        second
    }
}
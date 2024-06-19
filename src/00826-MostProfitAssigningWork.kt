//826. Most Profit Assigning Work
//https://leetcode.com/problems/most-profit-assigning-work
//
fun main() {
    println(maxProfitAssignment(intArrayOf(2, 4, 6, 8, 10), intArrayOf(10, 20, 30, 40, 50), intArrayOf(4, 5, 6, 7)))
    println(maxProfitAssignment(intArrayOf(85, 47, 57), intArrayOf(24, 66, 99), intArrayOf(40, 25, 25)))
}

fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
    var pro = 0

    val diffPro = mutableListOf<Pair<Int, Int>>()

    for (i in difficulty.indices) {
        diffPro.add(Pair(difficulty[i], profit[i]))
    }

    diffPro.sortByDescending { it.second }

    for (element in worker) {
        for (j in 0..<diffPro.size) {
            if (element >= diffPro[j].first) {
                pro += diffPro[j].second
                break
            }
        }
    }

    return pro
}
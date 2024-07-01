//1550. Three Consecutive Odds
//https://leetcode.com/problems/three-consecutive-odds
//
fun main() {
    println(threeConsecutiveOdds(intArrayOf(1, 2, 34, 3, 4, 5, 7, 23, 12)))
}

fun threeConsecutiveOdds(arr: IntArray): Boolean {
    for (i in 0..<arr.size - 2) {
        if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
            return true
        }
    }

    return false
}
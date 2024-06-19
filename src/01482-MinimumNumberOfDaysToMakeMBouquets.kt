//1482. Minimum Number of Days to Make m Bouquets
//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets
//
fun main() {
    println(minDays(intArrayOf(1, 10, 3, 10, 2), 3, 1))
    println(minDays(intArrayOf(1, 10, 3, 10, 2), 3, 2))
    println(minDays(intArrayOf(7, 7, 7, 7, 12, 7, 7), 2, 3))
    println(minDays(intArrayOf(2, 3, 4, 5, 12, 1, 2, 3), 2, 3))
}

fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
    val n = bloomDay.size
    if (m * k > n) return -1  // Not enough flowers to make m bouquets

    var left = 1
    var right = bloomDay.maxOrNull()!!

    while (left < right) {
        val mid = left + (right - left) / 2
        if (canMakeBouquets(bloomDay, m, k, mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    // Final check if the left value can make the required bouquets
    return if (canMakeBouquets(bloomDay, m, k, left)) left else -1
}

fun canMakeBouquets(bloomDay: IntArray, m: Int, k: Int, days: Int): Boolean {
    var bouquets = 0
    var flowers = 0

    for (bloom in bloomDay) {
        if (bloom <= days) {
            flowers++
            if (flowers == k) {
                bouquets++
                flowers = 0
                if (bouquets == m) return true
            }
        } else {
            flowers = 0
        }
    }

    return bouquets >= m
}

//
//fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
//    if (bloomDay.size < m * k) return -1
//
//    var toMutableList = bloomDay.toMutableList()
//
//    var day = 0
//    for (j in 0 until m) {
//        var maxDay = -1
//
//        var k1 = -1
//        var k2 = -1
//
//        for (i in 0 until toMutableList.size - k + 1) {
//            val subList = toMutableList.subList(i, i + k)
//            val calMax = subList.max()
//
//            if (maxDay == -1) {
//                maxDay = calMax
//            }
//
//            if (maxDay >= calMax) {
//                maxDay = calMax
//                k1 = i
//                k2 = i + k
//            }
//        }
//
//        day = maxDay
//
//        if (j != m - 1) {
//            for (n in k2 - 1 downTo k1) {
//                toMutableList.removeAt(n)
//            }
//        }
//
//    }
//
//    return day
//}
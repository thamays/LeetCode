//1552. Magnetic Force Between Two Balls
//https://leetcode.com/problems/magnetic-force-between-two-balls
//
fun main() {
    println(maxDistance(intArrayOf(1, 2, 3, 4, 7), 3))
    println(maxDistance(intArrayOf(5, 4, 3, 2, 1, 1000000000), 2))
}

fun maxDistance(position: IntArray, m: Int): Int {
    var answer = 0
    val n = position.size

    position.sort()

    var low = 1;
    var high = Math.ceil(position[n - 1] / (m - 1.0)).toInt()

    while (low <= high) {
        val mid = low + (high - low) / 2

        if (canPlaceBalls(mid, position, m)) {
            answer = mid
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return answer
}

fun canPlaceBalls(x: Int, position: IntArray, m: Int): Boolean {
    var prevBallPos = position[0]
    var ballsPlaced = 1

    for (i in 1 until position.size) {
        val currPos = position[i]
        if (currPos - prevBallPos >= x) {
            ballsPlaced += 1
            prevBallPos = currPos
            if (ballsPlaced == m) {
                return true
            }
        }
    }

    return ballsPlaced == m
}
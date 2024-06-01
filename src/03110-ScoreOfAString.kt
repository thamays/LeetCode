import kotlin.math.abs

//3110. Score of a String
//https://leetcode.com/problems/score-of-a-string
//
fun main() {
    println(scoreOfAString("zaz"))
}

fun scoreOfAString(s: String): Int {
    var total = 0
    for (n in 1..<s.length) {
        total += abs(s[n - 1] - s[n])
    }
    return total
}

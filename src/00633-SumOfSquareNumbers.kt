import kotlin.math.sqrt

//633. Sum of Square Numbers
//https://leetcode.com/problems/sum-of-square-numbers
//
fun main() {
    println(judgeSquareSum(2147483646))
}

fun judgeSquareSum(c: Int): Boolean {
    var a = 0
    var b = sqrt(c.toDouble()).toInt()

    while (a <= b) {
        val sum = a.toLong() * a + b.toLong() * b  // Use Long to avoid overflow
        when {
            sum == c.toLong() -> return true
            sum < c.toLong() -> a++
            else -> b--
        }
    }

    return false
}
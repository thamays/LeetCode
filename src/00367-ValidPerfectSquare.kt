//367. Valid Perfect Square
//https://leetcode.com/problems/valid-perfect-square
//
fun main() {
    println(isPerfectSquare(1))
}

fun isPerfectSquare(num: Int): Boolean {
    var a = 1
    var b = num

    while (a <= b) {
        val mid = a + (b - a) / 2
        val square = mid.toLong() * mid.toLong()

        when {
            square == num.toLong() -> return true
            square < num -> a = mid + 1
            else -> b = mid - 1
        }
    }

    return false
}
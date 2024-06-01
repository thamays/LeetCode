//9. Palindrome Number
//https://leetcode.com/problems/palindrome-number
//
fun main() {
    println(palindromeNumber(1))
}

fun palindromeNumber(x: Int): Boolean {
    val s = x.toString()
    for (i in 0..<s.length / 2) {
        val b = s[i] == s[s.length - 1 - i]
        if (!b) return false
    }
    return true
}

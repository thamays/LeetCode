//409. Longest Palindrome
//https://leetcode.com/problems/longest-palindrome
//
fun main() {
    println(longestPalindrome("ccc"))
}

fun longestPalindrome(s: String): Int {
    val map = HashMap<Char, Int>()

    for (i in s) {
        map[i] = map.getOrDefault(i, 0) + 1
    }

    var count = 0
    var isOdd = false

    for (i in map) {
        if (i.value % 2 == 0) {
            count += i.value
        } else {
            count += i.value - 1
            isOdd = true
        }
    }

    return count + if (isOdd) 1 else 0
}

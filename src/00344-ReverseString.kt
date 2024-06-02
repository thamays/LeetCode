//344. Reverse String
//https://leetcode.com/problems/reverse-string
//
fun main() {
    println(reverseString(charArrayOf('h', 'e', 'l', 'l', 'o')))
}

fun reverseString(s: CharArray): Unit {
    for (i in 0..<s.size / 2) {
        val tem = s[i]
        s[i] = s[s.size - i - 1]
        s[s.size - i - 1] = tem
    }

//    first
//    return s.reverse()
}

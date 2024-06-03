//2486. Append Characters to String to Make Subsequence
//https://leetcode.com/problems/append-characters-to-string-to-make-subsequence
//
fun main() {
    println(appendCharactersToStringToMakeSubsequence("coaching", "coding"))
    println(appendCharactersToStringToMakeSubsequence("abcde", "a"))
    println(appendCharactersToStringToMakeSubsequence("z", "abcde"))
    println(appendCharactersToStringToMakeSubsequence("vrykt", "rkge"))
}

fun appendCharactersToStringToMakeSubsequence(s: String, t: String): Int {
//    var n = t.length
//    for (i in t.indices) {
//        if (s.contains(t[i])) {
//            s.removeRange(0, s.indexOfFirst { it == t[i] })
//            n -= 1
//        } else {
//            break
//        }
//    }
//    return n

    var n = t.length
    var sIndex = 0

    for (i in t.indices) {
        val tChar = t[i]
        while (sIndex < s.length && s[sIndex] != tChar) {
            sIndex++
        }
        if (sIndex < s.length && s[sIndex] == tChar) {
            sIndex++
            n -= 1
        } else {
            break
        }
    }
    return n
}

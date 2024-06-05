import kotlin.math.min

//1002. Find Common Characters
//https://leetcode.com/problems/find-common-characters
//
fun main() {
    println(findCommonCharacters(arrayOf("bella", "label", "roller")))
//    println(findCommonCharacters(arrayOf("cool", "lock", "cook")))
}

fun findCommonCharacters(words: Array<String>): List<String> {
    fun countChars(word: String): IntArray {
        val counts = IntArray(26)
        for (char in word) {
            counts[char - 'a'] += 1
        }
        return counts
    }

    val minFreq = countChars(words[0])

    for (i in 1..<words.size) {
        val currentFreq = countChars(words[i])
        for (j in 0..<26) {
            minFreq[j] = minOf(minFreq[j], currentFreq[j])
        }
    }

    val result = mutableListOf<String>()
    for (i in 0..<26) {
        for (j in 0..<minFreq[i]) {
            result.add(('a' + i).toString())
        }
    }

    return result
}

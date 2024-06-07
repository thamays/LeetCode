//648. Replace Words
//https://leetcode.com/problems/replace-words
//
fun main() {
    println(replaceWords(arrayListOf("cat", "bat", "rat"), "the cattle was rattled by the battery"))
    println(replaceWords(arrayListOf("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"))
    println(replaceWords(arrayListOf("catt", "cat", "bat", "rat"), "the cattle was rattled by the battery"))
}

fun replaceWords(dictionary: List<String>, sentence: String): String {
    val sortedRoots = dictionary.sortedBy { it.length } // Sort roots by length

    val words = sentence.split(" ")

    val replacedWords = words.map { word ->
        var replacement = word
        for (root in sortedRoots) {
            if (word.startsWith(root)) {
                replacement = root
                break
            }
        }
        replacement
    }

    return replacedWords.joinToString(" ")
}

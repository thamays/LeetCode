//846. Hand of Straights
//https://leetcode.com/problems/hand-of-straights
//
fun main() {
//    println(handOfStraights(intArrayOf(8, 10, 12), 3))
    println(handOfStraights(intArrayOf(1, 2, 3, 6, 2, 3, 4, 7, 8), 3))
}

fun handOfStraights(hand: IntArray, groupSize: Int): Boolean {
    if (hand.size % groupSize != 0) return false

    val cardCount = sortedMapOf<Int, Int>()
    hand.forEach {
        cardCount[it] = cardCount.getOrDefault(it, 0) + 1
    }

    for (card in cardCount.keys) {
        val count: Int = cardCount[card]!!

        if (count > 0) {
            for (i in 0..<groupSize) {
                val currentCard = card + i
                if (cardCount.getOrDefault(currentCard, 0) < count) {
                    return false
                }
                cardCount[currentCard] = cardCount[currentCard]!! - count
            }
        }
    }

    return true
}

//1442. Count Triplets That Can Form Two Arrays of Equal XOR
//https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description/
//
fun main() {
    println(
        countTripletsThatCanFormTwoArraysOfEqualXOR(
            intArrayOf(2, 3, 1, 6, 7)
        )
    )
}

fun countTripletsThatCanFormTwoArraysOfEqualXOR(arr: IntArray): Int {
//    second time
    val n = arr.size
    var step = 0
    for (i in 0..<n) {
        for (j in i + 1..<n) {
            var a = 0
            for (k in i..<j) {
                a = a xor arr[k]
            }

            var b = 0
            for (k in j..<n) {
                b = b xor arr[k]
                if (a == b) {
                    step++
                }
            }
        }
    }

    return step

//    First time
//    var step = 0
//    val ways: MutableList<MutableList<Int>> = mutableListOf()
//
//    for (i in arr.indices) {
//        for (j in i + 1..<arr.size) {
//            for (k in j..<arr.size) {
//                ways.add(mutableListOf(i, j, k))
//            }
//        }
//    }
//
//    for (way in ways) {
//        val aXOR = arr.toMutableList().subList(way[0], way[1]).reduce { acc, i -> acc.xor(i) }
//        val bXOR = arr.toMutableList().subList(way[1], way[2] + 1).reduce { acc, i -> acc.xor(i) }
//        if (aXOR == bXOR) {
//            step += 1
//        }
//    }
//
//    return step
}

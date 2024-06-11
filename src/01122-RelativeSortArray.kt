//1122. Relative Sort Array
//https://leetcode.com/problems/relative-sort-array
//
fun main() {
//    relativeSortArray(intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19), intArrayOf(2, 1, 4, 3, 9, 6)).forEach {
//        println(it)
//    }
    relativeSortArray(intArrayOf(28,6,22,8,44,17), intArrayOf(22,28,8,6)).forEach {
        println(it)
    }
}

fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
    val comArr = mutableListOf<Int>()
    val notComArr = mutableListOf<Int>()

    for (n in arr2.indices) {
        val filter = arr1.filter { it == arr2[n] }
        if (filter.isNotEmpty()) {
            filter.forEach { _ ->
                comArr.add(arr2[n])
            }
        }
    }

    for (n in arr1.indices) {
        if (!arr2.contains(arr1[n])) {
            notComArr.add(arr1[n])
        }
    }

    return (comArr + notComArr.sorted()).toIntArray()
}

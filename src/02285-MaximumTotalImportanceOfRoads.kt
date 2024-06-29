//2285. Maximum Total Importance of Roads
//https://leetcode.com/problems/maximum-total-importance-of-roads
//
fun main() {
    println(
        maximumImportance(
            5,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(0, 2),
                intArrayOf(1, 3),
                intArrayOf(2, 4)
            )
        )
    )
}

fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
    // Step 1: Calculate the degree of each city
    val degree = IntArray(n)
    for (road in roads) {
        degree[road[0]]++
        degree[road[1]]++
    }

    // Step 2: Sort cities by their degree in descending order
    val cities = degree.indices.sortedByDescending { degree[it] }

    // Step 3: Assign values to cities
    val values = IntArray(n)
    for (i in cities.indices) {
        values[cities[i]] = n - i
    }

    // Step 4: Calculate the total importance of all roads
    var totalImportance = 0L
    for (road in roads) {
        totalImportance += values[road[0]] + values[road[1]]
    }

    return totalImportance
//    val importanceCityMap = HashMap<Int, Int>()
//    val city = IntArray(n)
//
//    for (i in roads.indices) {
//        importanceCityMap[roads[i][0]] = importanceCityMap.getOrDefault(roads[i][0], 0) + 1
//        importanceCityMap[roads[i][1]] = importanceCityMap.getOrDefault(roads[i][1], 0) + 1
//    }
//
//    println(importanceCityMap)
//
//    importanceCityMap.toSortedMap()
//
//
////    for (i in 0 until n) {
////        city[i] = importanceCityMap.getOrDefault(i, 0)
////    }
////
////    for (i in 0 until n) {
////        importanceCityMap[i]
////    }
//
//
//    var sum: Long = 0
//    for (i in roads.indices) {
//        sum += importanceCityMap[roads[i][0]]!! + importanceCityMap[roads[i][1]]!!
//    }
//
//    return sum
}

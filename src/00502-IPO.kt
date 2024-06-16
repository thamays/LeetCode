import java.util.*

//502. IPO
//https://leetcode.com/problems/ipo
//
fun main() {
    println(findMaximizedCapital(2, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 1)))
}

fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
    // Step 1: Create a list of projects with their required capital and profits
    val projects = profits.indices.map { i -> Pair(capital[i], profits[i]) }

    // Step 2: Sort projects by the required capital in ascending order
    val sortedProjects = projects.sortedBy { it.first }

    // Step 3: Create a max-heap to store the profits of the projects we can afford
    val maxHeap = PriorityQueue<Int>(compareByDescending { it })

    var currentCapital = w
    var projectIndex = 0

    // Step 4: Iterate up to k times to select at most k projects
    repeat(k) {
        // Add all the projects that can be afforded with the current capital to the heap
        while (projectIndex < sortedProjects.size && sortedProjects[projectIndex].first <= currentCapital) {
            maxHeap.offer(sortedProjects[projectIndex].second)
            projectIndex++
        }

        // If there are no projects that can be started, break early
        if (maxHeap.isEmpty()) {
            return currentCapital
        }

        // Select the project with the maximum profit
        currentCapital += maxHeap.poll()
    }

    return currentCapital
}
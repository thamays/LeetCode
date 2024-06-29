//2192. All Ancestors of a Node in a Directed Acyclic Graph
//https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph
//
fun main() {
    println(
        getAncestors(
            8,
            arrayOf(
                intArrayOf(0, 3),
                intArrayOf(5, 0),
                intArrayOf(2, 3),
                intArrayOf(4, 3),
                intArrayOf(5, 3),
                intArrayOf(1, 3),
                intArrayOf(2, 5),
                intArrayOf(0, 1),
                intArrayOf(4, 5),
                intArrayOf(4, 2),
                intArrayOf(4, 0),
                intArrayOf(2, 1),
                intArrayOf(5, 1)
            )
        )
    )
}

fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {
    // Create a graph representation
    val graph = Array(n) { mutableListOf<Int>() }
    val ancestors = Array(n) { mutableSetOf<Int>() }

    // Build the graph
    for (edge in edges) {
        val from = edge[0]
        val to = edge[1]
        graph[from].add(to)
    }

    // Function to perform DFS and record ancestors
    fun dfs(node: Int, ancestor: Int) {
        for (neighbor in graph[node]) {
            if (ancestor !in ancestors[neighbor]) {
                ancestors[neighbor].add(ancestor)
                dfs(neighbor, ancestor)
            }
        }
    }

    // Start DFS from each node
    for (i in 0 until n) {
        dfs(i, i)
    }

    // Convert sets to sorted lists
    return ancestors.map { it.sorted() }
}
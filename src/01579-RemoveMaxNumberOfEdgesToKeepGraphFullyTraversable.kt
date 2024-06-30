//1579. Remove Max Number of Edges to Keep Graph Fully Traversable
//https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable
//
fun main() {
    println(
        maxNumEdgesToRemove(
            4,
            arrayOf(
                intArrayOf(3, 1, 2),
                intArrayOf(3, 2, 3),
                intArrayOf(1, 1, 3),
                intArrayOf(1, 2, 4),
                intArrayOf(1, 1, 2),
                intArrayOf(2, 3, 4)
            )
        )
    )
    println(
        maxNumEdgesToRemove(
            4,
            arrayOf(
                intArrayOf(3, 1, 2),
                intArrayOf(3, 2, 3),
                intArrayOf(1, 1, 4),
                intArrayOf(2, 1, 4)
            )
        )
    )
    println(
        maxNumEdgesToRemove(
            4,
            arrayOf(
                intArrayOf(3, 2, 3),
                intArrayOf(1, 1, 2),
                intArrayOf(2, 3, 4)
            )
        )
    )
}

fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
    val aliceUnionFind = UnionFind(n + 1)
    val bobUnionFind = UnionFind(n + 1)

    var removableEdges = 0
    var commonEdges = 0

    for ((type, u, v) in edges) {
        if (type == 3) {
            val aliceUnion = aliceUnionFind.union(u, v)
            val bobUnion = bobUnionFind.union(u, v)
            if (aliceUnion || bobUnion) {
                commonEdges++
            } else {
                removableEdges++
            }
        }
    }

    for ((type, u, v) in edges) {
        if (type == 1) {
            if (!aliceUnionFind.union(u, v)) {
                removableEdges++
            }
        } else if ((type == 2)) {
            if (!bobUnionFind.union(u, v)) {
                removableEdges++
            }
        }
    }

    val aliceComponents = (1..n).count { aliceUnionFind.find(it) == it }
    val bobComponents = (1..n).count { bobUnionFind.find(it) == it }

    return if (aliceComponents == 1 && bobComponents == 1) {
        removableEdges
    } else {
        -1
    }

//    val nodes = mutableListOf(n)
//
//    for (i in 1..<n + 1) {
//        nodes.add(i)
//    }
//
//    val accessNodeAlice = mutableListOf<Int>()
//    val accessNodeBob = mutableListOf<Int>()
//
//    val uniqPath = mutableListOf(mutableListOf<Int>())
//
//    var removedPath = 0
//
//    for (i in edges.indices) {
//        if (edges[i][0] == 1 || edges[i][0] == 3) {
//            if (!accessNodeAlice.contains(edges[i][1])) {
//                accessNodeAlice.add(edges[i][1])
//            }
//            if (!accessNodeAlice.contains(edges[i][2])) {
//                accessNodeAlice.add(edges[i][2])
//            }
//        }
//
//        if (edges[i][0] == 2 || edges[i][0] == 3) {
//            if (!accessNodeBob.contains(edges[i][1])) {
//                accessNodeBob.add(edges[i][1])
//            }
//            if (!accessNodeBob.contains(edges[i][2])) {
//                accessNodeBob.add(edges[i][2])
//            }
//        }
//
////        if (!uniqPath.contains(listOf(edges[i][0], edges[i][1], edges[i][2]))) {
////            uniqPath.add(mutableListOf(edges[i][1], edges[i][2]))
////        }
//    }
//
//    if (accessNodeAlice.containsAll(nodes) && accessNodeBob.containsAll(nodes)) {
//        return 2
//    } else {
//        return -1
//    }
}

class UnionFind(private val size: Int) {
    private val parent = IntArray(size) { it }
    private val rank = IntArray(size) { 1 }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY
            } else {
                parent[rootY] = rootX
                rank[rootX]++
            }
            return true
        }
        return false
    }
}
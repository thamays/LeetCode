package learning.algorithms

class QuickUnionUF(n: Int) {
    private var id: IntArray = intArrayOf()
    private var sz: IntArray = intArrayOf()

    init {
        id = IntArray(n)
        for (i in 0..<n) {
            id[i] = i
        }
    }

    private fun root(i: Int): Int {
        var j = i
        while (j != id[j])
            j = id[j]
        return j
    }

    fun connected(p: Int, q: Int): Boolean {
        return root(p) == root(q)
    }

    fun union(p: Int, q: Int) {
        val i = root(p)
        val j = root(q)
        id[i] = j
    }

    fun unionWeighted(p: Int, q: Int) {
        val i = root(p)
        val j = root(q)

        if (i == j) return

        if (sz[i] < sz[j]) {
            id[i] = j
            sz[j] += sz[i]
        } else {
            id[j] = i
            sz[i] += sz[j]
        }
    }
}
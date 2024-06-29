package learning.algorithms

fun main() {

}

class QuickFindUF(n: Int) {
    private var id: IntArray = intArrayOf()

//    N
    init {
        id = IntArray(n)
        for (i in 0..<n) {
            id[i] = i
        }
    }

//    easy find (2)
    fun connected(p: Int, q: Int): Boolean {
        return id[p] == id[q]
    }

//    hard union (many changes N)
//    N + 4
    fun union(p: Int, q: Int) {
        for (i in id.indices) {
            if (id[p] == id[i]) {
                id[i] = id[q]
            }
        }
    }
}
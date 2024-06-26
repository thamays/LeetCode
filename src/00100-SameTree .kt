//100. Same Tree
//https://leetcode.com/problems/same-tree
//
fun main() {
//    println(isSameTree(intArrayOf(1,2,3), intArrayOf(1,2,3)))
}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    // If both nodes are null, the trees are the same at this node
    if (p == null && q == null) return true
    // If one of the nodes is null, the trees are not the same
    if (p == null || q == null) return false
    // If the values of the nodes are different, the trees are not the same
    if (p.`val` != q.`val`) return false

    // Recursively check the left and right subtrees
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
}


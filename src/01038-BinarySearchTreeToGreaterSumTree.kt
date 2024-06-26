//1038. Binary Search Tree to Greater Sum Tree
//https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree
//
fun main() {
    bstToGst(TreeNode(0))
}

fun bstToGst(root: TreeNode?): TreeNode? {
    var sum = 0

    fun reverseInOrder(node: TreeNode?) {
        if (node == null) return

        reverseInOrder(node.right)
        sum += node.`val`
        node.`val` = sum

        reverseInOrder(node.left)
    }

    reverseInOrder(root)
    return root
}

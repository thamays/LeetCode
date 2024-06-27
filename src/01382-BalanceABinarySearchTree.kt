//1382. Balance a Binary Search Tree
//https://leetcode.com/problems/balance-a-binary-search-tree/description
//
fun main() {
//    [1,null,2,null,3,null,4,null,null]
    val root = TreeNode(1).apply {
        right = TreeNode(2).apply {
            right = TreeNode(3).apply {
                right = TreeNode(4)
            }
        }
    }

    balanceBST(root)
}

fun balanceBST(root: TreeNode?): TreeNode? {
    val sortedValues = mutableListOf<Int>()
    inorderTraversal(root, sortedValues)
    return constructBalanceBST(sortedValues, 0, sortedValues.size - 1)
}

fun inorderTraversal(node: TreeNode?, sortedValues: MutableList<Int>) {
    if (node == null) return
    inorderTraversal(node.left, sortedValues)
    sortedValues.add(node.`val`)
    inorderTraversal(node.right, sortedValues)
}

fun constructBalanceBST(sortedValues: List<Int>, start: Int, end: Int): TreeNode? {
    if (start > end) return null
    val mid = start + (end - start) / 2
    val node = TreeNode(sortedValues[mid])
    node.left = constructBalanceBST(sortedValues, start, mid - 1)
    node.right = constructBalanceBST(sortedValues, mid + 1, end)
    return node
}
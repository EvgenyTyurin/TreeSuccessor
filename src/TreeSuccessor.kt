/**
 * Find successor in search binary tree
 */

fun main() {
    // Prepare tree
    val node5 = BinaryTreeNode(5)
    val node3 = BinaryTreeNode(3)
    val node4 = BinaryTreeNode(4)
    val node7 = BinaryTreeNode(7)
    val node6 = BinaryTreeNode(6)
    node5.setChildLeft(node3)
    node3.setChildRight(node4)
    node5.setChildRight(node7)
    node7.setChildLeft(node6)
    node5.printTree()
    // Find successors
    println(findSuccessor(node5)) // Must be 6
    println(findSuccessor(node4)) // Must be 5
}

private fun findSuccessor(node: BinaryTreeNode): BinaryTreeNode {
    return if (node.getChildRight() != null) {
        findMostLeft(node.getChildRight()!!)
    } else {
        findLeftParent(node)
    }
}

private fun findMostLeft(node: BinaryTreeNode): BinaryTreeNode {
    return if (node.getChildLeft() == null) {
        node
    } else {
        findMostLeft(node.getChildLeft()!!)
    }
}

private fun findLeftParent(node: BinaryTreeNode): BinaryTreeNode {
    val parent = node.getParent() ?: return node
    if (parent.getChildLeft() != null && parent.getChildLeft()!!.getData() == node.getData())
        return parent
    return findLeftParent(parent)
}

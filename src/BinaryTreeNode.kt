/**
 * Binary tree with parent link
 */


import java.util.LinkedList

class BinaryTreeNode(private val data: Int) {

    private var childLeft: BinaryTreeNode? = null
    private var childRight: BinaryTreeNode? = null
    private var parent: BinaryTreeNode? = null

    fun setChildLeft(node: BinaryTreeNode) {
        childLeft = node
        node.parent = this
    }

    fun getChildLeft(): BinaryTreeNode? {
        return childLeft
    }

    fun getChildRight(): BinaryTreeNode? {
        return childRight
    }

    fun setChildRight(node: BinaryTreeNode) {
        childRight = node
        node.parent = this
    }

    fun getParent(): BinaryTreeNode? {
        return parent
    }

    fun getData(): Int {
        return data
    }

    // Prints node + children
    fun printTree() {
        val queue = LinkedList<BinaryTreeNode>()
        queue.add(this)
        while (!queue.isEmpty()) {
            val node = queue.poll()
            print(node.data.toString() + " ")
            if (node.childLeft != null)
                node.childLeft?.let { queue.add(it) }
            if (node.childRight != null)
                node.childRight?.let { queue.add(it) }
        }
        print("\n")
    }

    override fun toString(): String {
        return data.toString()
    }

}

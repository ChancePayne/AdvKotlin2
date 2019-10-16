class TreeNode(val value: Any, val parent: TreeNode?)
val grandparent = TreeNode("grandparent", null)
val parent = TreeNode("parent", grandparent)

fun <T> TreeNode.findParentOfType(clazz: Class<T>): T? {
    var p = parent
    while (p != null && !clazz.isInstance(p)) {
        p = p.parent
    }

    return p as T?
}

inline fun <reified T> TreeNode.findParentOfTypeReified(): T? {
    var p = parent
    while (p != null && p !is T) {
        p = p.parent
    }
    return p as T?
}

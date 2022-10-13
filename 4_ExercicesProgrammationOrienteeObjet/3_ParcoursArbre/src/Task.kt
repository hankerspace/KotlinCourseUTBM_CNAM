import kotlin.random.Random

class Node(val value: Int, var left: Node? = null, var right: Node? = null)

fun printTree(n: Node?) {
    printTree("", n, false)
}

fun printTree(prefix: String, n: Node?, isLeft: Boolean) {
    if (n != null) {
        println(prefix + (if (isLeft) "|-- " else "\\-- ") + n.value)
        printTree(prefix + if (isLeft) "|   " else "    ", n.left, true)
        printTree(prefix + if (isLeft) "|   " else "    ", n.right, false)
    }
}

fun generateTree(height: Int): Node {
    val randomValue = Random.nextInt() % 100
    if (height == 0) return Node(randomValue)
    return Node(randomValue, generateTree(height - 1), generateTree(height - 1))
}

fun sumTree(n: Node?): Int {
    if (n == null) return 0
    return n.value + sumTree(n.left) + sumTree(n.right)
}

fun maxTree(n: Node?): Int {
    if (n == null) return 0
    return maxOf(n.value, maxTree(n.left), maxTree(n.right))
}

fun minTree(n: Node?): Int {
    if (n == null) return Integer.MAX_VALUE
    return minOf(n.value, minTree(n.left), minTree(n.right))
}

fun heightTree(n: Node?): Int {
    if (n == null) return 0
    return 1 + maxOf(heightTree(n.left), heightTree(n.right))
}

fun countTree(n: Node?): Int {
    if (n == null) return 0
    return 1 + countTree(n.left) + countTree(n.right)
}

fun countLeaves(n: Node?): Int {
    if (n == null) return 0
    if (n.left == null && n.right == null) return 1
    return countLeaves(n.left) + countLeaves(n.right)
}

fun main() {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left?.left = Node(4)
    root.left?.right = Node(5)
    printTree(root)

    val root2 = generateTree(20)
    printTree(root2)
    println("Sum: ${sumTree(root2)}")
    println("Max: ${maxTree(root2)}")
    println("Min: ${minTree(root2)}")
    println("Height: ${heightTree(root2)}")
    println("Count: ${countTree(root2)}")
    println("Count leaves: ${countLeaves(root2)}")

}
class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun add(value: T) {
        val node = Node(value)
        if (head == null) {
            head = node
            tail = node
        } else {
            tail?.next = node
            tail = node
        }
    }

    fun remove(value: T) {
        var current = head
        var previous: Node<T>? = null
        while (current != null) {
            if (current.value == value) {
                if (previous != null) {
                    previous.next = current.next
                } else {
                    head = current.next
                }
                if (current.next == null) {
                    tail = previous
                }
                return
            }
            previous = current
            current = current.next
        }
    }

    fun print() {
        var current = head
        while (current != null) {
            print("${current.value} ")
            current = current.next
        }
        println()
    }

    fun get(index: Int): T? {
        var current = head
        var i = 0
        while (current != null) {
            if (i == index) {
                return current.value
            }
            current = current.next
            i++
        }
        return null
    }

    fun size(): Int {
        var current = head
        var i = 0
        while (current != null) {
            current = current.next
            i++
        }
        return i
    }

    fun contains(value: T): Boolean {
        var current = head
        while (current != null) {
            if (current.value == value) {
                return true
            }
            current = current.next
        }
        return false
    }

    fun isEmpty(): Boolean {
        return head == null
    }

    private class Node<T>(val value: T) {
        var next: Node<T>? = null
    }
}

fun main(args: Array<String>) {
    val list = LinkedList<Int>()
    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    list.add(5)
    list.print()

    list.get(2)?.let { println(it) }
    println(list.size())
    println(list.contains(3))
    println(list.isEmpty())

    list.remove(3)
    list.print()
    list.remove(1)
    list.print()
    list.remove(5)
    list.print()
    list.remove(4)
    list.print()
    list.remove(2)
    list.print()
}
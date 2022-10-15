fun doors(n: Int) : List<Int> {
    val doors = BooleanArray(n) { false }

    repeat(doors.size) { i ->
        for (j in i until doors.size step (i + 1)) {
            doors[j] = !doors[j]
        }
    }

    return doors.foldIndexed(emptyList()) { i, acc, door ->
            if (door) acc + (i + 1) else acc
        }
}

fun main() {
    println(doors(1))
    println(doors(2))
    println(doors(3))
    println(doors(4))
    println(doors(5))
    println(doors(6))
    println(doors(7))
    println(doors(100))
    println(doors(1000))
}
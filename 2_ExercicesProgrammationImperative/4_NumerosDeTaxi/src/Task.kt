fun createCubes(n: Long): List<Long> {
    val result = mutableListOf<Long>()
    for (i in 1..n) {
        result.add(i * i * i)
    }
    return result
}

fun findAndPrintTaxi(i: Long, cubesLesser: List<Long>) : Boolean {
// Check if the number is a taxi number
    for(j in cubesLesser.indices) {
        for(k in j + 1 until cubesLesser.size) {
            if (cubesLesser[j] + cubesLesser[k] == i.toLong()) {
                // Ok we have one way to write i as the sum of two cubes. Now be sure there is another way
                for(l in cubesLesser.indices) {
                    for(m in l + 1 until cubesLesser.size) {
                        if(cubesLesser[l] + cubesLesser[m] == i.toLong() && l != j && l != k && m != j && m != k) {
                            println("$i = " +
                                    "${Math.cbrt(cubesLesser[j].toDouble())}^3 ${Math.cbrt(cubesLesser[k].toDouble())}^3 = " +
                                    "${Math.cbrt(cubesLesser[l].toDouble())}^3 ${Math.cbrt(cubesLesser[m].toDouble())}^3")
                            return true
                        }
                    }
                }
            }
        }
    }
    return false
}

fun findTaxi(i: Long, cubesLesser: List<Long>) : Long {
// Check if the number is a taxi number
    for(j in cubesLesser.indices) {
        for(k in j + 1 until cubesLesser.size) {
            if (cubesLesser[j] + cubesLesser[k] == i.toLong()) {
                // Ok we have one way to write i as the sum of two cubes. Now be sure there is another way
                for(l in cubesLesser.indices) {
                    for(m in l + 1 until cubesLesser.size) {
                        if(cubesLesser[l] + cubesLesser[m] == i.toLong() && l != j && l != k && m != j && m != k) {
                            return i
                        }
                    }
                }
            }
        }
    }
    return -1
}

fun afficheTaxi(n: Int) {
    val cubes = createCubes(200)
    var nCount = 0

    // Test all numbers from 1 to 100000000 and check if they are a taxi number
    for(i in 1L..100000000L) {
        // Take the cubes lesser than i
        val cubesLesser = mutableListOf<Long>()
        for (cube in cubes) {
            if (cube < i) {
                cubesLesser.add(cube)
            }
        }
        if(findAndPrintTaxi(i, cubesLesser)) {
            nCount++
            if(nCount >= n) {
                return
            }
        }
    }
}

fun taxi(n: Int): MutableList<Long> {
    val cubes = createCubes(200)
    var nCount = 0
    val found = mutableListOf<Long>()

    // Test all numbers from 1 to 100000000 and check if they are a taxi number
    for(i in 1L..100000000L) {
        // Take the cubes lesser than i
        val cubesLesser = mutableListOf<Long>()
        for (cube in cubes) {
            if (cube < i) {
                cubesLesser.add(cube)
            }
        }
        val tempVal = findTaxi(i, cubesLesser)
        if(tempVal > 0) {
            found.add(tempVal)
            nCount++
            if(nCount >= n) {
                return found
            }
        }
    }
    return found
}

fun main(args: Array<String>) {
    afficheTaxi(5)
    println(taxi(20))
}
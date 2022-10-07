fun compareIntegers(a: Int?, b: Int?): Int? {
    // Comparez les entiers a et b
    // Si a ou b est null, retournez la valeur null
    // Sinon, retournez le plus grand des deux

    return if (a == null || b == null) {
        null
    } else {
        if (a > b) a else b
    }
}

fun countNullsInList(list: List<Int?>): Int {
    // Comptez le nombre d'éléments null dans la liste
    // Retournez le nombre d'éléments null

    var count = 0
    for (i in list) {
        if (i == null) {
            count++
        }
    }
    return count
}
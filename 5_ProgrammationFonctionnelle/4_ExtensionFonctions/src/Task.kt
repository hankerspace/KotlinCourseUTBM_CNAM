// Créez une extension "swap" de la classe MutableList<Int> qui échange les valeurs des deux éléments d'index donnés en paramètres.
// Vous pouvez supposer que les index sont valides.

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun main() {
    val list = mutableListOf(1, 2, 3)
    list.swap(0, 2) // 'swap()' changes the list as well
    println(list)
}
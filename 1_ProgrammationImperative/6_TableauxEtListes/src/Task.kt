import java.util.*

fun mergeTwoLists(list1: List<Int>, list2: List<Int>): List<Int> {
    // Retourner une liste contenant les éléments de list1 et list2 intercalés dans l'ordre
    // Exemple: mergeTwoLists(listOf(1, 2, 3), listOf(4, 5, 6)) donnera 1, 4, 2, 5, 3, 6
    // Si une liste est plus longue que l'autre, les éléments restants seront ajoutés à la fin

    val result = mutableListOf<Int>()
    var i = 0
    while (i < list1.size && i < list2.size) {
        result.add(list1[i])
        result.add(list2[i])
        i++
    }
    while (i < list1.size) {
        result.add(list1[i])
        i++
    }
    while (i < list2.size) {
        result.add(list2[i])
        i++
    }
    return  result
}

fun twoDimensionalList(list: List<Int>): List<List<Int>> {
    // Retourner une liste de deux listes contenant chacune les éléments pairs et impairs de list
    // Exemple: twoDimensionalList(listOf(1, 2, 3, 4, 5, 6)) donnera [[2, 4, 6], [1, 3, 5]]

    val result = mutableListOf<List<Int>>()
    val even = mutableListOf<Int>()
    val odd = mutableListOf<Int>()
    for (i in list) {
        if (i % 2 == 0) {
            even.add(i)
        } else {
            odd.add(i)
        }
    }
    result.add(even)
    result.add(odd)
    return result
}

fun shuffleSentence(sentence: String): String {
    // Retourner une phrase contenant les mêmes mots que sentence mais dans un ordre aléatoire
    // Exemple: shuffleSentence("Hello world") donnera "world Hello" ou "Hello world" ou "world Hello" ou ...
    // Exemple: shuffleSentence("Hello world, how are you?") donnera "Hello, world how you? are" ou "world, Hello how are you?" ou ...

    // La fonction split(" ") sur une string permet de découper une chaîne de caractères en une liste de mots
    // La fonction joinToString(" ") sur une liste de mots permet de les réassembler en une chaîne de caractères
    // Pour générer un nombre aléatoire, utiliser la fonction Random().nextInt(tailleMax)

    // Attention, les jeux de test vérifieront plusieurs fois que la fonction retourne bien un résultat différent à chaque fois

    val words = sentence.split(" ").toMutableList()
    val result = mutableListOf<String>()

    while (words.isNotEmpty()) {
        val index = Random().nextInt(words.size)
        result.add(words[index])
        words.removeAt(index)
    }
    return result.joinToString(" ")
}
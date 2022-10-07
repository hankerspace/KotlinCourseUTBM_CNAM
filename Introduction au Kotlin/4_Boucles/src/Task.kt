fun createStringWithLoop(n: Int): String {
    //Retourne une String contenant n fois le caractère 'a'
    var result = ""
    for (i in 1..n) {
        result += "a"
    }
    return result
}

fun createStringWithLoop2(n: Int): String {
    //Retourne une String contenant les nombres de 0 à n séparés par des virgules
    //Attention, la dernière virgule ne doit pas être affichée
    var result = ""
    for (i in 0..n) {
        result += "$i,"
    }
    return result.dropLast(1)
}

fun createMultiplicationTable(n: Int): String {
    //Retourne une String contenant une table de multiplication de 1 à n
    //Chaque ligne doit être séparée par un retour à la ligne (\n). Le dernier retour à la ligne ne doit pas être affiché.
    //Exemple pour n = 3:
    //1 x 1 = 1
    //1 x 2 = 2
    //1 x 3 = 3
    //2 x 1 = 2
    //2 x 2 = 4
    //2 x 3 = 6
    //3 x 1 = 3
    //3 x 2 = 6
    //3 x 3 = 9
    var result = ""
    for (i in 1..n) {
        for (j in 1..n) {
            result += "$i x $j = ${i * j}\n"
        }
    }
    return result
}

fun createBeautifulMultiplicationTable(n: Int) : String {
    //Retourne une String contenant une jolie table de multiplication du nombre n
    //La table de multiplication doit être présentée dans un tableau type Markdown (voir exemple)

    //
    //Exemple pour n = 3:
    //
    //| Opération | Résultat |
    //|-----------|----------|
    //| 1 x 3     | 3        |
    //| 2 x 3     | 6        |
    //| 3 x 3     | 9        |
    //|-----------|----------|

    var result = "| Opération | Résultat |\n|-----------|----------|\n"
    for (i in 1..n) {
        result += "| $i x $n | ${i * n} |\n"
    }
    result += "|-----------|----------|"
    return result
}

fun parseArrayOfStrings(array: Array<String>): String {
    //Retourne une String contenant les éléments du tableau array séparés par des virgules
    //Attention, la dernière virgule ne doit pas être affichée
    var result = ""
    for (i in array) {
        result += "$i,"
    }
    return result.dropLast(1)
}

fun pascalTriangle(n: Int): String {
    //Retourne une String contenant le triangle de Pascal jusqu'à la ligne n
    //Chaque ligne doit être séparée par un retour à la ligne (\n). Le dernier retour à la ligne ne doit pas être affiché.
    //Pour rappel, le triangle de Pascal est un triangle de nombres entiers qui est symétrique par rapport à sa diagonale.
    //Il est construit de la manière suivante: la première et la dernière colonne sont remplis de 1, et chaque nombre est la somme des deux nombres au-dessus de lui.
    //Exemple pour n = 3:
    //1
    //1 1
    //1 2 1
    //Exemple pour n = 10:
    //1
    //1 1
    //1 2 1
    //1 3 3 1
    //1 4 6 4 1
    //1 5 10 10 5 1
    //1 6 15 20 15 6 1
    //1 7 21 35 35 21 7 1
    //1 8 28 56 70 56 28 8 1
    //1 9 36 84 126 126 84 36 9 1
    var result = ""

    for (i in 0..n) {
        var line = 1
        for (j in 0..i) {
            result += "$line "
            line = line * (i - j) / (j + 1)
        }
        result += "\n"
    }
    return result.dropLast(1)
}

fun translateIntoRobbersLanguage(sentence: String): String {
    //Retourne une String contenant la traduction de la phrase sentence en langage de voleur
    //Le langage de voleur est un langage où chaque lettre est remplacée par la lettre suivante dans l'alphabet.
    //Exemple: "Hello" devient "Ifmmp"
    //Attention, il faut prendre en compte les majuscules et les minuscules
    //Exemple: "Hello World" devient "Ifmmp Xpsme"
    //Si la lettre est un z, elle doit être remplacée par un a.
    //Les chiffres et autres caractères ne sont pas traduits
    //Exemple: "Bonjour55" devient "Cpokpvs55"
    var result = ""
    for (i in sentence) {
        if (i in 'a'..'z' || i in 'A'..'Z') {
            if (i == 'z') {
                result += 'a'
            } else if (i == 'Z') {
                result += 'A'
            } else if (i in 'a'..'y' || i in 'A'..'Y') {
                result += i + 1
            } else {
                result += i
            }
        } else {
            result += i
        }
    }
    return result
}


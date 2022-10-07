fun interativePgcd(a: Long, b: Long): Long {
    //Retourne le PGCD de a et b
    //Pour rappel, le PGCD de a et b est le plus grand entier qui divise a ET b
    //Exemple: PGCD(12, 18) = 6
    //Exemple: PGCD(12, 17) = 1
    //L'algorithme d'Euclide permet de calculer le PGCD de a et b
    //Il consiste à répéter les étapes suivantes:
    // 1. Si a = b, alors le PGCD est a
    // 2. Si a > b, alors a = a - b
    // 3. Si a < b, alors b = b - a
    // 4. Retour à l'étape 1
    //Cette méthode est itérative

    var a = a
    var b = b
    while (a != b) {
        if (a > b) {
            a -= b
        } else {
            b -= a
        }
    }
    return a
}

fun recursivePgcd(a: Long, b: Long): Long {
    //Retourne le PGCD de a et b
    //Pour rappel, le PGCD de a et b est le plus grand entier qui divise a ET b
    //Exemple: PGCD(12, 18) = 6
    //Exemple: PGCD(12, 17) = 1
    //Nous allons utiliser la récurivité pour calculer le PGCD de a et b
    //Il faut donc définir une condition de sortie de la récursion

    return if (a == b) {
        a
    } else if (a > b) {
        recursivePgcd(a - b, b)
    } else {
        recursivePgcd(a, b - a)
    }
}


// Ecrire les fonctions permettant de chiffrer et de déchiffrer un message

fun encryptText(text: String, key: String) : String {
    // Ecrire une fonction qui chiffre un texte en utilisant une clé.
    // Vous pouvez choisir la méthode de chiffrement que vous le souhaitez, vous pouvez même en inventer une
    // La seule condition est que le déchiffrement doit être possible, vous devez écrire la fonction decryptText correpondante.
    // La fonction doit retourner le texte chiffré, il doit être obligatoirement différent de text.

    var encryptedText = ""
    for (i in text.indices) {
        encryptedText += (text[i] + key[i % key.length].toChar().digitToInt()).toChar()
    }
    return encryptedText
}

fun decryptText(text: String, key: String) : String {
    // Ecrire une fonction qui déchiffre un texte chiffré avec la fonction encryptText
    // La fonction doit retourner le texte déchiffré, il doit être obligatoirement différent de text.

    var decryptedText = ""
    for (i in text.indices) {
        decryptedText += (text[i] - key[i % key.length].toChar().digitToInt()).toChar()
    }
    return decryptedText
}
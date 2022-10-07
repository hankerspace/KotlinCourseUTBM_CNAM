fun compareBooleans(a: Boolean, b: Boolean) :Boolean {
    //Comparez les deux booléens. Retournez vrai si les deux booléens sont faux, faux sinon.
    return !a && !b
}

fun compareIntegers(a: Int, b: Int) :Int {
    //Comparez les deux entiers a et b et affichez le plus grand d'entre eux.
    //Si les deux entiers sont égaux, retournez la valeur 42.
    return if (a > b) {
        a
    } else if (a < b) {
        b
    } else {
        42
    }
}

fun compareDouble(a: Double, b: Double) :Double {
    //Comparez les deux nombres à virgule flottante. Si l'un ou l'autre dépasse 100, retournez la valeur 42.
    //Sinon, retournez la valeur la plus petite.
    return if (a > 100 || b > 100) {
        42.0
    } else if (a < b) {
        a
    } else {
        b
    }
}

fun compareStrings(a: String, b: String) :String {
    //Comparez les deux chaînes de caractères. Si elles sont égales, retournez la valeur "Les deux Strings sont identiques".
    //Si les deux chaînes sont de même taille et différentes, retournez la valeur "Les deux Strings sont de même taille".
    //Si la première est plus longue que la seconde, retournez la valeur du paramètre a, suivi du message 'est plus longue que' suivi de la chaine b.
    //Sinon, retournez la valeur du paramètre b, suivi du message 'est plus longue que' suivi de la chaine a.
    //Exemple : compareStrings("Hello", "Toto") retourne "Hello est plus longue que Toto"
    return if (a == b) {
        "Les deux Strings sont identiques"
    } else if(a.length == b.length) {
        "Les deux Strings sont de même taille"
    } else if (a.length > b.length) {
        "$a est plus longue que $b"
    } else {
        "$b est plus longue que $a"
    }
}

fun multipleCases(a: Int): String {
    //Comparez la valeur de a. Si elle est égale à 1, affichez "a vaut un".
    //Si elle est égale à 2, retournez "a vaut deux".
    //Si elle est égale à 3, retournez "a vaut trois".
    //Sinon retournez "a vaut " suivi de la valeur de a.
    return when (a) {
        1 -> "a vaut un"
        2 -> "a vaut deux"
        3 -> "a vaut trois"
        else -> "a vaut $a"
    }
}
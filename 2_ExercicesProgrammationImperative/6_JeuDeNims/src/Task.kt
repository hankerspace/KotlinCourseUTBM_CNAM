fun main() {
    var tokens = 12
    while (true) {
        println("Il reste $tokens bâtons")
        print("  Combien de bâtons? 1, 2 ou 3? ")
        val t = readLine()!!.toIntOrNull()
        if (t == null || t < 1 || t > 3) {
            println("\nDoit être un nombre entre 1 et 3... Réessayez.\n")
        } else {
            val ct = 4 - t
            val s = if (ct > 1) "s" else ""
            println("  L'ordinateur prend $ct bâton$s\n")
            tokens -= 4
        }
        if (tokens == 0) {
            println("Il ne reste plus de bâtons. L'ordinateur a gagné.")
            return
        }
    }
}


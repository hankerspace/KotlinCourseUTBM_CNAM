// Créez ici la classe Personne.
// Cette classe a un constructeur prenant en paramètre un nom, un prénom et un âge.
// Créez ensuite la propriété nomComplet qui retourne le nom et le prénom de la personne concaténés (Dupont Jean).
// Créez ensuite la méthode estMajeur qui retourne true si la personne est majeure, false sinon.
// La classe personne est ensuite utilisée dans les fonctions de test. Si vous avez bien implémenté la classe, les tests devraient passer.
class Personne(
    private val nom: String,
    private val prenom: String,
    private val age: Int
) {
    val nomComplet: String
        get() = "$nom $prenom"

    fun estMajeur(): Boolean {
        return age >= 18
    }
}

fun createPersonnesAndTestNomComplet(): List<String> {
    val personnes = mutableListOf<Personne>()
    personnes.add(Personne("Doe", "John", 42))
    personnes.add(Personne("Doe", "Jane", 39))
    personnes.add(Personne("Doe", "Jack", 13))
    personnes.add(Personne("Doe", "Jill", 11))

    val result = mutableListOf<String>()
    for (personne in personnes) {
        result.add(personne.nomComplet)
    }

    return result
}

fun createPersonnesAndTestEstMajeur(): List<Boolean> {
    val personnes = mutableListOf<Personne>()
    personnes.add(Personne("Doe", "John", 42))
    personnes.add(Personne("Doe", "Jane", 39))
    personnes.add(Personne("Doe", "Jack", 13))
    personnes.add(Personne("Doe", "Jill", 11))

    val result = mutableListOf<Boolean>()
    for (personne in personnes) {
        result.add(personne.estMajeur())
    }

    return result
}
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.File
import kotlin.math.round

@Serializable
data class Parrainage(
    val civilite: String,
    val nom: String,
    val prenom: String,
    val mandat: String,
    val circonscription: String,
    val departement: String,
    val candidat: String,
    val datePublication: String) {
    // Ajoutez ici les méthodes ou propriétés nécessaires

}

fun main() {
    val parrainages = Json.decodeFromString<List<Parrainage>>(File("6_ExercicesProgrammationFonctionnelle/0_Parrainages/parrainagestotal.json").readText(Charsets.UTF_8))

    // Ajoutez ici votre code pour tester vos fonctions et afficher les résultats attendus
    // Exercice 1
    println("--- EXERCICE 1 ---")
    println("Parrainages par candidat :")
    parrainages.parrainageCountByCandidat().forEach { println("${it.key} : ${it.value}") }
    println("\n\n")

    // Exercice 2
    println("--- EXERCICE 2 ---")
    println("Statistiques du département de la Meuse :")
    parrainages.statisticsByDepartment("Meuse").forEach { println("${it.key} : ${String.format("%.2f", it.value * 100)}%") }
    println("\n\n")

    // Exercice 3
    println("--- EXERCICE 3 ---")
    println("Statistiques du candidat MACRON Emmanuel :")
    parrainages.statisticsByCandidat("MACRON Emmanuel").forEach { println("${it.key} : ${String.format("%.2f", it.value * 100)}%") }
    println("\n\n")
}

/**
 * Exercice 1
 * Retourne un tableau de parrainages par candidat
 */
fun List<Parrainage>.parrainageCountByCandidat(departement: String? = null): Map<String, Int> {
    val countsByCandidat = mutableMapOf<String, Int>()
    val parrainages = if (departement != null) this.filter { it.departement == departement } else this
    for (parrainage in parrainages) {
        val count = countsByCandidat[parrainage.candidat] ?: 0
        countsByCandidat[parrainage.candidat] = count + 1
    }

    // Sort by count
    return countsByCandidat.toSortedMap(
        compareByDescending { countsByCandidat[it] }
    )
}

/**
 * Exercice 2
 * Retourne les statistiques par département
 */
fun List<Parrainage>.statisticsByDepartment(departement: String): Map<String, Double> {
    val countsByCandidatInThisDepartement = this.parrainageCountByCandidat(departement)
    val totalCount = countsByCandidatInThisDepartement.values.sum()
    return countsByCandidatInThisDepartement.mapValues { it.value.toDouble() / totalCount }
}

/**
 * Exercice 3
 * Retourne les statistiques par candidat
 */
fun List<Parrainage>.statisticsByCandidat(candidat: String): Map<String, Double> {
    val countsByDepartement = mutableMapOf<String, Int>()
    for (parrainage in this.filter { it.candidat == candidat }) {
        val count = countsByDepartement[parrainage.departement] ?: 0
        countsByDepartement[parrainage.departement] = count + 1
    }
    val totalCount = countsByDepartement.values.sum()

    return countsByDepartement.mapValues { it.value.toDouble() / totalCount }
}
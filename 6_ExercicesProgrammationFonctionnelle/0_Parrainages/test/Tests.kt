import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream
import kotlin.math.roundToInt

class Test {
    @Test fun testSolution() {
        val parrainages = Json.decodeFromString<List<Parrainage>>(File("parrainagestotal.json").readText(Charsets.UTF_8))
        val parrainageCountByCandidat = parrainages.parrainageCountByCandidat()

        Assert.assertTrue("Vérification de l'exercice 1",
            parrainageCountByCandidat["MACRON Emmanuel"] == 2098 &&
            parrainageCountByCandidat["LE PEN Marine"] == 622 &&
            parrainageCountByCandidat["ASSELINEAU François"] == 293
            )

        Assert.assertTrue("Vérification de l'exercice 2",
            (parrainages.statisticsByDepartment("Meuse")["ARTHAUD Nathalie"]!! * 100.0).roundToInt() == 31 &&
            (parrainages.statisticsByDepartment("Meuse")["LE PEN Marine"]!! * 100.0).roundToInt() == 9 &&
            (parrainages.statisticsByDepartment("Meuse")["MACRON Emmanuel"]!! * 100.0).roundToInt() == 5
            )

        Assert.assertTrue("Vérification de l'exercice 3",
            (parrainages.statisticsByCandidat("MACRON Emmanuel")["Meuse"]!! * 1000.0).roundToInt() == 3 &&
            (parrainages.statisticsByCandidat("MACRON Emmanuel")["Moselle"]!! * 1000.0).roundToInt() == 13 &&
            (parrainages.statisticsByCandidat("MACRON Emmanuel")["Bas-Rhin"]!! * 1000.0).roundToInt() == 14
            )

    }
}


/**
 * Exercice 1
 * Retourne un tableau de parrainages par candidat
 */
fun List<Parrainage>.myParrainageCountByCandidat(departement: String? = null): Map<String, Int> {
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
fun List<Parrainage>.myStatisticsByDepartment(departement: String): Map<String, Double> {
    val countsByCandidatInThisDepartement = this.parrainageCountByCandidat(departement)
    val totalCount = countsByCandidatInThisDepartement.values.sum()
    return countsByCandidatInThisDepartement.mapValues { it.value.toDouble() / totalCount }
}

/**
 * Exercice 3
 * Retourne les statistiques par candidat
 */
fun List<Parrainage>.myStatisticsByCandidat(candidat: String): Map<String, Double> {
    val countsByDepartement = mutableMapOf<String, Int>()
    for (parrainage in this.filter { it.candidat == candidat }) {
        val count = countsByDepartement[parrainage.departement] ?: 0
        countsByDepartement[parrainage.departement] = count + 1
    }
    val totalCount = countsByDepartement.values.sum()

    return countsByDepartement.mapValues { it.value.toDouble() / totalCount }
}
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.File

@Serializable
data class Parrainage(
    val civilite: String,
    val nom: String,
    val prenom: String,
    val mandat: String,
    val circonscription: String,
    val departement: String,
    val candidat: String,
    val datePublication: String
    )

fun main() {
    val readText = File("parrainagestotal.json").readText(Charsets.UTF_8)
    val data = Json.decodeFromString<Parrainage>(readText)
    println(data)
}
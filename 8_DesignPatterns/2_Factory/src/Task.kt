// Créez les classes demandées ici ainsi que la Factory
interface Parser {
    fun parse(): String
}

class JsonParser : Parser {
    override fun parse(): String = "Parsing JSON"
}

class XmlParser : Parser {
    override fun parse(): String = "Parsing XML"
}

class ParserFactory {
    fun getParser(filename: String): Parser {
       return when (filename.substringAfterLast('.')) {
            "xml" -> XmlParser()
            "json" -> JsonParser()
            else -> throw Exception("I don't know how to deal with $filename.")
        }
    }
}

fun String.getParser(): Parser = ParserFactory().getParser(this)

fun main(args: Array<String>) {
    // Ajoutez votre code de test ici
    val parser = "data.json".getParser()
    println(parser.parse())

    val parser2 = "data.xml".getParser()
    println(parser2.parse())

    val parser3 = "data.txt".getParser()
    println(parser3.parse())
}
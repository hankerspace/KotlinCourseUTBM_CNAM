
val countries = mapOf(
        "France" to "🇫🇷",
        "Germany" to "🇩🇪",
        "Spain" to "🇪🇸",
        "Italy" to "🇮🇹",
        "Portugal" to "🇵🇹",
        "Belgium" to "🇧🇪",
        "Netherlands" to "🇳🇱",
        "Luxembourg" to "🇱🇺",
        "Switzerland" to "🇨🇭",
        "Austria" to "🇦🇹",
        "United Kingdom" to "🇬🇧",
        "Ireland" to "🇮🇪",
        "Denmark" to "🇩🇰",
        "Sweden" to "🇸🇪",
        "Norway" to "🇳🇴",
        "Finland" to "🇫🇮",
        "Estonia" to "🇪🇪",
        "Latvia" to "🇱🇻",
        "Lithuania" to "🇱🇹",
        "Poland" to "🇵🇱",
        "Czech Republic" to "🇨🇿",
        "Slovakia" to "🇸🇰",
        "Hungary" to "🇭🇺",
        "Slovenia" to "🇸🇮",
        "Croatia" to "🇭🇷",
        "Bosnia and Herzegovina" to "🇧🇦",
        "Serbia" to "🇷🇸",
        "Montenegro" to "🇲🇪",
        "Albania" to "🇦🇱",
        "Greece" to "🇬🇷",
        "Bulgaria" to "🇧🇬",
        "Romania" to "🇷🇴",
        "Moldova" to "🇲🇩",
        "Ukraine" to "🇺🇦"
    )

fun flag(country: String): String {
    return countries[country] ?: "🏳️"
}

fun country(flag: String): String {
    return countries.filterValues { it == flag }.keys.first()
}

fun allFlags(): List<String> {
    return countries.values.toList()
}

fun main() {
    println(flag("France"))
    println(flag("Germany"))
    println(flag("Spain"))

    println(country("🇫🇷"))
    println(country("🇩🇪"))
    println(country("🇪🇸"))

    println(allFlags())
}
fun isEmail(email: String): Boolean {
    return email.matches(Regex("""[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}"""))
}

fun isMobilePhoneNumber(phone: String): Boolean {
    return phone.matches(Regex("""0[67][0-9]{8}"""))
}

fun isIBAN(iban: String): Boolean {
    return iban.matches(Regex("""[A-Z]{2}\d{2}[A-Z0-9]{4}\d{7}([A-Z0-9]?){0,16}"""))
}

fun isDate(date: String): Boolean {
    return date.matches(Regex("""\d{2}/\d{2}/\d{4}"""))
}

fun isTime(time: String): Boolean {
    return time.matches(Regex("""\d{2}:\d{2}"""))
}

fun main(args: Array<String>) {
    println(isEmail("toto@toto.fr"))
    println(isMobilePhoneNumber("0612345678"))
    println(isIBAN("FR7630006000011234567890189"))
    println(isDate("01/01/2018"))
    println(isTime("12:00"))
}

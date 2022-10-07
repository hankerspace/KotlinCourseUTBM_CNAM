fun chiffreRomain(nombre: Int): String {
    var result = ""
    var nombreTemp = nombre
    while (nombreTemp > 0) {
        if (nombreTemp >= 1000) {
            result += "M"
            nombreTemp -= 1000
        } else if (nombreTemp >= 900) {
            result += "CM"
            nombreTemp -= 900
        } else if (nombreTemp >= 500) {
            result += "D"
            nombreTemp -= 500
        } else if (nombreTemp >= 400) {
            result += "CD"
            nombreTemp -= 400
        } else if (nombreTemp >= 100) {
            result += "C"
            nombreTemp -= 100
        } else if (nombreTemp >= 90) {
            result += "XC"
            nombreTemp -= 90
        } else if (nombreTemp >= 50) {
            result += "L"
            nombreTemp -= 50
        } else if (nombreTemp >= 40) {
            result += "XL"
            nombreTemp -= 40
        } else if (nombreTemp >= 10) {
            result += "X"
            nombreTemp -= 10
        } else if (nombreTemp >= 9) {
            result += "IX"
            nombreTemp -= 9
        } else if (nombreTemp >= 5) {
            result += "V"
            nombreTemp -= 5
        } else if (nombreTemp >= 4) {
            result += "IV"
            nombreTemp -= 4
        } else if (nombreTemp >= 1) {
            result += "I"
            nombreTemp -= 1
        }
    }
    return result
}
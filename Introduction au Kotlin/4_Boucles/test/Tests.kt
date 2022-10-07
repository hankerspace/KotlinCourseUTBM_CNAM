import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Le test de la fonction createStringWithLoop avec le paramètre 5", createStringWithLoop(5) == "aaaaa")
        Assert.assertTrue("Le test de la fonction createStringWithLoop avec le paramètre 0", createStringWithLoop(0) == "")
        Assert.assertTrue("Le test de la fonction createStringWithLoop avec le paramètre 1", createStringWithLoop(1) == "a")

        Assert.assertTrue("Le test de la fonction createStringWithLoop2 avec le paramètre 5", createStringWithLoop2(5) == "0,1,2,3,4,5")
        Assert.assertTrue("Le test de la fonction createStringWithLoop2 avec le paramètre 0", createStringWithLoop2(0) == "0")
        Assert.assertTrue("Le test de la fonction createStringWithLoop2 avec le paramètre 1", createStringWithLoop2(1) == "0,1")

        val createMultiplicationTable = createMultiplicationTable(5)
        Assert.assertTrue("Le test de la fonction createMultiplicationTable avec le paramètre 5",
            "1 x 1 = 1" in createMultiplicationTable &&
            "5 x 5 = 25" in createMultiplicationTable &&
            "3 x 3 = 9" in createMultiplicationTable)

        val createBeautifulMultiplicationTable = createBeautifulMultiplicationTable(5)
        Assert.assertTrue("Le test de la fonction createBeautifulMultiplicationTable avec le paramètre 5",
            "| Opération | Résultat |" in createBeautifulMultiplicationTable &&
                    "|-----------|----------|" in createBeautifulMultiplicationTable &&
                    "1 x 5" in createBeautifulMultiplicationTable &&
                    "5 x 5" in createBeautifulMultiplicationTable &&
                    "3 x 5" in createBeautifulMultiplicationTable)

        Assert.assertTrue("Le test de la fonction parseArrayOfStrings avec le paramètre arrayOf(\"1\", \"2\", \"3\")", parseArrayOfStrings(arrayOf("1", "2", "3")) == "1,2,3")
        Assert.assertTrue("Le test de la fonction parseArrayOfStrings avec le paramètre arrayOf(\"1\", \"2\", \"3\", \"4\", \"5\")", parseArrayOfStrings(arrayOf("1", "2", "3", "4", "5")) == "1,2,3,4,5")
        Assert.assertTrue("Le test de la fonction parseArrayOfStrings avec le paramètre arrayOf(\"test\", \"test2\", \"test3\")", parseArrayOfStrings(arrayOf("test", "test2", "test3")) == "test,test2,test3")

        val pascal = pascalTriangle(5)
        Assert.assertTrue("Le test de la fonction pascalTriangle avec le paramètre 5",
            "1" in pascal &&
                    "1 1" in pascal &&
                    "1 2 1" in pascal &&
                    "1 3 3 1" in pascal &&
                    "1 4 6 4 1" in pascal)

        val pascal2 = pascalTriangle(25)
        Assert.assertTrue("Le test de la fonction pascalTriangle avec le paramètre 50",
            "1" in pascal2 &&
                    "1 1" in pascal2 &&
                    "1 2 1" in pascal2 &&
                    "1 3 3 1" in pascal2 &&
                    "1 25 300 2300 12650 53130 177100 480700 1081575 2042975 3268760 4457400 5200300 5200300 4457400 3268760 2042975 1081575 480700 177100 53130 12650 2300 300 25 1" in pascal2)

        Assert.assertTrue("Le test de la fonction translateIntoRobbersLanguage avec le paramètre \"Bonjour\"", translateIntoRobbersLanguage("Bonjour") == "Cpokpvs")
        Assert.assertTrue("Le test de la fonction translateIntoRobbersLanguage avec le paramètre \"Bonjour les zamis\"", translateIntoRobbersLanguage("Bonjour les zamis") == "Cpokpvs mft abnjt")
        Assert.assertTrue("Le test de la fonction translateIntoRobbersLanguage avec le paramètre \"Bonjour les amis, comment allez vous ? Vous venez le 10 à 10 heures ?\"", translateIntoRobbersLanguage("Bonjour les amis, comment allez vous ? Vous venez le 10 à 10 heures ?") == "Cpokpvs mft bnjt, dpnnfou bmmfa wpvt ? Wpvt wfofa mf 10 à 10 ifvsft ?")

    }
}
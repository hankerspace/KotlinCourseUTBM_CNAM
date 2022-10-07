import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Le test de la fonction chiffreRomain avec le paramètre 44", chiffreRomain(44) == "XLIV")
        Assert.assertTrue("Le test de la fonction chiffreRomain avec le paramètre 1999", chiffreRomain(1999) == "MCMXCIX")
        Assert.assertTrue("Le test de la fonction chiffreRomain avec le paramètre 2019", chiffreRomain(2019) == "MMXIX")
        Assert.assertTrue("Le test de la fonction chiffreRomain avec le paramètre 2020", chiffreRomain(2020) == "MMXX")
        Assert.assertTrue("Le test de la fonction chiffreRomain avec le paramètre 2021", chiffreRomain(2021) == "MMXXI")
        Assert.assertTrue("Le test de la fonction chiffreRomain avec le paramètre 2022", chiffreRomain(2022) == "MMXXII")
        Assert.assertTrue("Le test de la fonction chiffreRomain avec le paramètre 2023", chiffreRomain(2023) == "MMXXIII")
        Assert.assertTrue("Le test de la fonction chiffreRomain avec le paramètre 3877", chiffreRomain(3877) == "MMMDCCCLXXVII")
        Assert.assertTrue("Le test de la fonction chiffreRomain avec le paramètre 3999", chiffreRomain(3999) == "MMMCMXCIX")
    }
}
import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Test de la fonction isEmail avec l'email jean@michel.fr", isEmail("jean@michel.fr"))
        Assert.assertTrue("Test de la fonction isMobilePhoneNumber avec le numéro 0612345678", isMobilePhoneNumber("0612345678"))
        Assert.assertTrue("Test de la fonction isIBAN avec l'IBAN FR7630006000011234567890189", isIBAN("FR7630006000011234567890189"))
        Assert.assertTrue("Test de la fonction isDate avec la date 01/01/2018", isDate("01/01/2018"))
        Assert.assertTrue("Test de la fonction isTime avec l'heure 12:00", isTime("12:00"))

        Assert.assertFalse("Test de la fonction isEmail avec l'email jeanmichel.fr", isEmail("jeanmichel.fr"))
        Assert.assertFalse("Test de la fonction isMobilePhoneNumber avec le numéro 061234567", isMobilePhoneNumber("061234567"))
        Assert.assertFalse("Test de la fonction isDate avec la date 01/01/201", isDate("01/01/201"))
        Assert.assertFalse("Test de la fonction isTime avec l'heure 12:0", isTime("12:0"))

        Assert.assertFalse("Test de la fonction isEmail avec l'email jean@michel", isEmail("jean@michel"))
        Assert.assertFalse("Test de la fonction isMobilePhoneNumber avec le numéro 06123456789", isMobilePhoneNumber("06123456789"))
        Assert.assertFalse("Test de la fonction isDate avec la date 01/01/20181", isDate("01/01/20181"))
        Assert.assertFalse("Test de la fonction isTime avec l'heure 12:001", isTime("12:001"))


    }
}
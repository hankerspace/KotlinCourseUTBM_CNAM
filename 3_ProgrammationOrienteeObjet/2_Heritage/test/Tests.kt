import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Test de la fonction testCar", testCar() is Car)

        Assert.assertTrue("Test de la fonction testGasolineCar", testGasolineCar() is GasolineCar)

        Assert.assertTrue("Test de la fonction testElectricCar", testElectricCar() is ElectricCar)

        Assert.assertTrue("Test de la fonction testHybridCar", testHybridCar() is HybridCar)

        Assert.assertTrue("Test de la fonction testHybridCar2", testHybridCar2() is HybridCar)

        Assert.assertTrue("Test de la fonction testAllCars", testAllCars().size == 5)
        
    }
}
import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        Assert.assertTrue("Test grass area zone name",
            (getGrassArea("Grass area") as Printable).retrieveZoneName() == "Grass area"
        )

        Assert.assertTrue("Test built area zone name",
            (getBuiltArea("Built area") as Printable).retrieveZoneName() == "Built area"
        )

        Assert.assertTrue("Test wet area zone name",
            (getWetArea("Wet area", 10.0) as Printable).retrieveZoneName() == "Wet area"
        )

        Assert.assertTrue("Test grass area water level by default",
            (getGrassArea("Grass area") as Printable).retrieveWaterLevel() == 0.0
        )

        Assert.assertTrue("Test built area water level by default",
            (getBuiltArea("Built area") as Printable).retrieveWaterLevel() == 0.0
        )

        Assert.assertTrue("Test wet area water level by default",
            (getWetArea("Wet area", 10.0) as Printable).retrieveWaterLevel() == 0.0
        )

        Assert.assertTrue("Test grass area water level after adding 10 water",
            ((getGrassArea("Grass area") as Waterable)
                .apply { addWater(10.0) } as Printable)
                .retrieveWaterLevel() == 5.0
        )

        Assert.assertTrue("Test built area water level after adding 10 water",
            ((getBuiltArea("Built area") as Waterable)
                .apply { addWater(10.0) } as Printable)
                .retrieveWaterLevel() == 10.0
        )

        Assert.assertTrue("Test wet area water level after adding 10 water (with capacity 10)",
            ((getWetArea("Wet area", 10.0) as Waterable)
                .apply { addWater(10.0) } as Printable)
                .retrieveWaterLevel() == 0.0
        )

        Assert.assertTrue("Test wet area water level after adding 10 water (with capacity 1)",
            ((getWetArea("Wet area", 1.0) as Waterable)
                .apply { addWater(10.0) } as Printable)
                .retrieveWaterLevel() == 9.0
        )


    }
}
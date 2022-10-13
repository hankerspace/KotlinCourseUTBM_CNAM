import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        val list = LinkedList<Int>()
        Assert.assertEquals(0, list.size())
        Assert.assertTrue(list.isEmpty())
        Assert.assertFalse(list.contains(1))
        Assert.assertNull(list.get(0))
        list.add(1)
        Assert.assertEquals(1, list.size())
        Assert.assertFalse(list.isEmpty())
        Assert.assertTrue(list.contains(1))
        Assert.assertEquals(1, list.get(0))
        list.add(2)
        Assert.assertEquals(2, list.size())
        Assert.assertFalse(list.isEmpty())
        Assert.assertTrue(list.contains(1))
        Assert.assertTrue(list.contains(2))
    }
}
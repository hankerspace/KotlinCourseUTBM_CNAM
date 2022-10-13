import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {
        //Generate a dummy tree from Node
        val root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        root.left?.left = Node(4)
        root.left?.right = Node(5)
        //Test the sum of the tree


        Assert.assertTrue("Test sumTree", sumTree(root) == 15)
        //Test the max of the tree
        Assert.assertTrue("Test maxTree", maxTree(root) == 5)
        //Test the min of the tree
        Assert.assertTrue("Test minTree", minTree(root) == 1)
        //Test the height of the tree
        Assert.assertTrue("Test heightTree", heightTree(root) == 3)
        //Test the count of the tree
        Assert.assertTrue("Test countTree", countTree(root) == 5)
        //Test the count of the leaves
        Assert.assertTrue("Test countLeaves", countLeaves(root) == 3)

    }
}
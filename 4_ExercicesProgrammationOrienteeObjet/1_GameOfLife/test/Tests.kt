import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testSolution() {

        Assert.assertTrue("Test de la règle 'Une cellule vivante possédant deux ou trois voisines vivantes reste vivante, sinon elle meurt.'",
            computeFunction(listOf(Cell(0, 0)), 100, 100).isEmpty()
        )

        Assert.assertTrue("Test de la règle 'Une cellule vivante possédant deux ou trois voisines vivantes reste vivante, sinon elle meurt.'",
            computeFunction(listOf(Cell(0, 0), Cell(0, 1), Cell(0, 2)), 100, 100).any { it.x == 0 && it.y == 1 }
        )

        Assert.assertTrue("Test de la règle 'Une cellule morte possédant exactement trois voisines vivantes devient vivante.'",
            computeFunction(listOf(Cell(0, 0), Cell(0, 1), Cell(0, 2)), 100, 100).any { it.x == 1 && it.y == 1 }
        )

        Assert.assertTrue("Test de la règle 'Toutes les autres cellules restent mortes ou vivantes.'",
            computeFunction(listOf(Cell(0, 0), Cell(0, 1), Cell(0, 2)), 100, 100).none { it.x == 2 && it.y == 1 }
        )

        Assert.assertTrue("Test de la règle 'Toutes les autres cellules restent mortes ou vivantes.'",
            computeFunction(listOf(Cell(0, 0), Cell(0, 1), Cell(0, 2)), 100, 100).none { it.x == 1 && it.y == 0 }
        )

        Assert.assertTrue("Test de la règle 'Toutes les autres cellules restent mortes ou vivantes.'",
            computeFunction(listOf(Cell(0, 0), Cell(0, 1), Cell(0, 2)), 100, 100).none { it.x == 1 && it.y == 2 }
        )

        Assert.assertTrue("Test de la règle 'Toutes les autres cellules restent mortes ou vivantes.'",
            computeFunction(listOf(Cell(0, 0), Cell(0, 1), Cell(0, 2)), 100, 100).none { it.x == 2 && it.y == 0 }
        )

        Assert.assertTrue("Test de la règle 'Toutes les autres cellules restent mortes ou vivantes.'",
            computeFunction(listOf(Cell(0, 0), Cell(0, 1), Cell(0, 2)), 100, 100).none { it.x == 2 && it.y == 2 }
        )

        Assert.assertTrue("Test de la règle 'Les cellules hors du plateau sont considérées comme mortes.'",
            computeFunction(listOf(Cell(0, 0), Cell(0, 1), Cell(0, 2)), 100, 100).none { it.x == -1 && it.y == 1 }
        )

        Assert.assertTrue("Test de la règle 'Les cellules hors du plateau sont considérées comme mortes.'",
            computeFunction(listOf(Cell(0, 0), Cell(0, 1), Cell(0, 2)), 100, 100).none { it.x == 1 && it.y == -1 }
        )
    }
}
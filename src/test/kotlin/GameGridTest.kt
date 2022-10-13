import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GameGridTest {

    @Test
    fun createNewGameGrid() {
        val game = GameGrid(3, 3)
        val exp = arrayOf(arrayOf("-", "-", "-"), arrayOf("-", "-", "-"),arrayOf("-", "-", "-"))

        assertArrayEquals(exp, game.grid)
    }

    @Test
    fun placeMine() {
        val game = GameGrid(3, 3)
        val exp = arrayOf(arrayOf("-", "-", "-"), arrayOf("-", "-", "-"),arrayOf("-", "X", "-"))

        game.placeMine(2, 1)

        assertArrayEquals(exp, game.grid)
    }

    @Test
    fun gridToString() {
        val game = GameGrid(3, 2)
        val exp = " -  - \n -  - \n -  - \n"

        val res = game.gridToString()

        assertEquals(exp, res)
    }

    @Test
    fun computeMinesCount() {
        val game = GameGrid(4, 3)
        game.placeMine(1,1)
        game.placeMine(3,2)
        val exp = arrayOf(arrayOf("1", "1", "1"), arrayOf("1", "X", "1"),arrayOf("1", "2", "2"), arrayOf("0", "1", "X"))

        game.computeMinesCount()

        assertArrayEquals(exp, game.grid)
    }
}
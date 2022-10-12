import kotlin.math.max
import kotlin.math.min

typealias GridType = Array<Array<String>>

class GameGrid(private var rows: Int, private var cols: Int) {

    var grid: GridType = Array(rows) { Array(cols) { "-" } }

    fun placeMine(x: Int, y: Int, grid: GridType): GridType {
        grid[x][y] = "X"
        return grid
    }

    fun printGrid(grid: GridType) {
        println("\nGame Grid")
        grid.forEach { row ->
            row.forEach { cell -> print(" $cell ") }
            println()
        }
    }

    fun computeMinesCount(grid: GridType): GridType {
        var x = grid
        for (r in 0 until rows)
            for (c in 0 until cols)
                x = countCellMines(r, c)

        return x
    }

    private fun countCellMines(x: Int, y: Int): GridType {
        if (grid[x][y] == "X") return grid

        val rowStart = max(x - 1, 0)
        val rowFinish = min(x + 1, rows- 1)
        val colStart = max(y - 1, 0)
        val colFinish = min(y + 1, cols - 1)

        var ctr = 0
        for (curRow in rowStart..rowFinish) {
            for (curCol in colStart..colFinish) {
                if (grid[curRow][curCol] == "X") {
                    ctr++
                }
            }
        }
        grid[x][y] = "$ctr"
        return grid
    }
}
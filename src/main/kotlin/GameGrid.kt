import kotlin.math.max
import kotlin.math.min

typealias GridType = Array<Array<String>>

class GameGrid(private var rows: Int, private var cols: Int) {

    var grid: GridType = Array(rows) { Array(cols) { "-" } }

    fun placeMine(x: Int, y: Int) {
        grid[x][y] = "X"
    }

    fun printGrid() {
        println(gridToString())
    }

    fun gridToString(): String{
        var res = ""
        grid.forEach { row ->
            row.forEach { cell -> res += " $cell " }
            res += "\n"
        }
        return res
    }

    fun computeMinesCount() {
        for (r in 0 until rows)
            for (c in 0 until cols)
                countCellMines(r, c)
    }

    private fun countCellMines(x: Int, y: Int) {
        if (grid[x][y] != "X") {
            val rowStart = max(x - 1, 0)
            val rowFinish = min(x + 1, rows - 1)
            val colStart = max(y - 1, 0)
            val colFinish = min(y + 1, cols - 1)

            var minesCtr = 0
            for (curRow in rowStart..rowFinish) {
                for (curCol in colStart..colFinish) {
                    if (grid[curRow][curCol] == "X") {
                        minesCtr++
                    }
                }
            }
            grid[x][y] = "$minesCtr"
        }
    }
}
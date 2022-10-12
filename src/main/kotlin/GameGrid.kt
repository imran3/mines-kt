typealias GridType = Array<Array<String>>

class GameGrid(var rows: Int, var cols: Int) {

    var grid: GridType = arrayOf(arrayOf<String>())

    init {
        grid = Array(rows) { Array<String>(cols) { "-" } }
    }

    fun placeMine(x: Int, y: Int, grid: GridType): GridType {
        grid[x][y] = "X"
        return grid
    }

    fun printGrid(grid: GridType) {
        println("\nGame Grid")
        grid.forEach {
            it.forEach { print(" $it ") }
            println()
        }
    }

    fun computeMinesCount(grid: GridType): GridType {
        var x = grid
        for (r in 0..rows - 1)
            for (c in 0..cols - 1)
                x = countCellMines(r, c)

        return x
    }

    fun countCellMines(x: Int, y: Int): GridType {
        if (grid[x][y] == "X") return grid

        val rowStart = Math.max(x - 1, 0)
        val rowFinish = Math.min(x + 1, grid.size - 1)
        val colStart = Math.max(y - 1, 0)
        val colFinish = Math.min(y + 1, grid.size - 1)

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
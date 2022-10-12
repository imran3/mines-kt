

fun main() {
    println("hello")

    val game = GameGrid(5, 5);
    println(game.rows)


    game.printGrid(game.grid)
    game.placeMine(2, 0, game.grid)
    game.placeMine(2, 1, game.grid)
    game.placeMine(4, 4, game.grid)
    game.printGrid(game.grid)


    game.computeMinesCount(game.grid)

    game.printGrid(game.grid)
}

fun main() {
    val game = GameGrid(5, 5);
    game.printGrid()

    game.placeMine(2, 0 )
    game.placeMine(2, 1)
    game.placeMine(4, 4)
    game.printGrid()

    game.computeMinesCount()
    game.printGrid()
}

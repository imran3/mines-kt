# mines-kt
Challenge 13 - “Minesweeper” :bomb:

Given a grid of characters where each X represents a mine and each - represents empty space, the aim is to return a grid where each - is replaced by an integer indicating the number of mines adjacent to that spot (including diagonally).

Example:
```
minesweeper([
    "-", "-", "-", "-", "-",
    "-", "-", "-", "-", "-",
    "X", "X", "-", "-", "-",
    "-", "-", "-", "-", "-",
    "-", "-", "-", "-", "X", 
])
```
would return:
```
[
    "0", "0", "0", "0", "0",
    "2", "2", "1", "0", "0",
    "X", "X", "1", "0", "0",
    "2", "2", "1", "1", "1",
    "0", "0", "0", "1", "X", 
]`

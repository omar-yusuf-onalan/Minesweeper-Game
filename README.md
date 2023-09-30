# Minesweeper Game

This is a Minesweeper game played in the terminal.

## Gameplay Loop:
- The program starts by asking players the dimensions of the minefield they would like to clear.
- It creates two minefields:
    - `minefieldAlpha`: Tracks the game state.
    - `minefieldBeta`: Shown to players.
- The program enters a while loop, repeatedly prompting players for coordinates, then checking the game state via `minefieldAlpha` to determine the result.

## Methods:

### `MineSweeper()`
The constructor method `MineSweeper()` initializes all the variables and methods necessary for the creation of the game state.

### `run()`
This is the method where the gameplay loop takes place. A while loop connected to a boolean flag checks if the player has won or lost.

### `String[][] createMinefieldAlpha()`
Returns `minefieldAlpha` to `this.minefieldAlpha`. Utilizes `fillZero()` to prepare `minefieldAlpha` for `fillNumbers()`. Mines are placed at random coordinates, and after each placement, `fillNumbers()` is called. This loop continues until the desired number of mines is achieved.

### `fillZero(String[][] minefield)`
Prepares the minefield for `fillNumbers()`. Adjacent squares to mines are initialized to 0 to be correctly incremented later.

### `fillNumbers(String[][] array, int squareRow, int squareCol)`
Processes a minefield array, row coordinate, and column coordinate. Adjacent squares to a mine are incremented if they don't contain a mine. The `isValid()` method ensures array bounds are respected.

### `boolean isValid(int r, int c)`
Ensures the program doesn't access an out-of-bounds array index. Used in the `fillNumbers()` method.

### `String[][] createMinefieldBeta()`
Returns the created `minefieldBeta` after populating it with minus signs via `fillMinus()`.

### `fillMinus(String[][] minefield)`
Populates each square in the minefield with "-".

### `printMinefield(String[][] minefield)`
Prints out the provided minefield. Abstracted to a method due to frequent use throughout the program.

### `String[][] initialMinefieldView()`
For testing purposes, this method prints the locations of all mines. If a square does not contain a mine, it is printed as "-".

### `checkWinCondition()`
After each loop in `run()`, this method compares opened squares with the maximum possible number of open squares to determine if the player has won.

### `revealAllMines()`
Upon exiting the `run()` loop, all mines in the minefield are displayed to the player, regardless of the game's outcome.

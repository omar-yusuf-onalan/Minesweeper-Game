# Minesweeper Game

## Introduction
This is a simple implementation of the classic game Minesweeper in Java. The game is played in the console and follows the standard rules of Minesweeper.

## Game Overview
In Minesweeper, the player is presented with a grid of squares. Some of these squares contain mines, and the goal of the game is to uncover all the squares that do not contain mines without triggering any mines. If a square containing a mine is uncovered, the game ends.

## Setup
To play the game, you'll need Java installed on your system. Simply compile the provided Java files and run the `Main` class. The game will prompt you to input the size of the minefield (number of rows and columns) and then guide you through playing.

## Classes
1. **Main**: This class contains the main method to start the game. It creates an instance of the `MineSweeper` class and calls its `run()` method.
   
2. **MineSweeper**: This class represents the game logic. It handles user input, updates the minefield, and checks for win/loss conditions.
   
3. **Minefield**: This class represents the grid of blocks in which the game is played. It generates the minefield, places mines randomly, and calculates the number of adjacent mines for each non-mine block.
   
4. **Block**: This class represents each square in the minefield. It stores the position of the block, its value (mine or number of adjacent mines), and whether it is open (revealed) or closed.

## Game Flow
1. The game starts by asking the player to input the size of the minefield.
2. The minefield is generated, and mines are randomly placed.
3. The player takes turns to input coordinates to uncover blocks on the minefield.
4. If a block containing a mine is uncovered, the game ends in a loss.
5. If all non-mine blocks are uncovered, the game ends in a win.

## Playing the Game
- The player inputs the row and column coordinates of the block they want to uncover.
- The game reveals the value of the block.
- If the block contains a mine, the game ends.
- If the block is empty, adjacent blocks may also be automatically revealed.
- The game continues until the player either wins or loses.

## Win/Loss Conditions
- **Win**: All non-mine blocks are uncovered.
- **Loss**: The player uncovers a block containing a mine.

## Additional Notes
- The game uses a simple console interface for input/output.
- The minefield size and mine density can be adjusted by changing parameters in the code.
- The game does not feature a graphical user interface (GUI) and is played entirely in the console.

## Conclusion
This Minesweeper implementation provides a basic yet functional version of the classic game. It demonstrates fundamental concepts of Java programming, including object-oriented design, user input/output, and randomization. Players can enjoy the challenge of uncovering blocks strategically while avoiding mines in this console-based adaptation of Minesweeper.

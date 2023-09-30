import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class MineSweeper { // Form 5
    Scanner input = new Scanner(System.in);
    Random random = new Random();
    int row, col, numberOfMines, numberOfOpenSquares, maxNumberOfOpenSquares;
    boolean hasWon;

    String[][] minefieldAlpha;
    String[][] minefieldBeta;

    public MineSweeper() {
        // Form 7
        System.out.println("Enter the dimensions of the minefield");

        System.out.print("Enter row: ");
        this.row = input.nextInt();
        System.out.print("Enter column: ");
        this.col = input.nextInt();

        this.numberOfMines = (row * col) / 4;
        this.numberOfOpenSquares = 0;
        this.maxNumberOfOpenSquares = (row * col) - numberOfMines;
        this.hasWon = false;

        this.minefieldAlpha = createMinefieldAlpha();
        this.minefieldBeta = createMinefieldBeta();

        System.out.println("Placement of the mines");
        printMinefield(initialMinefieldView());
        System.out.println("=======================");
    }

    public void run() {
        while (!hasWon) {
            printMinefield(minefieldBeta); // Form 11

            boolean validInput;
            int r, c;

            do { // Form 9
                System.out.print("Enter row: ");
                r = input.nextInt();

                System.out.print("Enter column: ");
                c = input.nextInt();

                validInput = (0 <= r && r < this.row && 0 <= c && c < this.col);
                if (!validInput) { // Form 10
                    System.out.println("You inputted invalid values. Please enter valid values" +
                            "\nRow: 0-" + (this.row - 1) +"\nColumn: 0-" + (this.col - 1));
                }

            } while (!validInput);

            System.out.println("======================================");

            if (minefieldAlpha[r][c].equals("*")) { // Form 13
                minefieldBeta[r][c] = minefieldAlpha[r][c];
                revealAllMines();
                break;
            } else {
                minefieldBeta[r][c] = minefieldAlpha[r][c];
                this.numberOfOpenSquares++;
            }

            checkWinCondition(); // Form 14
        }

        printMinefield(minefieldBeta);
        System.out.println(hasWon ? "You win!" : "Game Over!"); // Form 15
    }

    // Form 6
    public String[][] createMinefieldAlpha() {
        String[][] minefieldAlpha = new String[row][col];
        fillZero(minefieldAlpha);

        int i = 0;
        while (i < this.numberOfMines) { // Form 8
            int rCoordinate = random.nextInt(row);
            int cCoordinate = random.nextInt(col);

            if (!minefieldAlpha[rCoordinate][cCoordinate].equals("*")) { // Form 12
                minefieldAlpha[rCoordinate][cCoordinate] = "*";
                fillNumbers(minefieldAlpha, rCoordinate, cCoordinate);
                i++;
            }
        }
        return minefieldAlpha;
    }

    public void fillZero(String[][] minefield) {
        for (String[] strings : minefield) {
            Arrays.fill(strings, "0");
        }
    }

    public void fillNumbers(String[][] array, int squareRow, int squareCol) {
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

        for (int d = 0; d < 8; d++) {
            int newRow = squareRow + dx[d];
            int newCol = squareCol + dy[d];

            if (isValid(newRow, newCol) && !array[newRow][newCol].equals("*")) {
                int number = Integer.parseInt(array[newRow][newCol]) + 1;
                array[newRow][newCol] = String.valueOf(number);
            }
        }
    }

    public boolean isValid(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }

    public String[][] createMinefieldBeta() {
        String[][] beta = new String[row][col];
        fillMinus(beta);
        return beta;
    }

    public void fillMinus(String[][] minefield) {
        for (String[] strings : minefield) {
            Arrays.fill(strings, "-");
        }
    }

    public void printMinefield(String[][] minefield) {
        for (String[] r : minefield) {
            for (String c : r) {
                System.out.print(c + "  ");
            }
            System.out.println();
        }
    }

    public String[][] initialMinefieldView() {
        String[][] view = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                view[i][j] = this.minefieldAlpha[i][j].equals("*") ? "*" : "-";
            }
        }
        return view;
    }

    public void checkWinCondition() {
        if (numberOfOpenSquares == maxNumberOfOpenSquares) {
            this.hasWon = true;
        }
    }

    private void revealAllMines() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (minefieldAlpha[i][j].equals("*")) {
                    minefieldBeta[i][j] = "*";
                }
            }
        }
    }
}

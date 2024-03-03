import java.util.Scanner;

public class MineSweeper {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter row: ");
        int x = scanner.nextInt();

        System.out.print("Enter column: ");
        int y = scanner.nextInt();

        Minefield minefield = new Minefield(x, y);

        int blocksOpened = 0;
        int blocksToBeOpenedToWin = (x * y) * 3 / 4;
        boolean gameIsStillRunning = true;
        boolean playerHasWon = false;

        do {
            minefield.print();

            System.out.print("Enter row: ");
            int row = scanner.nextInt();

            System.out.print("Enter column: ");
            int column = scanner.nextInt();

            if (minefield.isBlockOpen(row, column)) {
                System.out.println("You have already opened this block!");
                continue;
            }

            if ("*".equals(minefield.getBlockValue(row, column))) {
                minefield.setBlockOpen(row, column, true);
                System.out.println("You have stepped on a mine!");
                break;
            }

            minefield.setBlockOpen(row, column, true);
            blocksOpened++;
            System.out.println("You have opened an empty block!");

            if (blocksOpened == blocksToBeOpenedToWin) {
                playerHasWon = true;
                gameIsStillRunning = false;
            }
        } while (gameIsStillRunning);

        scanner.close();

        minefield.print();

        if (playerHasWon)
            System.out.println("You have won!");
        else
            System.out.println("You have lost!");
    }
}

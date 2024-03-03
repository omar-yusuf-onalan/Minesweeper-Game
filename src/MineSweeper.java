import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class MineSweeper {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dimensions: ");
        int row = scanner.nextInt();
        int column = scanner.nextInt();

        Minefield minefield = new Minefield(row, column);
    }
}

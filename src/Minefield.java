import java.util.Arrays;
import java.util.Random;

public class Minefield {
    private final int rowSize;
    private final int columnSize;
    private Block[][] blocks;

    public Minefield(int rowSize, int columnSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;

        setUpMinefield();
    }

    public void setUpMinefield() {
        // step #1: Create all the blocks with null values
        blocks = new Block[rowSize][columnSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                blocks[i][j] = new Block(i, j, null);
            }
        }

        // step #2: Loop the minefield until 1/4 of the minefield is
        // randomly placed mines.
        Random random = new Random();

        int numberOfMinesToPlace = rowSize * columnSize / 4;
        int minesPlaced = 0;

        while (minesPlaced < numberOfMinesToPlace) {
            int randomRow = random.nextInt(rowSize);
            int randomColumn = random.nextInt(columnSize);

            boolean theValueOfTheSelectedBlockIsNull = blocks[randomRow][randomColumn].getValue() == null;

            if (theValueOfTheSelectedBlockIsNull) {
                blocks[randomRow][randomColumn].setValue("*");
                minesPlaced++;
            }
        }

        // step #3: Every other block's value field will be null. Turn the
        // null value into the number of adjacent mines.
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                boolean blockContainsAMine = "*".equals(blocks[i][j].getValue());

                if (blockContainsAMine)
                    continue;

                countAdjacentMines(i, j);
            }
        }
    }

    private void countAdjacentMines(int currentRow, int currentColumn) {
        int adjacentMines = 0;

        for (int i = currentRow - 1; i < currentRow + 2; i++) {
            for (int j = currentColumn - 1; j < currentColumn + 2; j++) {
                boolean indexIsOutOfBounds = i == -1 || i == rowSize || j == -1 || j == columnSize;

                if (indexIsOutOfBounds)
                    continue;

                boolean blockIsTheOriginalBlock = i == currentRow && j == currentColumn;

                if (blockIsTheOriginalBlock)
                    continue;

                boolean blockContainsAMine = "*".equals(blocks[i][j].getValue());

                if (blockContainsAMine)
                    adjacentMines++;
            }
        }

        blocks[currentRow][currentColumn].setValue(String.valueOf(adjacentMines));
    }

    public void print() {

    }

    public String getBlockValue(int row, int column) {
        return blocks[row][column].getValue();
    }

    public void setBlockValue(int row, int column, String value) {
        blocks[row][column].setValue(value);
    }

    public boolean isBlockOpen(int row, int column) {
        return blocks[row][column].isOpen();
    }

    public void setBlockOpen(int row, int column, boolean isOpen) {
        blocks[row][column].setOpen(isOpen);
    }
}

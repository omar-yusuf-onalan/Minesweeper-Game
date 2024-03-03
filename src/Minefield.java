import java.util.Arrays;

public class Minefield {
    private Block[][] blocks;

    public Minefield(int rowSize, int columnSize) {
        setUpMinefield(rowSize, columnSize);
    }

    public void setUpMinefield(int rowSize, int columnSize) {
        // step #1: Create all the blocks with null values
        blocks = new Block[rowSize][columnSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                blocks[i][j] = new Block(i, j, null);
            }
        }

        // step #2: Loop the minefield until 1/4 of the minefield is
        // randomly placed mines.

        // step #3: Every other block's value field will be null. Turn the
        // null value into the number of adjacent mines.
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

public class Minefield {
    private Block[][] blocks;

    public Minefield(int rowSize, int columnSize) {
        setUpMinefield(rowSize, columnSize);
    }

    public void setUpMinefield(int rowSize, int columnSize) {

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

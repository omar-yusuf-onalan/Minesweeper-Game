public class Block {
    private final int rowPosition;
    private final int columnPosition;
    private String value;
    private boolean isOpen;

    public Block(int rowPosition, int columnPosition, String value) {
        this.rowPosition = rowPosition;
        this.columnPosition = columnPosition;
        this.value = value;
        this.isOpen = false;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public int getColumnPosition() {
        return columnPosition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        this.isOpen = open;
    }
}

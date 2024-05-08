public class Block {
    private String value;
    private boolean isOpen;

    public Block(String value) {
        this.value = value;
        this.isOpen = false;
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

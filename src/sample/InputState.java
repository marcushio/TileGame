package sample;

public class InputState {
    int rowClicked;
    int colClicked;
    int oldRowClicked;
    int oldColClicked;

    public void newClick(int row, int col){
        oldRowClicked = this.rowClicked;
        oldColClicked = this.colClicked;
        this.rowClicked = row;
        this.colClicked = col;
    }

    public int getRowClicked() {
        return rowClicked;
    }

    public int getColClicked() {
        return colClicked;
    }

    public int getOldRowClicked() {
        return oldRowClicked;
    }

    public int getOldColClicked() {
        return oldColClicked;
    }
}

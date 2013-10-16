/**
 * Name: Churchill Lee, Christine Tay
 * Date: 10/7/13
 * Time: 3:20 PM
 *
 * Coordinate class is to store coordinates easier
 */
public class Coordinate {
    private int row;
    private int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {

        return row;
    }

    public int getCol() {
        return col;
    }

    private void setRow(int row) {
        this.row = row;
    }

    private void setCol(int col) {
        this.col = col;
    }

    public void set(int row, int col) {
        setRow(row);
        setCol(col);
    }

    public boolean equal(Coordinate obj) {
        if (this.row == obj.row && this.col == obj.col) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "(" + this.row + ", " + this.col + ")";
    }
}

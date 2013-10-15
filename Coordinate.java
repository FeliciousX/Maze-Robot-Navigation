/**
 * Name: Churchill Lee
 * User: FeliciousX
 * Date: 10/7/13
 * Time: 3:20 PM
 * Execution:
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

    public boolean equal(Coordinate obj) {
        if (this.row == obj.row && this.col == obj.col) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "(" + this.row + ", " + this.col + ")";
    }
}

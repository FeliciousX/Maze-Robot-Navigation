import java.util.ArrayList;

/**
 * Name:
 * User: FeliciousX
 * Date: 10/7/13
 * Time: 4:11 PM
 * Execution:
 */
public abstract class Robot {
    protected Node current;
    protected ArrayList<Node> open;
    protected ArrayList<Node> expanded;

    protected class Node {
        int row, col;
        Node parent;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
            this.parent = null;
        }
    }

    protected Robot(int row, int col) {
        this.current = new Node(row, col);
    }
}

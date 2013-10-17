/**
 * Name: Churchill Lee, Christine Tay
 * Date: 10/15/13
 * Time: 1:50 PM
 *
 * Node for the robot to use to store coordinates.
 */
public class Node {
    Coordinate position; // the position of the node
    Node parent;  // parent node used to track the way back
    int depth;

    Node(int row, int col) {
        this.position = new Coordinate(row, col);
        this.parent = null;
        this.depth = 0;
    }

    public void setParent(Node parent) {
        this.parent = parent;
        this.depth = this.parent.depth + 1;
    }
}

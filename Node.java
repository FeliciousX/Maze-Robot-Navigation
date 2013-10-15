/**
 * Name: Churchill Lee, Christine Tay
 * Date: 10/15/13
 * Time: 1:50 PM
 *
 * Node for the robot to use.
 */
public class Node {
    Coordinate position; // the position of the node
    Node parent;  // parent node used to track the way back

    Node(int row, int col) {
        this.position = new Coordinate(row, col);
        this.parent = null;
    }
}

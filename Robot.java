import java.util.ArrayList;

/**
 * Name:Churchill Lee, Christine Tay
 * Date: 10/7/13
 * Time: 4:11 PM
 * Execution:
 */
public abstract class Robot {
    protected Node current;             // robot's current location
    protected ArrayList<Node> open;     // stores unexpanded nodes
    protected ArrayList<Node> expanded; // stores expanded nodes
    protected int R, C;                 // dimension of the maze is known to the robot
    protected boolean wall[][];         // environment of the maze is known to the robot
    protected boolean visited[][];
    protected ArrayList<Coordinate> solution;

    protected class Node {
        Coordinate position; // the position of the node
        Node parent;  // parent node used to track the way back

        Node(int row, int col) {
            this.position = new Coordinate(row, col);
            this.parent = null;
        }
    } // end inner class Node

    protected Robot(int R, int C, boolean wall[][]) {
        this.R = R;
        this.C = C;
        this.wall = wall;
        this.visited = new boolean[R][C];
        this.current = new Node(1, 0); // Robot always starts from top left of the maze
        this.open = new ArrayList<Node>();
        this.expanded = new ArrayList<Node>();
        this.open.add(this.current);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visited[i][j] = false;
            }
        }
    }

    public ArrayList<Coordinate> getSolution() {
        return solution;
    }

    protected abstract boolean solve();
}

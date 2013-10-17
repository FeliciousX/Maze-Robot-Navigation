import java.util.ArrayList;

/**
 * Name:Churchill Lee, Christine Tay
 * Date: 10/7/13
 * Time: 4:11 PM
 */
public abstract class Robot {
    protected Node current;             // robot's current location
    protected ArrayList<Node> open;     // stores unexpanded nodes
    protected ArrayList<Node> expanded; // stores expanded nodes
    protected int R, C;                 // dimension of the maze is known to the robot
    protected boolean wall[][];         // environment of the maze is known to the robot
    protected ArrayList<Coordinate> solution; // solution path in coordinates
    protected Coordinate goal;
    protected Node start;
    protected MazeView mazeView;
    protected int nodes;

    protected Robot(int R, int C, boolean wall[][]) {
        this.R = R;
        this.C = C;
        this.wall = wall;
        this.current = null;
        this.start = new Node(1, 0);  // Robot always starts from top left of the maze
        this.goal = new Coordinate(this.R - 2, this.C - 1);
        this.open = new ArrayList<Node>();
        this.expanded = new ArrayList<Node>();
        this.mazeView = new MazeView();
        this.nodes = 0;

        mazeView.draw(this);
        StdDraw.show(1000);
    }

    public ArrayList<Coordinate> getSolution() {
        return solution;
    }

    public int getRow() {
        return R;
    }

    public int getCol() {
        return C;
    }

    public boolean[][] getWall() {
        return wall;
    }

    public ArrayList<Node> getExpanded() {
        return expanded;
    }

    protected abstract boolean solve();
    protected abstract void populateSolution();

    public void printSolution() {
        StdOut.println("SOLUTION FOUND!");
        StdOut.println("Number of nodes expanded: " + this.nodes);
        StdOut.println("Solution path from goal:");
        for (Coordinate path : this.solution) {
            StdOut.println(path.toString());
        }
    }
}

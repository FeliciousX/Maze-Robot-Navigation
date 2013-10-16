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
    protected boolean visited[][];      // robot remembers visited nodes
    protected ArrayList<Coordinate> solution; // solution path in coordinates
    protected Coordinate goal;
    protected Node start;
    protected MazeView mazeView;

    protected Robot(int R, int C, boolean wall[][]) {
        this.R = R;
        this.C = C;
        this.wall = wall;
        this.visited = new boolean[this.R][this.C];
        this.current = null;
        this.start = new Node(1, 0);  // Robot always starts from top left of the maze
        this.goal = new Coordinate(this.R - 2, this.C - 1);
        this.open = new ArrayList<Node>();
        this.expanded = new ArrayList<Node>();
        this.mazeView = new MazeView();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visited[i][j] = false;
            }
        }

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
}

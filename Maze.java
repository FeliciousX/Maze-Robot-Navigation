import java.io.File;
import java.util.ArrayList;

/**
 * Name:
 * User: FeliciousX
 * Date: 10/14/13
 * Time: 4:11 PM
 * Execution:
 */
public class Maze {
    public static final int BFS = 1;
    public static final int DFS = 2;
    public static final int BEST_FIRST = 3;
    public static final int A_STAR = 4;
    public static final int HILL_CLIMBING = 5;
    public static final int JAEGER_SEARCH = 6;

    private boolean wall[][];
    private Robot kaiju;
    private int row, col; // maze dimension

    public Maze(int option, String fileName) {
        this.init(fileName);

        switch (option) {
            case BFS:
                this.kaiju = new BFSKaiju(this.row, this.col, this.wall);
                break;
            case DFS:
                this.kaiju = new DFSKaiju(this.row, this.col, this.wall);
                break;
            case BEST_FIRST:
                this.kaiju = new BestFirstKaiju(this.row, this.col, this.wall);
                break;
            case A_STAR:
                this.kaiju = new AStarKaiju(this.row, this.col, this.wall);
                break;
            case HILL_CLIMBING:
                this.kaiju = new HillClimbingKaiju(this.row, this.col, this.wall);
                break;
            case JAEGER_SEARCH:
                this.kaiju = new JaegarKaiju(this.row, this.col, this.wall);
                break;
            default:
                showMenu();
        }
    }

    private void init(String fileName) {
        File file = new File(fileName);
        In in = new In(file);

        String line = in.readLine();

        line = line.substring(1, line.indexOf(']'));
        String[] dimension = line.split(", ");

        this.row = Integer.parseInt(dimension[0]);
        this.col = Integer.parseInt(dimension[1]);

        wall = new boolean[this.row][this.col];

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                wall[i][j] = false;
            }
        }

        int x, y;
        while (in.hasNextLine()) {
            line = in.readLine();
            line = line.substring(1, line.indexOf(')'));
            String[] coord = line.split(", ");

            x = Integer.parseInt(coord[0]) - 1;
            y = Integer.parseInt(coord[1]) - 1;
            wall[x][y] = true;
        }
    }

    public void solve() {
        if (this.kaiju.solve()) {
            // TODO: draw solution on screen
            StdOut.println("SOLUTION FOUND!");
            ArrayList<Coordinate> solution = this.kaiju.getSolution();

            /*for (Coordinate c : solution) {
                StdOut.println("(" + c.getRow() + ", " + c.getCol() + ")");
            }*/


        }
        else {
            StdOut.println("No solution found! :(");
        }
    }

    private void showMenu() {
        // TODO: show menu
    }

    public static void main(String[] args) {
        Maze maze = new Maze(1, "src/maze.txt");
        maze.solve();
    }
}

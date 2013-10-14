import java.io.File;

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

    private boolean walls[][];
    private Robot kaiju;

    public Maze(int option, File fileName) {
        init(fileName);
        switch (option) {
            case BFS:
                this.kaiju = new BFSKaiju(12, 13);
                break;
            case DFS:
                this.kaiju = new DFSKaiju(12, 13);
                break;
            case BEST_FIRST:
                this.kaiju = new BestFirstKaiju(12, 13);
                break;
            case A_STAR:
                this.kaiju = new AStarKaiju(12, 13);
                break;
            case HILL_CLIMBING:
                this.kaiju = new HillClimbingKaiju(12, 13);
                break;
            case JAEGER_SEARCH:
                this.kaiju = new JaegarKaiju(12, 13);
                break;
            default:
                showMenu();
        }
    }

    private void init(File fileName) {
        In in = new In(fileName);
        String line;
        if (in.hasNextLine()) {
            line = in.readLine();
            // TODO: store data properly
        }
    }

    private void showMenu() {
        // TODO: show menu
    }
}

import java.io.File;
import java.util.ArrayList;

/**
 * Name: Churchill Lee, Christine Tay
 * Date: 10/8/13
 * Time: 10:58 PM
 * Execution: MazeView $mazeFile$
 */
public class MazeView {
    private ArrayList<Coordinate> solution;

    public MazeView() {
        this.solution = new ArrayList<Coordinate>();
        StdDraw.show(0);
    }

    public void draw(Maze maze) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.WHITE);
        int C = maze.getCol();
        int R = maze.getRow();
        StdDraw.setXscale(0, C);
        StdDraw.setYscale(0, R);
        StdDraw.filledRectangle(C / 2.0, R / 2.0, C / 2.0, R / 2.0);

        boolean[][] walls = maze.getWall();

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (walls[row][col]) {
                    StdDraw.setPenColor(StdDraw.DARK_GRAY);
                }
                else {
                    StdDraw.setPenColor(StdDraw.WHITE);
                }

                StdDraw.filledRectangle(col + 0.5, R - row, 0.45, 0.45);
            }
        }

        this.solution = maze.getSolution();

        if (this.solution != null) {
            for (Coordinate path : solution) {
                StdOut.println("(" + path.getRow() + ", " + path.getCol() + ")");
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledCircle(path.getCol() + 0.5, R - path.getRow(), 0.25);
                StdDraw.show(50);
            }
        }
    }

    public static void main(String[] args) {
        Maze maze = new Maze(2, args[0]);

        MazeView mazeView = new MazeView();
        StdDraw.show(0);
        mazeView.draw(maze);
        StdDraw.show(10);
    }
}

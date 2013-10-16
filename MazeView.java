import java.util.ArrayList;

/**
 * Name: Churchill Lee, Christine Tay
 * Date: 10/8/13
 * Time: 10:58 PM
 *
 * MazeView class links the maze with the GUI.
 * Using alg4 library.
 */
public class MazeView {

    private int C, R;
    private boolean[][] wall;

    public MazeView() {
        StdDraw.show(0);
    }

    public void draw(Robot kaiju) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.WHITE);
        this.C = kaiju.getCol();
        this.R = kaiju.getRow();
        StdDraw.setXscale(0, C);
        StdDraw.setYscale(0, R);
        StdDraw.filledRectangle(C / 2.0, R / 2.0, C / 2.0, R / 2.0);

        wall = kaiju.getWall();

        // draw maze
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (wall[row][col]) {
                    StdDraw.setPenColor(StdDraw.DARK_GRAY);
                }
                else {
                    StdDraw.setPenColor(StdDraw.WHITE);
                }

                StdDraw.filledRectangle(col + 0.5, R - row, 0.45, 0.45);
            }
        }

        // draw starting point and goal
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.circle(0 + 0.5, this.R - 1, 0.30);
        StdDraw.circle(this.C - 1 + 0.5, this.R - (this.R - 2), 0.30);
    }

    public void animate(Robot kaiju) {
        draw(kaiju);
        ArrayList<Node> expanded = kaiju.getExpanded();

        StdDraw.setPenColor(StdDraw.GRAY);

        for (Node flow : expanded) {
            int r = flow.position.getRow();
            int c = flow.position.getCol();

            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledCircle(c + 0.5, this.R - r, 0.25);
        }
        StdDraw.show(100);
    }

    public void solved(Robot kaiju) {
        ArrayList<Coordinate> solution = kaiju.getSolution();

        StdDraw.setPenColor(StdDraw.BLUE);

        for (Coordinate path : solution) {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledCircle(path.getCol() + 0.5, this.R - path.getRow(), 0.25);
            StdDraw.show(0);
        }
    }
}

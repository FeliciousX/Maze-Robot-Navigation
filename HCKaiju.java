import java.util.ArrayList;

/**
 * Name: Churchill Lee, Christine Tay
 * Date: 10/14/13
 * Time: 6:14 PM
 *
 * HCKaiju class implements Hill Climbing algorithm to search
 * for solution path to goal. It uses the distance as the score of
 * a position. Does not return.
 */
public class HCKaiju extends Robot {
    private int weight[][];
    private int nextWeight;

    public HCKaiju(int row, int col, boolean wall[][]) {
        super(row, col, wall);
        this.weight = new int[row][col];
        this.nextWeight = - (row + col);
    }

    @Override
    protected boolean solve() {
        this.init();

        this.current = this.start;
        this.open.add(this.current);
        this.expanded.add(this.current);
        this.expand();

        while(! this.open.isEmpty()) {

            // check if reach goal
            if (this.current.position.equal(this.goal)) {
                this.nodes = this.expanded.size();
                this.populateSolution();
                this.mazeView.solved(this);
                return true;
            }

            Node lightest = null;
            int r = this.current.position.getRow();
            int c = this.current.position.getCol();
            nextWeight = this.weight[r][c];
            // loops through opened nodes and finds the lowest weight to expand
            for (Node coord : this.open) {
                int x = coord.position.getRow();
                int y = coord.position.getCol();
                if (this.weight[x][y] > nextWeight) {
                    lightest = coord;
                    nextWeight = this.weight[x][y];
                }
            }

            this.current = lightest;
            this.open.clear();

            if (nextWeight <= this.weight[r][c]) {
                return false;
            }

            this.expanded.add(this.current);
            this.expand();
        }
        return false;
    }

    @Override
    protected void populateSolution() {
        this.solution = new ArrayList<Coordinate>();
        while(this.current != null) {
            this.solution.add(0, this.current.position);
            this.current = this.current.parent;
        }
    }

    private void init() {

        for (int i = 0; i < this.R; i++) {
            for (int j = 0; j < this.C; j++) {
                this.weight[i][j] = (i + 1 - this.R) + (j - this.C) + 2;
            }
        }
    }

    private void expand() {
        int r = this.current.position.getRow();
        int c = this.current.position.getCol();

        expand(r - 1, c);  // expand up
        expand(r, c - 1);  // expand left
        expand(r + 1, c);  // expand bottom
        expand(r, c + 1);  // expand right
        this.mazeView.animate(this);
    }

    private void expand(int r, int c) {
        // check if it is out of bound
        if (r < 0 || c < 0 || r == this.R || c == this.C) return;
        // if it's a wall or visited node, return.
        if (this.wall[r][c]) return;
        // if coordinate is actually parent's coordinate, return
        if (this.current.parent != null &&
                this.current.parent.position.equal(new Coordinate(r, c))) return;

        Node child = new Node(r, c);
        child.setParent(this.current);
        this.open.add(child);

        // Output the expanded node
        StdOut.println("Expand: " + child.position.toString() +
        " Weight: " + this.weight[child.position.getRow()][child.position.getCol()]);
    }
}

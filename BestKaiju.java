import java.util.ArrayList;

/**
 * Name: Churchill Lee, Christine Tay
 * Date: 10/14/13
 * Time: 6:10 PM
 *
 * BestKaiju class implements the Greedy Best First Search algorithm
 * to find the solution path to the goal.
 */
public class BestKaiju extends Robot {
    private boolean visited[][];
    private int weight[][];  // stores the weight of each coordinate

    public BestKaiju(int row, int col, boolean wall[][]) {
        super(row, col, wall);
        this.visited = new boolean[row][col];
        this.weight = new int[row][col];
    }

    @Override
    protected boolean solve() {
        this.init();

        this.current = this.start;
        this.open.add(this.current);
        this.visited[1][0] = true;
        while(! this.open.isEmpty()) { // while there's still open nodes
            Node lightest = this.start;

            // loops through opened nodes and finds the lowest weight to expand
            for (Node coord : this.open) {
                int x = coord.position.getRow();
                int y = coord.position.getCol();
                int r = lightest.position.getRow();
                int c = lightest.position.getCol();
                if (this.weight[x][y] < this.weight[r][c]) {
                    lightest = coord;
                }
            }

            this.current = lightest;

            this.open.remove(this.current);

            // check if reach goal!
            if (this.current.position.equal(this.goal)) {
                this.nodes = this.expanded.size();
                this.populateSolution();
                this.mazeView.solved(this);
                return true;
            }
            else {
                this.expanded.add(this.current);
                this.expand();
            }
        }
        this.nodes = this.expanded.size();
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
                this.visited[i][j] = false;
                this.weight[i][j] = (this.R - i - 1) + (this.C - j) - 2;
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
        if (this.wall[r][c] || this.visited[r][c]) return;

        Node child = new Node(r, c);
        child.setParent(this.current);
        this.open.add(child);
        visited[r][c] = true;

        // Output the expanded node
        StdOut.println("Expand: " + child.position.toString());
    }
}

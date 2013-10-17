import java.util.ArrayList;

/**
 * Name: Churchill Lee, Christine Tay
 * Date: 10/14/13
 * Time: 6:09 PM
 * Execution:
 */
public class ASearchKaiju extends Robot {

    private boolean visited[][];
    private int weight[][];
    private boolean done;
    
    public ASearchKaiju(int row, int col, boolean wall[][]) {
        super(row, col, wall);
        this.visited = new boolean[row][col];
        this.weight = new int[row][col];
        this.done = false;
    }

    @Override
    protected boolean solve() {
        this.init();
        
        this.open.add(this.start);
        this.current = this.start;
        this.expand();

        return this.done;
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
        while(! this.open.isEmpty()) {
            // loops through opened nodes and finds the lowest weight to expand
            Node consider = this.open.get(0);
            for (Node next : this.open) {
                if (getCost(next) < getCost(consider)) {
                    consider = next;
                }
            }

            this.current = consider;

            // check if reach goal
            if (this.current.position.equal(this.goal)) {
                this.nodes = this.expanded.size();
                this.populateSolution();
                this.mazeView.solved(this);
                this.done = true;
                return;
            }

            this.open.remove(this.current);
            this.expanded.add(this.current);

            int r = this.current.position.getRow();
            int c = this.current.position.getCol();

            expand(r - 1, c);  // expand up
            expand(r, c - 1);  // expand left
            expand(r + 1, c);  // expand bottom
            expand(r, c + 1);  // expand right

            this.mazeView.animate(this);

        }
    }

    private void expand(int r, int c) {
        // check if it is out of bound
        if (r < 0 || c < 0 || r == this.R || c == this.C) return;
        // if it's a wall or visited, return.
        if (this.wall[r][c] || this.visited[r][c]) return;
        // if it's solved, return
        if (this.done) return;

        Node child = new Node(r, c);
        child.setParent(this.current);
        this.open.add(child);
        this.visited[r][c] = true;

        // Output the expanded node
        StdOut.println("Expand: " + child.position.toString());
    }

    private int getCost(Node x) {
        int r = x.position.getRow();
        int c = x.position.getCol();

        return this.weight[r][c] + x.depth;
    }
}

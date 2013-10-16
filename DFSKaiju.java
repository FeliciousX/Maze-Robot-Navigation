import java.util.ArrayList;

/**
 * Name: Churchill Lee, Christine Tay
 * Date: 10/14/13
 * Time: 5:05 PM
 *
 * DFSKaiju class implements the Depth First Search algorithm
 * to find the solution path to the goal
 */
public class DFSKaiju extends Robot {
    private boolean done;

    public DFSKaiju(int row, int col, boolean wall[][]) {
        super(row, col, wall);
        this.done = false;
    }

    @Override
    protected void populateSolution() {
        this.solution = new ArrayList<Coordinate>();
        this.current = this.expanded.get(this.expanded.size() - 1);
        while(this.current != null) {
            this.solution.add(0, this.current.position);
            this.current = this.current.parent;
        }
    }

    @Override
    protected boolean solve() {
        expand();
        if (done) {
            this.populateSolution();
            this.mazeView.solved(this);
        }
        return this.done;
    }

    /**
     * Only expands if it's not out of bound,
     * not a wall and not visited.
     * Robot will move up, left, down, right because
     * If the node can't be expanded anymore, remove node
     */
    private void expand(Node x){
        Coordinate position = x.position;
        int r = position.getRow();
        int c = position.getCol();
        if (r < 0 || c < 0 || r == this.R || c == this.C) return;
        if (this.wall[r][c] || this.visited[r][c]) return;
        if (this.done) return;

        this.visited[r][c] = true;
        this.expanded.add(x);
        x.parent = this.current;
        this.current = x;

        this.mazeView.animate(this);
        if (position.equal(this.goal)) this.done = true;

        // expand up
        this.expand(new Node(r - 1, c));
        // expand left
        this.expand(new Node(r, c - 1));
        // expand down
        this.expand(new Node(r + 1, c));
        // expand right
        this.expand(new Node(r, c + 1));

        if (this.done) return;

        this.expanded.remove(this.current);
        this.current = this.current.parent;
    }


    private void expand() {
        expand(this.start);
    }
}

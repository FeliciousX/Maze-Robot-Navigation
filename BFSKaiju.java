import java.util.ArrayList;

/**
 * Name: Churchill Lee, Christine Tay
 * Date: 10/14/13
 * Time: 6:09 PM
 *
 * BFSKaiju class implements the Breadth First Search algorithm
 * to find the solution path to the goal.
 */
public class BFSKaiju extends  Robot {

    public BFSKaiju(int row, int col, boolean wall[][]) {
        super(row, col, wall);
    }

    @Override
    protected boolean solve() {

        this.current = this.start;
        this.open.add(this.current);
        while(! this.open.isEmpty()) { // while there's still open nodes
            // pops the first node from the ArrayList (FIFO)
            Node nextNode = this.open.get(0);
            this.open.remove(0);

            this.current = nextNode; // move robot

            this.mazeView.animate(this);
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

    private void expand() {
        int r = this.current.position.getRow();
        int c = this.current.position.getCol();

        expand(r - 1, c);  // expand up
        expand(r, c - 1);  // expand left
        expand(r + 1, c);  // expand bottom
        expand(r, c + 1);  // expand right
    }

    private void expand(int r, int c) {
        // check if it is out of bound
        if (r < 0 || c < 0 || r == this.R || c == this.C) return;
        // if it's a wall, return.
        if (this.wall[r][c]) return;
        // if coordinate is actually parent's coordinate, return
        if (this.current.parent != null &&
            this.current.parent.position.equal(new Coordinate(r, c))) return;

        Node child = new Node(r, c);
        child.setParent(this.current);
        this.open.add(child);

        // Output the expanded node
        StdOut.println("Expand: " + child.position.toString());
    }
}

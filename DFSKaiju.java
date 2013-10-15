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
    public DFSKaiju(int row, int col, boolean wall[][]) {
        super(row, col, wall);
    }

    @Override
    protected boolean solve() {
        while(! this.open.isEmpty()) {
            // pops the last node from the ArrayList (LIFO)
            int size = this.open.size() - 1;
            Node temp = this.open.get(size);
            this.open.remove(size);

            this.current = temp; // move robot

            // check if reach goal!
            if (this.current.position.equal(this.goal)) {
                this.populateSolution();
                this.mazeView.solved(this);
                return true;
            }
            else {
                this.expanded.add(this.current);
                this.expand();

                this.mazeView.animate(this);
            }
        }

        return false;
    }

    @Override
    /**
     * Expands nodes right, down, left, up.
     * Only expands if it's not out of bound,
     * not a wall and not visited.
     * Robot will move up, left, down, right because
     * it's following LIFO method.
     * If the node can't be expanded anymore, remove node
     */
    protected void expand() {
        boolean dead = true;
        int r = this.current.position.getRow();
        int c = this.current.position.getCol();

        // expand right
        if (expand(r, c + 1)) { dead = false; }
        // expand down
        if (expand(r + 1, c)) { dead = false; }
        // expand left
        if (expand(r, c - 1)) { dead = false; }
        // expand up
        if (expand(r - 1, c)) { dead = false; }

        if (dead) {
            this.expanded.remove(this.current);
        }

    }

    // only expands if not out of bounds
    // not a wall
    // and not visited.
    // returns true if expanded (not a dead node)
    private boolean expand(int r, int c) {
        if (! (r < 0) &&
            ! (r >= this.R) &&
            ! (c < 0) &&
            ! (c >= this.C) &&
            ! (this.wall[r][c]) &&
            ! (this.visited[r][c])
           ) {
            Node child = new Node(r, c);
            child.parent = this.current;
            this.open.add(child);
            visited[r][c] = true;

            return true;
        }

        return false;
    }
}

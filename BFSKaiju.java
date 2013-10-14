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
        while(! this.open.isEmpty()) { // while there's still open nodes
            // pops the first node from the ArrayList (FIFO)
            Node temp = this.open.get(0);
            this.open.remove(0);

            this.current = temp; // move robot

            // check if reach goal!
            if (this.current.position.equal(this.goal)) {
                this.populateSolution();
                return true;
            }
            else {
                this.expanded.add(this.current);
                this.expand();
            }
        }

        return false;
    }

    @Override
    protected void expand() {
        int r = this.current.position.getRow();
        int c = this.current.position.getCol();

        if (! (r - 1 < 0)) { // expand above if not out of bounds
            expand(r - 1, c);
            visited[r - 1][c] = true;
        }

        if (! (c - 1 < 0)) { // expand left if not out of bounds
            expand(r, c - 1);
            visited[r][c - 1] = true;
        }

        if (! (r + 1 >= this.R)) { // expand below if not out of bounds
            expand(r + 1, c);
            visited[r + 1][c] = true;
        }

        if (! (c + 1 >= this.C)) { // expand right if not out of bounds
            expand(r, c + 1);
            visited[r][c + 1] = true;
        }
    }

    private void expand(int r, int c) {
        // if it's a wall or visited node, return.
        if (this.wall[r][c] || this.visited[r][c]) {
            return;
        }
        else { // expand
            Node child = new Node(r, c);
            child.parent = this.current;
            this.open.add(child);
        }
    }
}

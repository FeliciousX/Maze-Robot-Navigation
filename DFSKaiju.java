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

            // TODO: remove debug
            StdOut.println("Robot: " + current.position.toString());
            // end debug

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


        if (! (r - 1 < 0) &&              // expand if not out of bounds and
            ! (this.wall[r - 1][c]) &&    // not a wall and
            ! (this.visited[r - 1][c])) { // not visited

            Node child = new Node(r - 1, c);
            child.parent = this.current;
            this.open.add(child);
            visited[r - 1][c] = true;

            // TODO: remove debug
            StdOut.println("expanding up");
            // end debug
        }

        else if (! (c - 1 < 0) &&
                 ! (this.wall[r][c - 1]) &&
                 ! (this.visited[r][c - 1])) {

            Node child = new Node(r, c - 1);
            child.parent = this.current;
            this.open.add(child);
            visited[r][c - 1] = true;

            // TODO: remove debug
            StdOut.println("expanding left");
            // end debug
        }

        else if (! (r + 1 >= this.R) &&
                 ! (this.wall[r + 1][c]) &&
                 ! (this.visited[r + 1][c])) {

            Node child = new Node(r + 1, c);
            child.parent = this.current;
            this.open.add(child);
            visited[r + 1][c] = true;

            // TODO: remove debug
            StdOut.println("expanding down");
            // end debug
        }

        else if (! (c + 1 >= this.C) &&
                 ! (this.wall[r][c + 1]) &&
                 ! (this.visited[r][c + 1])) {

            Node child = new Node(r, c + 1);
            child.parent = this.current;
            this.open.add(child);
            visited[r][c + 1] = true;

            // TODO: remove debug
            StdOut.println("expanding right");
            // end debug
        }

        else return;
    }
}

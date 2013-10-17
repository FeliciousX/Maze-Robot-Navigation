/**
 * Name: Churchill Lee, Christine Tay
 * Date: 10/14/13
 * Time: 6:09 PM
 * Execution:
 */
public class ASearchKaiju extends Robot {

    private boolean visited[][];
    private int weight[][];
    public ASearchKaiju(int row, int col, boolean wall[][]) {
        super(row, col, wall);
    }

    @Override
    protected boolean solve() {
        this.init();

        return false;
    }

    @Override
    protected void populateSolution() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    private void init() {

        for (int i = 0; i < this.R; i++) {
            for (int j = 0; j < this.C; j++) {
                this.visited[i][j] = false;
                this.weight[i][j] = (this.R - i - 1) + (this.C - j) - 2;
            }
        }
    }
}

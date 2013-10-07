/**
 * Name: Churchill Lee
 * User: FeliciousX
 * Date: 10/7/13
 * Time: 3:18 PM
 * Execution:
 */
public class Space {
    private Location location;
    private boolean trailed;
    private boolean wall;

    public Space(Location location, boolean wall) {
        this.location = location;
        this.wall = wall;
    }

    public Space(Location location, boolean wall, boolean trailed) {
        this.location = location;
        this.wall = wall;
        this.trailed = trailed;
    }

    public void setTrailed(boolean trailed) {
        this.trailed = trailed;
    }

    public boolean isTrailed() {
        return trailed;
    }

    public boolean isWall() {
        return wall;
    }

    public Location getLocation() {
        return location;
    }
}

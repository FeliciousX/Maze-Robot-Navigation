/**
 * Name:
 * User: FeliciousX
 * Date: 10/7/13
 * Time: 4:11 PM
 * Execution:
 */
public class Robot {
    private Location location;
    private Node first;

    private class Node {
        Space space;
        Node right;
        Node down;
        Node left;
        Node up;
    }

    public Location getLocation() {
        return location;
    }

    public void moveLeft() {
        // TODO: move robot left if node available
    }

    public void moveRight() {
        // TODO: move robot right if node available
    }

    public void modeUp() {
        // TODO: move robot up if node available
    }

    public void modeDown() {
        // TODO: move robot down if node available
    }

    public void expand() {
        // TODO: expand nodes in 4 directions if available
    }
}

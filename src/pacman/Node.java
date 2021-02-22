package pacman;
/*
 * our node class which stores x and y position
 */
class Node {
    int x;
    int y;

    Node prev;
    Node next;
    //must have a parent/prev to keep track
    Node(int x, int y, Node prev_node) {
        this.x = x;
        this.y = y;
        this.prev = prev_node;
    }
}






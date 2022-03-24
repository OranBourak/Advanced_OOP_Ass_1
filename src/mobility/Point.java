package mobility;


/**
 * Point - defines (x,y) coordinate on a 2-dim grid.
 * @version : 1
 * @author : Tomer Burman, Oran Bourak
 */
public class Point {
    /**
     * x - value of x coordinate
     * y - value of y coordinate
     * max_x, min_x, max_y, min_y - defines ranges for (x,y) coordinate.
     */
    private int x; // values between 0-800
    private int y; //values between 0-600
    final static int max_x = 800, max_y = 600;
    final static int min_x = 0, min_y = 0;

    /**
     * Point constructor - recieves (x,y) coordinate and creates a Point at the same coordinate.
     * @param x - x coordinate
     * @param y - y coordinate
     */
    Point(int x,int y){
        this.setX(x);
        this.setY(y);

    }
    Point(int x){
        this(x,0);
    }
    Point(){
        this(0,0);
    }
    boolean setX(int x){
        if (min_x <= x && max_x >= x) {
            this.x = x;
            return true;
        }
        return false; // not in range
    }
    boolean setY(int y){
        if (min_y <= y && max_y >= y) {
            this.y = y;
            return true;
        }
        return false; // not in range
    }





}

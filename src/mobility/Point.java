package mobility;

public class Point {
    private int x; // values between 0-800
    private int y; //values between 0-600
    final static int max_x = 800, max_y = 600;
    final static int min_x = 0, min_y = 0;

    Point(int x,int y){
        this.setX(x);
        this.setY(y);

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
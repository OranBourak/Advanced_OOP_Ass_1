package mobility;

/**
 * Ilocateable - interface that represents functionality of objects space.
 */
public interface ILocatable {
    /**
     *
     * @return location of the object represented by (x,y) coordinate.
     */
    Point getLocation();

    /**
     *
     * @return True if Point is set and false otherwise.
     */
    public boolean setLocation(Point p);
}

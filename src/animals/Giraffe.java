package animals;
import mobility.*;
import privateutil.Chewing_animals;
import utilities.MessageUtility;

/**
 * Giraffe - extends Chewing animals
 * @version  - 1
 * @author - Tomer Burman, Oran Bourak.
 */
public class Giraffe extends Chewing_animals {
    private double neckLength; // neck length
    private final static double neck_Length_min = 1, neck_Length_max = 2.5,defaultLength = 1.5, defaultWeight =450; // neck length boundries.

    /**
     * Giraffe ctor - initiates base class and sets weight to default(450), if neckLength
     * is
     *
     * @param name
     * @param location
     */
    public Giraffe(String name,Point location,double length){
        super(name,location);
        this.setWeight(defaultWeight);
        if(!this.setNeckLength(length))
            this.setNeckLength(defaultLength);
        MessageUtility.logConstractor("Giraffe", this.getName());
    }

    /**
     * Giraffe ctor - uses ctor that recieves name and point with default point of (50,0).
     * @param name
     */
    public Giraffe(String name,Point location){
        this(name,location,defaultLength);

    }

    /**
     * ctor that receives only name
     * @param name
     */
    public Giraffe(String name) {
        this(name, new Point(50, 0), defaultLength);
    }

    /**
     * setNeckLength - sets neckLength to length received if it's in bounds. (1 to 2.5 meters).
     * @param length length recieved
     * @return true if in boundries, false otherwise.
     */
    public boolean setNeckLength(double length){
        if(length >= neck_Length_min && length <= neck_Length_max){
            MessageUtility.logSetter(this.getName(), "setNeckLength", length, true);
            this.neckLength = length;
            return true;
        }
        MessageUtility.logSetter(this.getName(), "setNeckLength", length, false);
        return false;
    }

    /**
     *
     * @return neckLength of giraffe.
     */
    public double getNeckLength(){
        MessageUtility.logGetter(this.getName(), "getNeckLength", this.neckLength);
        return neckLength;
    }

    /**
     * uses Animal toString.
     * @return
     */
    public String toString(){
        return super.toString();
    }

    /**
     * Giraffe chew .
     */
    public void chew() {
        //TODO
    }
}


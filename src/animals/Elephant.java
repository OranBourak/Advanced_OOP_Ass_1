package animals;

import diet.Herbivore;
import mobility.Point;
import privateutil.Chewing_animals;
import utilities.MessageUtility;

import static utilities.MessageUtility.logSetter;

public class Elephant extends Chewing_animals {
    private double trunkLength; // represent the elephant trunk length.
    private final static double min_trungLength = 0.5;
    private final static double maximum_trunkLength = 3;
    private final static double trunkDefaultLength = 1;

    /**
     * Elephant Ctor
     * @param name - elephant name.
     * @param location - elephant location.
     */
    public Elephant(String name, Point location, double trunkLength) {
        super(name, location);
        this.setWeight(500);
        if (!setTrunkLength(trunkLength))
            setTrunkLength(trunkDefaultLength);
        this.setDiet(new Herbivore());
        MessageUtility.logConstractor("Elephant", this.getName());
    }

    /**
     * Elephant Ctor that receives name and location , trunk length is set to default.
     * @param name - elephant name.
     * @param location - elephant location.
     */
    public Elephant(String name, Point location){
        this(name,location,trunkDefaultLength);
    }


    /**
     * Elephant Ctor that receives only name and set default location
     * @param name - elephant name.
     */
    public Elephant(String name) {
        this(name, new Point(50,90),trunkDefaultLength);

    }

    /**
     *Set Trunk Length
     * @param length - represent elephant trunk length
     * @return true if the length is valid , otherwise false.
     */
    public boolean setTrunkLength(double length){
        if(length >= min_trungLength && length <= maximum_trunkLength){
            logSetter(this.getName(),"setTrunkLength",length, true);
            this.trunkLength = length;
            return true;
        }
        logSetter(this.getName(),"setTrunkLength",length, false);
        return false;
    }

    public String toString(){
        return super.toString();
    }

    @Override
    public void chew() {
       //TODO
    }
}

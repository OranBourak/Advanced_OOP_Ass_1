/**
 * Giraffe - class that represent Giraffe obj.
 * Extends Chewing_animals
 * Implements IEdible
 * @version : 1
 * @author : Tomer Burman, Oran Bourak
 */

package animals;
import diet.Herbivore;
import mobility.Point;
import privateutil.Chewing_animals;
import utilities.MessageUtility;
import static utilities.MessageUtility.logConstractor;
import static utilities.MessageUtility.logSetter;


public class Turtle extends Chewing_animals {
    private int Age;
    private final static int defaultAge = 1;
    private final static int defaultWeight = 1;
    private final static int maxAge = 500;

    /**
     * Turtle Ctor
     * @param name - turtle name
     * @param location - turtle location
     * @param Age - turtle age
     */
    public Turtle(String name, Point location, int Age){
        super(name,location);
        MessageUtility.logConstractor(this.getClass().getSimpleName(),this.getName());
        this.setWeight(defaultWeight);
        if(!this.setAge(Age))
            setAge(defaultAge);
        this.setDiet(new Herbivore());


    }

    /**
     * Turtle Ctor that receives name and location, set age to default.
     * @param name
     * @param location
     */
    public Turtle(String name, Point location){
        this(name,location,defaultAge);
    }

    /**
     * Turtle Ctor , receives name and set default location and age
     * @param name
     */
    public Turtle(String name){
        this(name,new Point(80, 0 ),defaultAge);

    }

    /**
     * Set Age method
     * @param Age - Age to set
     * @return true if the Age is in range , else false.
     */
    private boolean setAge(int Age) {
        if(Age > 0 && Age <= maxAge){
            this.Age = Age;
            logSetter(this.getName(),"SetAge", Age,true);
            return true;
        }
        logSetter(this.getName(),"SetAge", Age,false);
        return false;
    }

    /**
     * Get Age method
     * @return animal age
     */
    public int getAge() {
        MessageUtility.logGetter(this.getName(),"getAge",Age);
        return Age;
    }

    @Override
    public String toString(){
        return super.toString();
    }

    /**
     * Turtle chew .
     * uses messageUtility.
     */
    @Override
    public void chew() {
        MessageUtility.logSound(this.getName(),"Retracts its head in then eats quietly");
    }



}

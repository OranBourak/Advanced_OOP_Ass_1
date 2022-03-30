package privateutil;
import animals.*;
import mobility.Point;

/**Chewing animals - extends from Animal, represents chewing animals.
 * @version :1
 * @author : Oran Bourak, Tomer Burman
 */
public abstract class Chewing_animals extends Animal{
    public Chewing_animals(String name, Point location){
        super(name,location);
    }


    /**
     * abstract method to chew
     */
    public abstract void chew();
    /**
     * makeSound - makes a chew sound depends on animal.
     */
    @Override
    public void makeSound() {
        this.chew();
    }

}

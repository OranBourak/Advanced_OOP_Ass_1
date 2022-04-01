package animals;
import diet.Carnivore;
import food.*;
import mobility.Point;
import java.util.Random;
import privateutil.Roaring_animals;
import utilities.MessageUtility;

public class Lion extends Roaring_animals {
    private final double default_weight = 408.2;
    private int scarCount ;// how many scars lion has

    /**
     * constructor that receives name and starting location.
     * @param name
     * @param location
     */
    public Lion(String name,Point location){
        super(name,location);
        super.setWeight(default_weight);
        this.setDiet(new Carnivore()); // meat eater
        MessageUtility.logConstractor(this.getClass().getSimpleName(),this.getName());
    }

    /**
     * constructor that recieves only name, setting to default location of (20,0)
     * @param name
     */
    public Lion(String name){

        this(name,new Point(20,0));
    }

    /**
     * adds scarCount by 1.
     * @return true.
     */
    public boolean addScarCount(){
        scarCount += 1;
        return true;
    }

    /**
     * eat - uses Animal class eat, if food is edible, there's a 50% chance to
     * get a scar.
     * @param food
     * @return returns true if edible, false otherwise.
     */
    @Override
    public boolean eat(IEdible food){
            if(super.eat(food)){
            Random rand = new Random();
            int rand_int =  rand.nextInt(2); //generating either 0/1
            if(rand_int == 1)
                addScarCount(); // raising scarCount by
            return true;

             }
        return false;
    }

    /**
     * getScarCount - returns how many scars the lion has
     * @return int
     */
    public int getScarCount(){return scarCount;}


    public void roar(){
        MessageUtility.logSound(this.getName(),"Roars, then stretches and shakes it mane");
    }

    /**
     * toString - uses Animal class toString.
     * @return
     */

    public String toString(){
        return super.toString();
    }

    /**
     * getFoodType
     * @return EFoodType
     */
    public EFoodType getFoodType(){
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.NOTFOOD);
        return EFoodType.NOTFOOD;
    }

}

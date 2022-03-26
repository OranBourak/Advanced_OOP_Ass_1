package animals;
import diet.IDiet;
import food.*;
import mobility.Point;
import java.util.Random;
public class Lion extends Animal implements IDiet{

    private int scarCount ;// how many scars lion has

    /**
     * constructor that recieves name and starting location.
     * @param name
     * @param location
     */
    public Lion(String name,Point location){
        super(name,location);
        super.setWeight(408.2);
    }

    /**
     * constructor that recieves only name, setting to default location of (20,0)
     * @param name
     */
    public Lion(String name){
        this(name,new Point(20,0));
    }


    public boolean setScarCount(int count){
        scarCount += count;
        return true;
    }


    public boolean eat(IEdible food){
        if (canEat(food.getFoodType())) {
            Random rand = new Random();
            int rand_int =  rand.nextInt(2); //generating either 0/1
            if(rand_int == 1)
                setScarCount(rand_int); // raising scarCount by 1
            setWeight(getWeight()*1.1); //raising weight by 10%.
            return true;

        }
        return false;
    }

    public int getScarCount(){return scarCount;}


    public void roar(){}


    public boolean canEat(EFoodType food){
        return food == EFoodType.MEAT;
    }

    public EFoodType getFoodType(){
        return EFoodType.NOTFOOD;
    }

}

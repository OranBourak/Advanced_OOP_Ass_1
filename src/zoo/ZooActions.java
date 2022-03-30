package zoo;
import food.*;
import mobility.*;
import animals.*;


/**
 * ZooActions - Class that represents what are the actions
 * the animals/pants in the zoo can take.
 */
public class ZooActions {
    /**
     * main -
     * @param args
     */
    public static void main(String[] args){

    }

    /**
     * eat - function receives any type of animal, checks which
     * animal it is, checks if it can eat the food received.
     * @param animal animal checked
     * @param food food checked
     * @return returns true if food was received else false.
     */
    public static boolean eat(Object animal,IEdible food){
        //TODO

        return false;
    }

    /**
     * move - recieves any type of animal, checks which animal it is
     * uses checkBoundries to check if the point is in boundries,
     * if so calcs the distance between given animal and point and updates
     * current location of animal
     * @param animal animal checked
     * @param point point to move to
     * @return returns true if movement was possible, false otherwise.
     */
    public static boolean move(Object animal,Point point){
        //TODO


        return false;
    }




}

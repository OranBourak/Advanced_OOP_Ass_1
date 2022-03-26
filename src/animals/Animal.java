package animals;
import diet.IDiet;
import food.IEdible;
import mobility.*;

/**
 * Animal - abstarct class that defines general characteristics for animals.
 * Extends Mobile
 * Implements IEdible
 * @version : 1
 * @author : Tomer Burman, Oran Bourak
 */
public abstract class Animal extends Mobile implements IEdible{
    /**
     * name - name of the animal
     * weight - weight of the animal
     * diet - what the animal may eat
     */
    private String name;
    private double weight;
    private IDiet diet;

    /**
     * Animal constructor
     * @param name
     * @param location coordinate in (x,y) grid.
     */
    Animal(String name,Point location){
        super(location); // base class ctor
        this.setName(name);
    }
    /**
     * setting weight of the animal.
     * @param weight
     * @return true if weight is higher than zero
     */
    public boolean setWeight (double weight){
        if(weight > 0){
            this.weight = weight;
            return true;
        }
        return false;
    }

    public double getWeight(){return this.weight;}

    /**
     * setName - recieves String type, if string is not empty it replaces
     * and returns true, else returns false.
     * @param name - name to change to.
     * @return true if changed, else false.
     */
    public boolean setName(String name){
        if (name.compareTo("") != 0){ //if name recieved is not empty it changes.
            this.name = name;
            return true;
        }
        return false;
    }

    /**
     * abstract method - makes sound.
     */
    public abstract void makeSound();

    //why do we need it if the class is abstract and when we inherit from it we must implement IEdible if not implemented.
    public abstract boolean eat(IEdible food);




}

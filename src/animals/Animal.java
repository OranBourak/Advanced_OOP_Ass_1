/**
 * Animal - abstract class that defines general characteristics for animals.
 * Extends Mobile
 * Implements IEdible
 * @version : 1
 * @author : Tomer Burman, Oran Bourak
 */
package animals;
import diet.Carnivore;
import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import mobility.*;
import utilities.MessageUtility;


public abstract class Animal extends Mobile implements IEdible{
    /**
     * name - name of the animal
     * weight - weight of the animal
     * diet - what the animal may eat
     */
    private String name;
    private double weight;
    private IDiet diet; // Eating appropriate food.



    /**
     * Animal constructor
     * @param name Animal name
     * @param location coordinate in (x,y) grid.
     */
    public Animal(String name,Point location){
        super(location); // base class ctor
        MessageUtility.logConstractor("Animal",name);
        this.setName(name);
    }



    /**
     * setting weight of the animal.
     * @param weight - weight to set.
     * @return true if weight is higher than zero
     */
    protected boolean setWeight (double weight){
        if(weight > 0){
            MessageUtility.logSetter(this.getName(), "setWeight", weight,true);
            this.weight = weight;
            return true;
        }
        MessageUtility.logSetter(this.getName(), "setWeight", weight,false);
        return false;
    }


    /**
     * getWeight - returns weight of the animal, uses MessageUtility.
     * @return double type - weight.
     */
    public double getWeight(){
        MessageUtility.logGetter(this.getName(), "getWeight", this.weight);
        return this.weight;}




    /**
     * setName - recieves String type, if string is not empty it replaces
     * and returns true, else returns false.
     * @param name - name to change to.
     * @return true if changed, else false.
     */
    private boolean setName(String name){
        if (name.compareTo("") != 0){ //if name recieved is not empty it changes.
            this.name = name;
            MessageUtility.logSetter(name, "setName", name,true);
            return true;
        }
        MessageUtility.logSetter(this.getName(), "setName", name,false);
        return false;
    }


    /**
     * getName - uses MessageUtility.
     * @return String type - name.
     */
    public String getName(){
        MessageUtility.logGetter(this.name, "getName", this.name);
        return this.name;
    }



    /**
     * abstract method - makes sound.
     */
    public abstract void makeSound();


    /**
     * Return animal type as food to eat.
     * @return EFoodType
     */
    @Override
    public EFoodType getFoodType(){
        MessageUtility.logGetter(this.getName(), "getFoodType", EFoodType.MEAT);
        return EFoodType.MEAT;
    }


    /**
     * setDiet - setting Diet to a certain animal.
     * @param diet - animal diet type , Carnivore/Herbivore/Omnivore
     * @return true.
     */
    public boolean setDiet(IDiet diet){
        MessageUtility.logSetter(this.getName(), "setDiet", "["+diet.getClass().getSimpleName()+"]",true);
        this.diet = diet;
        return true;
    }


    /**
     * getDiet - returns diet
     * @return IDiet
     */
    public IDiet getDiet(){
        return diet;
    }


    /**
     * eat -
     * @param food - food to feed the animal.
     * @return true if the animal ate, false otherwise
     */
    public boolean eat(IEdible food){
        double weight_gained = diet.eat(this,food);
        if(weight_gained != 0){
            MessageUtility.logBooleanFunction(this.getName(), "eat", food, true);
            this.setWeight(this.getWeight()+weight_gained);
            this.makeSound();
            return true;
        }
        MessageUtility.logBooleanFunction(this.getName(), "eat", food, false);
        return false;
    }

    /**toString - prints in the form of :
     *
     * @return String in the form of :
     * e.g [Lion] : Shimon  NEW
     */
    @Override
    public String toString(){
        return "[" +this.getClass().getSimpleName() + "]" +this.name;
    }

    /**
     * Move method
     * use Mobile move method , update the animal weight with the following formula:
     * Weight- (distance*weight*0.00025).
     * @param other received Point to travel to
     * @return distance that the animal traveled from her last location to new location(POINT)
     */
    @Override
    public double move(Point other){
        double distance = super.move(other) ;
        double w = this.getWeight();
        this.setWeight(w-w*distance*0.00025);
        return distance;
    }

}

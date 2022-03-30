package animals;
import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import mobility.*;
import utilities.MessageUtility;

import javax.print.attribute.standard.DateTimeAtCompleted;

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
    private IDiet diet; // Eating appropriate food.



    /**
     * Animal constructor
     * @param name
     * @param location coordinate in (x,y) grid.
     */
    public Animal(String name,Point location){
        super(location); // base class ctor
        this.setName(name);
        MessageUtility.logConstractor(this.getClass().getSimpleName(), this.getName());
    }



    /**
     * setting weight of the animal.
     * @param weight
     * @return true if weight is higher than zero
     */
    public boolean setWeight (double weight){
        if(weight > 0){
            MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", name,true);
            this.weight = weight;
            return true;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", name,false);
        return false;
    }



    public double getWeight(){
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
        return this.weight;}




    /**
     * setName - recieves String type, if string is not empty it replaces
     * and returns true, else returns false.
     * @param name - name to change to.
     * @return true if changed, else false.
     */
    public boolean setName(String name){
        if (name.compareTo("") != 0){ //if name recieved is not empty it changes.
            MessageUtility.logSetter(this.getClass().getSimpleName(), "setName", name,true);
            this.name = name;
            return true;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setName", name,false);
        return false;
    }



    public String getName(){
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getName", this.name);
        return this.name;
    }



    /**
     * abstract method - makes sound.
     */
    public abstract void makeSound();


    /**
     *
     * @return EFoodType
      */
    @Override
    public EFoodType getFoodType(){
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.MEAT);
        return EFoodType.MEAT;
    }


    /**
     * setDiet - setting Diet to a certain animal.
     * @param diet
     * @return true.
     */
    public boolean setDiet(IDiet diet){
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setDiet", name,true);
        this.diet = diet;
        return true;
    }

    public IDiet getDiet(){
        return diet;
    }


    /**
     * eat -
     * @param food
     * @return true if the animal ate, false otherwise
     */
    public boolean eat(IEdible food){
        double weight_gained = diet.eat(this,food);
        if(weight_gained != 0){
            this.setWeight(this.getWeight()+weight_gained);
            this.makeSound();
            return true;
        }
        return false;
    }

    public String toString(){
        return this.getName() + ", total distance: " + this.getTotalDistance() + ", weight: " + this.getWeight()+ "," +this.getClass().getSimpleName();
    }






}

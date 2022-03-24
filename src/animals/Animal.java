package animals;
import diet.IDiet;
import food.IEdible;
import mobility.*;

public abstract class Animal extends Mobile implements IEdible{
    private String name;
    private double weight;
    private IDiet diet;

    Animal(String name,Point location){
        super(location); // base class ctor
        this.name = name;
    }

    public boolean setWeight (double weight){
        if(weight > 0){
            this.weight = weight;
            return true;
        }
        return false;
    }

    public double getWeight(){return this.weight;}

    public abstract void makeSound();

    //why do we need it if the class is abstract and when we inherit from it we must implement IEdible if not implemented.
    public abstract boolean eat(IEdible food);


}

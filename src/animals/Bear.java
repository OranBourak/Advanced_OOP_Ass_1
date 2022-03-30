package animals;

import diet.Carnivore;
import diet.Omnivore;
import mobility.Point;
import privateutil.Roaring_animals;

import java.util.Arrays;

import static utilities.MessageUtility.logGetter;
import static utilities.MessageUtility.logSetter;

public class Bear extends Roaring_animals {

    private final static double defaultWeight = 308.2;

    private String furColor;
    private final String[] colors_array = {"BLACK","WHITE","GRAY"}; // color choices.

    public Bear(String name,Point location){
        super(name,location);
        this.setWeight(defaultWeight);

        this.setDiet(new Omnivore()); // meat eater
    }
    /**
     * Ctor that receives only String for name initiates base first.
     *
     * @param name - bear name
     */
    public Bear(String name) {
        this(name, new Point(100,5));
    }

    /**
     * setFurColor method.
     * @param furColor - bear fur color
     * @return true if the fur color is in the fur color list else false.
     */
    public boolean setFurColor(String furColor){
        for (String s : colors_array)
            if (s.equals(furColor)) {
                this.furColor = furColor;
                logSetter(this.getName(), "setFurColor", furColor, true);
                return true;
            }
        logSetter(this.getName(), "setFurColor", furColor, false);
        return false;
    }

    /**
     * getFutColor
     * @return String - represent the bear fur color
     */
    public String getFurColor(){
        logGetter(this.getName(),"getFurColor",this.furColor);
        return this.furColor;
    }

    public String toString(){
        return super.toString();
    }

    @Override
    public void roar() {
        //TODO
    }

}

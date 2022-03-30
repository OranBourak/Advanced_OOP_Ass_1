package animals;

import diet.Carnivore;
import mobility.Point;
import privateutil.Roaring_animals;

import java.util.Arrays;

public class Bear extends Roaring_animals {

    private String furColor;
    private final String colors_array[] = {"BLACK","WHITE","GRAY"}; // color choices.

    public Bear(String name,Point location){
        super(name,location);
        this.setWeight(308.2);

        this.setDiet(new Carnivore()); // meat eater
    }
    /**
     * ctor that recieves only String for name initiates base first.
     *
     * @param name
     */
    public Bear(String name) {
        this(name, new Point(100,5));
    }

    public boolean setFurColor(String furcolor){
        for(int i=0;i<3;i++)
            if(colors_array[i].equals(furcolor)) {
                this.furColor = furcolor;
                return true;
            }
        return false;
    }

    @Override
    public void roar() {
        //TODO
    }

}

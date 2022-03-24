package diet;
import food.EFoodType;
import food.IEdible;

public interface IDiet {
    boolean canEat(EFoodType food);
    double eat(Animal animal, IEdible food);
}


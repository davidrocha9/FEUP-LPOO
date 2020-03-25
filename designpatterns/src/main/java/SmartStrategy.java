import javax.naming.CompositeName;
import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {
    private List<StringRecipe> recipes;
    private List<StringDrink> drinks;

    public SmartStrategy(){
        this.recipes = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if (bar.isHappyHour())
            recipe.mix(drink);
        else {
            recipes.add(recipe);
            drinks.add(drink);
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        for (int x = 0; x < recipes.size(); x++){
            recipes.get(x).mix(drinks.get(x));
        }
    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}

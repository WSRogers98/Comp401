package a4jedi;

public class AvocadoPortion extends IngredientPortionImpl {
private static Ingredient ingredient = new Avocado();
public AvocadoPortion(double amount) {
	super(ingredient, amount);
	if (amount <0)
		throw new RuntimeException("must be greater than zero");
}
	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if(other == null)
			return  this;
		if (!this.getIngredient().equals(other.getIngredient()))
			throw new RuntimeException("Ingredients are not equal");
		
			return new AvocadoPortion(this.getAmount() + other.getAmount());
	}
}
	

package a4jedi;

public class TunaPortion extends IngredientPortionImpl {
private static Ingredient ingredient = new Tuna();
public TunaPortion(double amount) {
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
		
			return new TunaPortion(this.getAmount() + other.getAmount());
	}
}
	

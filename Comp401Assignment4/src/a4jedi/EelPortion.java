package a4jedi;

public class EelPortion extends IngredientPortionImpl {
private static Ingredient ingredient = new Eel();
public EelPortion(double amount) {
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
		
			return new EelPortion(this.getAmount() + other.getAmount());
	}
}
	

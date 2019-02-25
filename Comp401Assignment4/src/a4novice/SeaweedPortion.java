package a4novice;

public class SeaweedPortion extends IngredientPortionImpl {
private static Ingredient ingredient = new Seaweed();
public SeaweedPortion(double amount) {
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
		
			return new SeaweedPortion(this.getAmount() + other.getAmount());
	}
}
	

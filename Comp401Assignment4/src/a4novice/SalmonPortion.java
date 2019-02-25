package a4novice;

public class SalmonPortion extends IngredientPortionImpl {
private static Ingredient ingredient = new Salmon();
public SalmonPortion(double amount) {
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
		
			return new SalmonPortion(this.getAmount() + other.getAmount());
	}
}
	

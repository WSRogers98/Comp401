package a4novice;

public abstract class IngredientPortionImpl implements IngredientPortion {

	private Ingredient decIngredient;
	
	private double decAmount;
	

	public IngredientPortionImpl(Ingredient ingredient, double amount) {
	this.decIngredient = ingredient;
	
	this.decAmount = amount;
	
	}
	@Override
	public Ingredient getIngredient() {
		return decIngredient;
	}
	
	@Override
	public double getAmount() {
	return decAmount;
	}
	@Override
	public String getName() {
		return decIngredient.getName();
	}
	@Override
	public double getCalories() {
		return (decIngredient.getCaloriesPerOunce() * decAmount);
	}
	@Override
	public double getCost() {
		return (decIngredient.getPricePerOunce() * decAmount);
	}
	@Override
	public boolean getIsVegetarian() {
		return decIngredient.getIsVegetarian();
	}
	@Override
	public boolean getIsRice() {
		return decIngredient.getIsRice();
	}
	@Override
	public boolean getIsShellfish() {
		return decIngredient.getIsShellfish();
	}
}

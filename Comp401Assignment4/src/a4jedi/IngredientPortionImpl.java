package a4jedi;

public abstract class IngredientPortionImpl implements IngredientPortion {

	private Ingredient decIngredient;
	
	private double decAmount;
	

	public IngredientPortionImpl(Ingredient ingredient, double amount) {
	this.decIngredient = ingredient;
	
	this.decAmount = amount;
	
	}
	@Override
	public Ingredient getIngredient() {
		return this.decIngredient;
	}
	
	@Override
	public double getAmount() {
	return this.decAmount;
	}
	@Override
	public String getName() {
		return this.decIngredient.getName();
	}
	@Override
	public double getCalories() {
		return (this.decIngredient.getCaloriesPerOunce() * this.decAmount);
	}
	@Override
	public double getCost() {
		return (this.decIngredient.getPricePerOunce() * this.decAmount);
	}
	@Override
	public boolean getIsVegetarian() {
		return this.decIngredient.getIsVegetarian();
	}
	@Override
	public boolean getIsRice() {
		return this.decIngredient.getIsRice();
	}
	@Override
	public boolean getIsShellfish() {
		return this.decIngredient.getIsShellfish();
	}
	@Override
	public double setAmount(double d) {
		return this.decAmount = d;
	}
}

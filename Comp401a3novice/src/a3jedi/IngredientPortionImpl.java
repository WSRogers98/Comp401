package a3jedi;

public class IngredientPortionImpl implements IngredientPortion {
	private Ingredient decIng;
	private double decAmount;
	
	
	public IngredientPortionImpl(Ingredient ing, double amount) {
		if( ing.equals(null) || amount < 0)
			throw new RuntimeException("Invalid Input");
		else
			this.decIng = ing;
			this.decAmount = amount;
		}
	public Ingredient getIngredient() {
		return this.decIng;
	}
	public double getAmount() {
		return this.decAmount;
	}
	public String getName() {
		return this.decIng.getName();
	}
	public boolean getIsVegetarian() {
		return this.decIng.getIsVegetarian();
	}
	public double getCalories() {
		return  decIng.getCaloriesPerOunce() * decAmount;
	}
	public double getCost() {
		return ((this.decIng.getCaloriesPerDollar() * decAmount) /100);
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		if (other.equals(null)) {
			return this;
		}
		if (other.getIngredient() != this.getIngredient()) {
			throw new NullPointerException();
		}
		return new IngredientPortionImpl(other.getIngredient(), this.decAmount + getAmount());
	}
	
}

/**
 * 
 */
package a4jedi;

/**
 * @author williamsrogers
 *
 */
public abstract class IngredientImpl implements Ingredient {

private String decName;
//private double decAmount;
//private double decCalories;
//private double decCost;
private boolean isVegetarian;
private boolean isRice;
private boolean isShellfish;
private int decCalPerOz;
private double decPricePerOz;


public IngredientImpl(String name, double PricePOz, int caloriesPOz,boolean vegetarian, boolean rice, boolean shellfish) {
	this.decName = name;
//	this.decAmount = amount;
//	this.decCalories = calories;
//	this.decCost = cost;
	this.decCalPerOz = caloriesPOz;
	this.decPricePerOz = PricePOz;
	this.isVegetarian = vegetarian;
	this.isRice = rice;
	this.isShellfish = shellfish;
}
	/* (non-Javadoc)
	 * @see a4novice.Ingredient#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return decName;
	}

	/* (non-Javadoc)
	 * @see a4novice.Ingredient#getCaloriesPerDollar()
	 */
	@Override
	public double getCaloriesPerDollar() {
		// TODO Auto-generated method stub
		return (decCalPerOz/decPricePerOz);
	}

	/* (non-Javadoc)
	 * @see a4novice.Ingredient#getCaloriesPerOunce()
	 */
	@Override
	public int getCaloriesPerOunce() {
		// TODO Auto-generated method stub
		return decCalPerOz;
	}

	/* (non-Javadoc)
	 * @see a4novice.Ingredient#getPricePerOunce()
	 */
	@Override
	public double getPricePerOunce() {
		// TODO Auto-generated method stub
		return decPricePerOz;
	}

	/* (non-Javadoc)
	 * @see a4novice.Ingredient#equals(a4novice.Ingredient)
	 */
	@Override
public boolean equals(Ingredient other) {
	if(!this.getName().equals(other.getName()))
	return false;
	
	return true;
	
}
	/* (non-Javadoc)
	 * @see a4novice.Ingredient#getIsVegetarian()
	 */
	@Override
	public boolean getIsVegetarian() {
		// TODO Auto-generated method stub
		return isVegetarian;
	}

	/* (non-Javadoc)
	 * @see a4novice.Ingredient#getIsRice()
	 */
	@Override
	public boolean getIsRice() {
		// TODO Auto-generated method stub
		return isRice;
	}

	/* (non-Javadoc)
	 * @see a4novice.Ingredient#getIsShellfish()
	 */
	@Override
	public boolean getIsShellfish() {
		// TODO Auto-generated method stub
		return isShellfish;
	}

}

package a3adept;

public class IngredientImpl implements Ingredient {
private String decName;
private double decPrice;
private int decCalories;
private boolean decIsVegetarian;

public IngredientImpl(String name, double price, int calories, boolean isVegetarian) {
if( name.equals(null) || price < 0 || calories < 0)
	throw new RuntimeException("Invalid Input");
else
	this.decName = name;
	this.decPrice = price;
	this.decCalories = calories;
	this.decIsVegetarian = isVegetarian;
}
public String getName() {
	return this.decName;
}
public double getPricePerOunce() {
	return this.decPrice;
}
public int getCaloriesPerOunce() {
	return  this.decCalories;
}
public double getCaloriesPerDollar() {
	return (this.decCalories / this.decPrice);
}
public boolean getIsVegetarian() {
	return this.decIsVegetarian;
}


}
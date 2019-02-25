package a2jedi;

public class Ingredient {

	private String ingredient;
	private double price;
	private  boolean veggie;
	private int calories;	
public Ingredient( String ing, double p ,Boolean veg, int cal){
 setIngredient(ing);
 setPrice(p);
 setVeggie(veg);
 setCalories(cal);
}
public String getIngredient() {
	return this.ingredient;
}
public void setIngredient(String ingredient) {
	this.ingredient = ingredient;
}
public double getPrice() {
	return this.price;
}
public void setPrice(double price) {
	this.price = price;
}
public boolean getVeggie() {
	return this.veggie;
}
public void setVeggie(boolean veggie) {
	this.veggie = veggie;
}
public int getCalories() {
	return this.calories;
}
public void setCalories(int calories) {
	this.calories = calories;
}
}


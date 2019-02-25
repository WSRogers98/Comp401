package a2jedi;

import a2adept.Ingredient;

public class menu {
	private String menuItem;
	private  Ingredient[] ingredients;	
	private double[] ounces;
		
public menu( String items, Ingredient[] ing, double[] oz){
 setMenuItem(items);
 setIngredients(ing);
 setOunces(oz);
}
public String getMenuItem() {
	return this.menuItem;
}
public void setMenuItem(String menuItem) {
	this.menuItem = menuItem;
}
public Ingredient[] getIngredients() {
	return this.ingredients;
}
public void setIngredients(Ingredient[] ingredients) {
	this.ingredients = ingredients;
}

public double[] getOunces() {
	return this.ounces;
}
public void setOunces(double[] ounces) {
	this.ounces = ounces;
}
}


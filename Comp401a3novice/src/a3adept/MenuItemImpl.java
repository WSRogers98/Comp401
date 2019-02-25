package a3adept;

public class MenuItemImpl {
private String decName;
private IngredientPortion[] decIngredients;
	public MenuItemImpl(String name, IngredientPortion[] ingredients)  {
		for( int i = 0; i < ingredients.length; i ++) {
		if( name.equals(null) || ingredients.equals(null) || ingredients.length <= 0 || ingredients[i] == null)
			throw new RuntimeException("Invalid Input");
		else
			this.decName = name;
			this.decIngredients = ingredients.clone();
	}
	}
	public String getName() {
		return this.decName;
	}
	public IngredientPortion[] getIngredients() {
		return this.decIngredients.clone();
	}
	public int getCalories() {
		int calories = 0;
		for( int i = 0; i < decIngredients.length; i ++) {
		calories += this.decIngredients[i].getCalories();
		}
		return ((int) (calories +.5));
	}
	public double getCost() {
		double cost = 0;
		for( int i = 0; i < decIngredients.length; i ++) {
			cost += this.decIngredients[i].getCost();
		}
		return (((int) ((cost* 100.0)+0.5))/100.0);
	}
	public boolean getIsVegetarian() {
		boolean veggie = true;
		for( int i = 0; i < decIngredients.length; i ++) {
		if( !(this.decIngredients[i].getIsVegetarian()))
			return veggie = false;
			
		}	
		return veggie;
		}
	}


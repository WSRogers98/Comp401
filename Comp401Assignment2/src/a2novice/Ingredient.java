package a2novice;

public class Ingredient {
	
			public String ingredient;
			public double price;
			public  boolean veggie;
			public  int calories;	
		public Ingredient( String ingredient, double price ,Boolean veggie, int calories){
		 setIngredient(ingredient);
		 setPrice(price);
		 setVeggie(veggie);
		 setCalories(calories);
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

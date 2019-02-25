package a3jedi;

import java.util.Scanner;

public class A3jedi {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int ingredientLoop = s.nextInt();
		String test = "";
		Ingredient arr[] = new Ingredient[ingredientLoop];
		for( int i = 0; i < ingredientLoop; i++ ) {
			 String ingredient = s.next();
			 double price = s.nextDouble();
			 boolean veggie = s.nextBoolean();
			 int calories = s.nextInt();
			arr[i] = new IngredientImpl(ingredient, price, calories, veggie);
		
		}
		int menuItemLoop = s.nextInt();
		MenuItemImpl menuItemArr[] = new MenuItemImpl[menuItemLoop];
		IngredientPortion portionArr[] = new IngredientPortion[menuItemLoop];
		for( int j = 0; j < menuItemLoop; j++) {
			String itemName = s.next();
			int numIngr = s.nextInt();
			Ingredient ingredients[] = new Ingredient[numIngr];
			double ounces[] = new double[numIngr];
			for( int k = 0; k < numIngr; k++) {
				test = s.next();
				ounces[k] = s.nextDouble();
			
			for( int l = 0; l< ingredientLoop; l++) {
				if(arr[l].getName().equals(test))
				ingredients[k] = arr[l];
			}
			for( int m = 0; m< ingredientLoop; m++) {
				if(arr[m].getName().equals(test))
				ingredients[k] = portionArr[m].getIngredient();
			}
			
			portionArr[k] = new IngredientPortionImpl(portionArr[k].getIngredient(), ounces[k]);
			}
			
			menuItemArr[j] = new MenuItemImpl(itemName, portionArr);
			
		}
		int tester = 0;
		while (s.hasNext() && s.next()!= "EndOrder") {
			tester += 1;
		}
//			String orderarray[] = new String[tester];
//			for( int i = 0; i < orderarray.length; i++) {
//				orderarray[i] = s.next();
//			}
//			for( int l = 0; l< ingredientLoop; l++) {
//				if(arr[l].getName().equals(test))
//				ingredients[k] = arr[l];
//			}
		System.out.println("The order will require: ");
		for( int i = 0; i < arr.length; i++) {
			double ingSum = 0;
			System.out.println("ounces of" + arr[i].getName());
		}
	}
	public static void Order(String order) {
		
	}
}


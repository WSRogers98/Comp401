package a4adept;

public class Roll implements Sushi{
private String decName;
private IngredientPortion[] decRollIngredients;
	public Roll( String name, IngredientPortion[] roll_ingredients) {
		if(roll_ingredients == null)
			throw new RuntimeException("can't be null");
		if(name == null)
			throw new RuntimeException("can't be null");
		for(int i = 0; i > roll_ingredients.length; i++) {
			if(roll_ingredients[i] == null)
				throw new RuntimeException("can't be null");
		}
		this.decName = name;
		this.decRollIngredients = roll_ingredients.clone();
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.decName;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		// TODO Auto-generated method stub
		return decRollIngredients;
	}

	@Override
	public int getCalories() {
		IngredientPortion test[] = decRollIngredients;
		int calTest = 0;
		for( int i = 0; i < test.length; i++) {
			calTest += (test[i].getCalories() * test[i].getAmount());
			
		}
		calTest = (int)Math.round(calTest);
		return calTest;
	}

	@Override
	public double getCost() {
		IngredientPortion test[] = decRollIngredients;
		double costTest = 0.0;
		for( int i = 0; i < test.length; i++) {
			costTest += (test[i].getCost()) ;
			
		}
		costTest = (int) ((costTest * 100.0) + 0.5);
		costTest = costTest /100.0;
		return costTest;
	}

	@Override
	public boolean getHasRice() {
		boolean riceTest = false;
		IngredientPortion test[] = decRollIngredients;
		for( int i =0; i < test.length; i ++) {
			if( test[i].getIsRice() == true) {
			riceTest = true;
			return riceTest;
			}
		}
		return riceTest;
	}

	@Override
	public boolean getHasShellfish() {
		boolean shellfishTest = false;
		IngredientPortion test[] = decRollIngredients;
		for( int i =0; i < test.length; i ++) {
			if( test[i].getIsShellfish() == true) {
			shellfishTest = true;
			return shellfishTest;
			}
		}
		return shellfishTest;
	}

	@Override
	public boolean getIsVegetarian() {
		
	
		int testMarker = 0;
		IngredientPortion test[] = decRollIngredients;
		for( int i =0; i < test.length; i ++) {
			if( test[i].getIsVegetarian() == true) {
			testMarker += 1;
			}
			if(test.length == testMarker)
				return true;
		}
		return false;
	}

}

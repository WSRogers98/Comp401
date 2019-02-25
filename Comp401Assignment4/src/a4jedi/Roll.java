package a4jedi;

import java.util.ArrayList;
import java.util.Arrays;



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
		setName(name);
		setIngredients(roll_ingredients.clone());
		checkDupli();
		checkSeaweed();
		
	}
	
	private void setIngredients(IngredientPortion[] clone) {
		// TODO Auto-generated method stub
		this.decRollIngredients = clone;
	}
	
	public void setName(String name) {
		 this.decName = name;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.decName;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		// TODO Auto-generated method stub
		return this.decRollIngredients;
	}

	@Override
	public int getCalories() {
		IngredientPortion[] test = getIngredients();
		double calTest = 0;
		for( int i = 0; i < test.length; i++) {
			calTest += (test[i].getCalories());
			
			
		}
		return (int) Math.round(calTest);		
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
	private void checkDupli() {
		IngredientPortion test[] = decRollIngredients;
		ArrayList<IngredientPortion> check = new ArrayList<IngredientPortion>();
		boolean tester;
		for( int i = 0; i < test.length ; i++) {
			tester = false;
			for(int j = 0; j<check.size(); j++) {
				
				if(check.get(j).getIngredient().equals(test[i].getIngredient())) {
						
				check.set(j, check.get(j).combine(test[i]));
				tester= true;
				}
							
			}
			if(check.isEmpty() || !tester) {
				check.add(test[i]);
			}
		}
//		for( int k = 0; k < check.size(); k++) {
//			
//			for( int l = 0; l < test.length; l++) {
//				if(check.get(k).getIngredient() == test[l] || test[l] == null)					tester = false;
//			}
//			if (tester == true)
//				check.add(test[k]);		
	
		
		IngredientPortion[] test3 = new IngredientPortion[check.size()];
		test3 = check.toArray(test3);
		setIngredients(test3.clone());
	}
	private void checkSeaweed(){
		IngredientPortion test[] = getIngredients();
		boolean tester = false;
			IngredientPortion newTest[];				
		for(int i = 0; i < test.length; i++) {
			if(test[i].getIngredient().equals(new Seaweed())) {
				tester = true;
				if(test[i].getAmount() < 0.1) {
					test[i].setAmount(0.1);
				}
			}
					
		}
		if(!tester) {
			newTest = Arrays.copyOf(test, test.length +1 );
			newTest[newTest.length -1] = new SeaweedPortion(0.1);
			this.setIngredients(newTest.clone());
		}
		else {
			this.setIngredients(test.clone());
		}
		
	}
}

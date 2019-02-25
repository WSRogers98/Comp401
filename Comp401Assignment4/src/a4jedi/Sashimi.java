package a4jedi;

public class Sashimi implements Sushi{

	public enum SashimiType { TUNA, SALMON, EEL, CRAB, SHRIMP}
	private SashimiType decType;
	public Sashimi (SashimiType type){
		this.decType = type;
	}
	public SashimiType getType() {
	return this.decType;
	}
	public double getAmount() {
		return .75;
	}
	
	@Override
	public String getName() {
		IngredientPortion test[] = new IngredientPortion[1];
		
		switch(this.getType()) {
		case TUNA:
			test[0] = new TunaPortion(this.getAmount());
			return (test[0].getName() + " sashimi");
		case SALMON:
			test[0] = new SalmonPortion(this.getAmount());
			return (test[0].getName() + " sashimi");
		case EEL:
			test[0] = new EelPortion(this.getAmount());
			return (test[0].getName() + " sashimi");
		case CRAB:
			test[0] = new CrabPortion(this.getAmount());
			return (test[0].getName() + " sashimi");
		case SHRIMP:
			test[0] = new ShrimpPortion(this.getAmount());
			return (test[0].getName() + " sashimi");
			
		}
		
		return (test[0].getName() + " sashimi");
	}
	
	@Override
	public IngredientPortion[] getIngredients() {
		IngredientPortion test[] = new IngredientPortion[1];
		// I hope we are allowed to use switches I do not remember if we learned them yet but I hope so
		switch(this.getType()) {
		case TUNA:
			test[0] = new TunaPortion(this.getAmount());
			return test;
		case SALMON:
			test[0] = new SalmonPortion(this.getAmount());
			return test;
		case EEL:
			test[0] = new EelPortion(this.getAmount());
			return test;
		case CRAB:
			test[0] = new CrabPortion(this.getAmount());
			return test;
		case SHRIMP:
			test[0] = new ShrimpPortion(this.getAmount());
			return test;
			
		}
		
		return test;
	}
	@Override
	public int getCalories() {
		IngredientPortion test[] = new IngredientPortion[1];
		
		switch(this.getType()) {
		case TUNA:
			test[0] = new TunaPortion(this.getAmount());
			return (int)Math.round(test[0].getCalories());
		case SALMON:
			test[0] = new SalmonPortion(this.getAmount());
			return (int)Math.round(test[0].getCalories());
		case EEL:
			test[0] = new EelPortion(this.getAmount());
			return (int)Math.round(test[0].getCalories());
		case CRAB:
			test[0] = new CrabPortion(this.getAmount());
			return (int)Math.round(test[0].getCalories());
		case SHRIMP:
			test[0] = new ShrimpPortion(this.getAmount());
			return (int)Math.round(test[0].getCalories());
			
		}
		
		return (int)Math.round(test[0].getCalories());
	}
	@Override
	public double getCost() {
		IngredientPortion test[] = new IngredientPortion[1];
		
		switch(this.getType()) {
		case TUNA:
			test[0] = new TunaPortion(this.getAmount());
			return Math.round(((int)(test[0].getCost() * this.getAmount()* 100 +.5))/100);
		case SALMON:
			test[0] = new SalmonPortion(this.getAmount());
			return Math.round(((int)(test[0].getCost() * this.getAmount()* 100 +.5))/100);
		case EEL:
			test[0] = new EelPortion(this.getAmount());
			return Math.round(((int)(test[0].getCost() * this.getAmount()* 100 +.5))/100);
		case CRAB:
			test[0] = new CrabPortion(this.getAmount());
			return Math.round(((int)(test[0].getCost() * this.getAmount()* 100 +.5))/100);
		case SHRIMP:
			test[0] = new ShrimpPortion(this.getAmount());
			return Math.round(((int)(test[0].getCost() * this.getAmount()* 100 +.5))/100);
			
		}
		
		return Math.round(((int)(test[0].getCost() * this.getAmount()* 100 +.5))/100);
	}
	@Override
	public boolean getHasRice() {
		IngredientPortion test[] = new IngredientPortion[1];
	
		switch(this.getType()) {
		case TUNA:
			test[0] = new TunaPortion(this.getAmount());
			return test[0].getIsRice();
		case SALMON:
			test[0] = new SalmonPortion(this.getAmount());
			return test[0].getIsRice();
		case EEL:
			test[0] = new EelPortion(this.getAmount());
			return test[0].getIsRice();
		case CRAB:
			test[0] = new CrabPortion(this.getAmount());
			return test[0].getIsRice();
		case SHRIMP:
			test[0] = new ShrimpPortion(this.getAmount());
			return test[0].getIsRice();
			
		}
		
		return test[0].getIsRice();
	}
	@Override
	public boolean getHasShellfish() {
		IngredientPortion test[] = new IngredientPortion[1];
		
		switch(this.getType()) {
		case TUNA:
			test[0] = new TunaPortion(this.getAmount());
			return test[0].getIsShellfish();
		case SALMON:
			test[0] = new SalmonPortion(this.getAmount());
			return test[0].getIsShellfish();
		case EEL:
			test[0] = new EelPortion(this.getAmount());
			return test[0].getIsShellfish();
		case CRAB:
			test[0] = new CrabPortion(this.getAmount());
			return test[0].getIsShellfish();
		case SHRIMP:
			test[0] = new ShrimpPortion(this.getAmount());
			return test[0].getIsShellfish();
			
		}
		
		return test[0].getIsShellfish();
	}
	@Override
	public boolean getIsVegetarian() {
		IngredientPortion test[] = new IngredientPortion[1];
		
		switch(this.getType()) {
		case TUNA:
			test[0] = new TunaPortion(this.getAmount());
			return test[0].getIsVegetarian();
		case SALMON:
			test[0] = new SalmonPortion(this.getAmount());
			return test[0].getIsVegetarian();
		case EEL:
			test[0] = new EelPortion(this.getAmount());
			return test[0].getIsVegetarian();
		case CRAB:
			test[0] = new CrabPortion(this.getAmount());
			return test[0].getIsVegetarian();
		case SHRIMP:
			test[0] = new ShrimpPortion(this.getAmount());
			return test[0].getIsVegetarian();
			
		}
		
		return test[0].getIsVegetarian();
	
	}
}

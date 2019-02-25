package a4adept;

public class Nigiri implements Sushi{

	public enum NigiriType { TUNA, SALMON, EEL, CRAB, SHRIMP}
	private NigiriType decType;
	public Nigiri (NigiriType type){
		this.decType = type;
	}
	public NigiriType getType() {
	return this.decType;
	}
	public double getAmount() {
		return .75;
	}
	public double getRiceAmount() {
		return .5;
	}
	
	@Override
	public String getName() {
		IngredientPortion test[] = new IngredientPortion[1];
		
		switch(this.getType()) {
		case TUNA:
			test[0] = new TunaPortion(this.getAmount());
			return (test[0].getName() + " nigiri");
		case SALMON:
			test[0] = new SalmonPortion(this.getAmount());
			return (test[0].getName() + " nigiri");
		case EEL:
			test[0] = new EelPortion(this.getAmount());
			return (test[0].getName() + " nigiri");
		case CRAB:
			test[0] = new CrabPortion(this.getAmount());
			return (test[0].getName() + " nigiri");
		case SHRIMP:
			test[0] = new ShrimpPortion(this.getAmount());
			return (test[0].getName() + " nigiri");
			
		}
		
		return (test[0].getName() + " nigiri");
	}
	
	@Override
	public IngredientPortion[] getIngredients() {
		IngredientPortion test[] = new IngredientPortion[2];
		// I hope we are allowed to use switches I do not remember if we learned them yet but I hope so
		switch(this.getType()) {
		case TUNA:
			test[0] = new TunaPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			return test;
		case SALMON:
			test[0] = new SalmonPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			return test;
		case EEL:
			test[0] = new EelPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			return test;
		case CRAB:
			test[0] = new CrabPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			return test;
		case SHRIMP:
			test[0] = new ShrimpPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			return test;
			
		}
		
		return test;
	}
	@Override
	public int getCalories() {
		IngredientPortion test[] = new IngredientPortion[2];
		
		switch(this.getType()) {
		case TUNA:
			test[0] = new TunaPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			return (int)Math.round(test[0].getCalories() + test[1].getCalories());
		case SALMON:
			test[0] = new SalmonPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			return (int)Math.round(test[0].getCalories() + test[1].getCalories());
		case EEL:
			test[0] = new EelPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			return (int)Math.round(test[0].getCalories() + test[1].getCalories());
		case CRAB:
			test[0] = new CrabPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			return (int)Math.round(test[0].getCalories() + test[1].getCalories());
		case SHRIMP:
			test[0] = new ShrimpPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			return (int)Math.round(test[0].getCalories() + test[1].getCalories());
			
		}
		
		return (int)Math.round(test[0].getCalories() + test[1].getCalories());
	}
	@Override
	public double getCost() {
		IngredientPortion test[] = new IngredientPortion[2];
		double proxy = 0;
		switch(this.getType()) {
		case TUNA:
			test[0] = new TunaPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			proxy = (test[0].getCost() * this.getAmount()) +(test[1].getCost() * this.getRiceAmount());
			return Math.round(((int)proxy *100 +.5)/100);
		case SALMON:
			test[0] = new SalmonPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			proxy = (test[0].getCost() * this.getAmount()) +(test[1].getCost() * this.getRiceAmount());
			return Math.round(((int)proxy *100 +.5)/100);
		case EEL:
			test[0] = new EelPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			proxy = (test[0].getCost() * this.getAmount()) +(test[1].getCost() * this.getRiceAmount());
			return Math.round(((int)proxy *100 +.5)/100);
		case CRAB:
			test[0] = new CrabPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			proxy = (test[0].getCost() * this.getAmount()) +(test[1].getCost() * this.getRiceAmount());
			return Math.round(((int)proxy *100 +.5)/100);
		case SHRIMP:
			test[0] = new ShrimpPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			proxy = (test[0].getCost() * this.getAmount()) +(test[1].getCost() * this.getRiceAmount());
			return Math.round(((int)proxy *100 +.5)/100);
		}
		
		proxy = (test[0].getCost() * this.getAmount()) +(test[1].getCost() * this.getRiceAmount());
		return Math.round(((int)proxy *100 +.5)/100);
	}
	@Override
	public boolean getHasRice() {
		IngredientPortion test[] = new IngredientPortion[2];
		boolean temp = true;
		
		switch(this.getType()) {
		case TUNA:
			test[0] = new TunaPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			if(test[0].getIsRice() == true || test[1].getIsRice() == true)
				return temp;
			else temp = false;
			return temp;
		case SALMON:
			test[0] = new SalmonPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			if(test[0].getIsRice() == true || test[1].getIsRice() == true)
				temp = true;
			else temp = false;
			return temp;
		case EEL:
			test[0] = new EelPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			if(test[0].getIsRice() == true || test[1].getIsRice() == true)
				return temp;
			else temp = false;
			return temp;
		case CRAB:
			test[0] = new CrabPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			if(test[0].getIsRice() == true || test[1].getIsRice() == true)
				return temp;
			else temp = false;
			return temp;
		case SHRIMP:
			test[0] = new ShrimpPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			if(test[0].getIsRice() == true || test[1].getIsRice() == true)
				return temp;
			else temp = false;
			return temp;
			
		}
		
		return temp;
	}
	@Override
	public boolean getHasShellfish() {
		IngredientPortion test[] = new IngredientPortion[2];
		boolean temp = true;
		
		switch(this.getType()) {
		case TUNA:
			test[0] = new TunaPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			if(!test[0].getIsShellfish() == true || !test[1].getIsShellfish() == true)
				temp = false;
			return temp;
		case SALMON:
			test[0] = new SalmonPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			if(!test[0].getIsShellfish() == true || !test[1].getIsShellfish() == true)
				temp = false;
			return temp;
		case EEL:
			test[0] = new EelPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			if(!test[0].getIsShellfish() == true || !test[1].getIsShellfish() == true)
				temp = false;
			return temp;
		case CRAB:
			test[0] = new CrabPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			if(!test[0].getIsShellfish() == true || !test[1].getIsShellfish() == true)
				temp = false;
			return temp;
		case SHRIMP:
			test[0] = new ShrimpPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			if(!test[0].getIsShellfish() == true || !test[1].getIsShellfish() == true)
				temp = false;
			return temp;
			
		}
		
		return temp;
	}
	
	@Override
	public boolean getIsVegetarian() {
		IngredientPortion test[] = new IngredientPortion[2];
		boolean temp = true;
		
		switch(this.getType()) {
		case TUNA:
			test[0] = new TunaPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			if(test[0].getIsVegetarian() == false || test[1].getIsVegetarian() == false)
				temp = false;
			
			return temp;
			
		case SALMON:
			test[0] = new SalmonPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			if(test[0].getIsVegetarian() == false || test[1].getIsVegetarian() == false)
				temp = false;
			return temp;
		case EEL:
			test[0] = new EelPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			if(test[0].getIsVegetarian() == false || test[1].getIsVegetarian() == false)
				temp = false;
			return temp;
		case CRAB:
			test[0] = new CrabPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			if(test[0].getIsVegetarian() == false || test[1].getIsVegetarian() == false)
				temp = false;
			return temp;
		case SHRIMP:
			test[0] = new ShrimpPortion(this.getAmount());
			test[1] = new RicePortion(this.getRiceAmount());
			if(test[0].getIsVegetarian() == false || test[1].getIsVegetarian() == false)
				temp = false;
			return temp;
			
		}
		
		return temp;
	}
}

package a8jedi;

import java.util.Observable;

import java.util.Observer;
import a8jedi.PlateEvent.EventType;
import comp401.sushi.IngredientPortion;
import comp401.sushi.Plate;
import comp401.sushi.Sushi;

public class SpoilageCollector implements Observer {

	private Belt decBelt;
	private double totalCount;
	private double seafoodCount;
	private double shellfishCount;
	private double totalCost;

	public SpoilageCollector(Belt belt) {
		this.decBelt = belt;
		if (this.decBelt == null) {
			throw new IllegalArgumentException();
		}
		belt.addObserver(this);
		
	}
	public double getTotalSpoiledCost() {
		return this.totalCost;
	}
	public double getTotalSpoiledShellfish() {
		return this.shellfishCount;
	}
	public double getTotalSpoiledSeafood() {
		return this.seafoodCount;
	}
	public double getTotalSpoiledFood() {
	 return totalCount;	
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		PlateEvent arg1 = (PlateEvent) arg;	
		if(arg1.getType() == EventType.PLATE_SPOILED) {
			Sushi tester = arg1.getPlate().getContents();
			IngredientPortion[] arr = tester.getIngredients();
			
			for(int i = 0; i <arr.length; i++) {
				if(arr[i].getName() == "crab" || arr[i].getName() == "shrimp") {
					shellfishCount += arr[i].getAmount();
					seafoodCount +=  arr[i].getAmount();
					totalCount +=  arr[i].getAmount();
					totalCost += arr[i].getCost();
				}else
				if(arr[i].getName() == "salmon" || arr[i].getName() == "tuna"|| arr[i].getName() == "eel" ) {
					seafoodCount +=  arr[i].getAmount();
					totalCount +=  arr[i].getAmount();
					totalCost += arr[i].getCost();
				} else 
					if(arr[i].getName() == "avocado" || arr[i].getName() == "rice" || arr[i].getName() == "seaweed") {
						
					totalCount += arr[i].getAmount();
					totalCost += arr[i].getCost();
				}
					
			}
			decBelt.removePlateAtPosition(arg1.getPosition());
		}
	}

}

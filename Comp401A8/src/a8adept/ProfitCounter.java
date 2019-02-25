package a8adept;

import java.util.Observable;
import java.util.Observer;

import a8adept.PlateEvent.EventType;

public class ProfitCounter implements Observer {

	private double decTotalProfit;
	private double decAverageProfit;
	private int counter;
	private Belt decBelt;
	
	public ProfitCounter(Belt b) {
		decBelt = b;
		if (decBelt == null) {
			throw new IllegalArgumentException();
		}
		for(int i =0; i < b.getSize(); i++) {
			if(this.decBelt.getPlateAtPosition(i) != null) {
		decTotalProfit += b.getPlateAtPosition(i).getProfit();
				if(decBelt.getPlateAtPosition(i) != null) {
			counter +=1;
				}
			}
		}
		b.addObserver(this);
		if(counter != 0) {
		this.decAverageProfit = decTotalProfit / counter;
		}
	}

	public double getTotalBeltProfit() {
		return decTotalProfit;
	}
	public double getAverageBeltProfit() {
		return decAverageProfit;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		PlateEvent arg1 = (PlateEvent) arg;
		if(arg1.getType() == EventType.PLATE_PLACED) {
			decTotalProfit += arg1.getPlate().getProfit();
			this.counter += 1;
			decAverageProfit = decTotalProfit / this.counter;
		}
		if(arg1.getType() == EventType.PLATE_REMOVED) {
			this.decTotalProfit -= arg1.getPlate().getProfit();
			counter -= 1;
			if(counter != 0) {
			this.decAverageProfit = this.decTotalProfit / this.counter;
			}else {
				this.decAverageProfit = 0.0;
			}
			
		
		}
	}
}

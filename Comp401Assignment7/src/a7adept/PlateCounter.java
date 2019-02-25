package a7adept;

import java.util.Observable;

import java.util.Observer;

import a7adept.PlateEvent.EventType;
import comp401.sushi.Plate;

public class PlateCounter implements Observer {

	private int GoldPlateCount;
	private int BluePlateCount;
	private int GreenPlateCount;
	private int RedPlateCount;
	private Belt belt;



	public PlateCounter (Belt b) {	
		this.belt = b;
		
		int rc = 0;
		int bc= 0;
		int glc = 0;
		int grc = 0;
		if (belt == null) {
			throw new IllegalArgumentException("ya done goofed");
		}
		for(int i = 0; i < belt.getSize(); i++) {
			if(belt.getPlateAtPosition(i) != null) {
				if(belt.getPlateAtPosition(i).getColor() == Plate.Color.RED) {
					rc +=1;
		
				}
				if(belt.getPlateAtPosition(i).getColor() ==Plate.Color.BLUE) {
					bc +=1;
				}
				if(belt.getPlateAtPosition(i).getColor() ==Plate.Color.GREEN) {
					grc +=1;
				}
				if(belt.getPlateAtPosition(i).getColor() ==Plate.Color.GOLD) {
					glc +=1;
				}
			}
		}	
		b.addObserver(this);
		this.GoldPlateCount = glc;
		this.BluePlateCount = bc;
		this.GreenPlateCount = grc;
		this.RedPlateCount = rc;
		
	}
	
	public int getRedPlateCount() {
		return this.RedPlateCount;
	}
	public int getGreenPlateCount() {
		return this.GreenPlateCount;
	}
	public int getBluePlateCount() {
		return this.BluePlateCount;
	}
	public int getGoldPlateCount() {
		return this.GoldPlateCount;
	}
	
	@Override
	public void update(Observable o, Object arg) {
// most inefficient code ever
		 belt = (Belt) o;
		PlateEvent arg1 = (PlateEvent) arg;
		if(arg1.getType() == EventType.PLATE_PLACED) {
			if(arg1.getPlate().getColor() == Plate.Color.RED) {
				this.RedPlateCount +=1;
				
			}
			if(arg1.getPlate().getColor() == Plate.Color.BLUE) {
				this.BluePlateCount += 1;
			}
			if(arg1.getPlate().getColor() == Plate.Color.GREEN) {
				this.GreenPlateCount += 1;
			}
			if(arg1.getPlate().getColor() == Plate.Color.GOLD) {
				this.GoldPlateCount += 1;
			}			
		}
		if(arg1.getType() == EventType.PLATE_REMOVED) {
			if(arg1.getPlate().getColor() == Plate.Color.RED) {
				RedPlateCount = RedPlateCount -1;
				
			}
			if(arg1.getPlate().getColor() == Plate.Color.BLUE) {
				BluePlateCount = BluePlateCount - 1;
			}
			if(arg1.getPlate().getColor() == Plate.Color.GREEN) {
				GreenPlateCount = GreenPlateCount-1;
			}
			if(arg1.getPlate().getColor() == Plate.Color.GOLD) {
				GoldPlateCount = GoldPlateCount-1;
			}			
		}
		
	
	}

	

}

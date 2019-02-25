package a6novice;

import comp401.sushi.Plate;

public class BeltPlateException extends Exception{
	private Plate decPlate;
	private int decPosition;
	private Belt decBelt;
	
	public BeltPlateException(int position, Plate plate_to_be_set, Belt belt) {
	super("Belt size is too small.");
	decPlate = plate_to_be_set;
	decBelt = belt;
	decPosition = position;
	}
	public int getPosition() {
		
		return decPosition;
	}
	public Plate getPlateToSet() {
		return decPlate;
	}
	public Belt getBelt() {
		return decBelt;
	}
}

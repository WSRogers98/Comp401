package a7adept;

import comp401.sushi.Plate;

public class BeltPlateException extends Exception {

	private int position;
	private Plate plate;
	private Belt belt;
	
	public BeltPlateException(int position, Plate plate_to_be_set, Belt belt) {
		this.position = position;
		this.plate = plate_to_be_set;
		this.belt = belt;
	}
	
	public int getPosition() {
		return position;
	}

	public Plate getPlateToSet() {
		return plate;
	}
	
	public Belt getBelt() {
		return belt;
	}

}

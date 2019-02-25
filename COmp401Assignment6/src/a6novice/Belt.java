package a6novice;

import java.util.NoSuchElementException;

import comp401.sushi.Plate;

public class Belt {
private int decSize;
private Plate decPosition;
	public Belt(int size) throws BeltPlateException {
	if (size == 0 || size < 0) {
		throw new IllegalArgumentException();
	}
		decSize = size;
	}
	public int getSize() {
		return decSize;
	}
	public Plate getPlateAtPosition(int position) {
		if(position < 0 || position >= decSize) {
			throw new IllegalArgumentException();
		}
		return decPosition;
	}
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if(plate == null) {
			throw new IllegalArgumentException();
		}
		if(position < 0 || position >= decSize) {
			throw new IllegalArgumentException();
		}
		if(decPosition != null) {
			throw new BeltPlateException(position, plate, this);
		}
		decPosition = plate;
	}
	public void clearPlatePosition(int position) {
	decPosition = null;	
	}
	public Plate removePlateAtPosition(int position) {
		if(position < 0 || position >= decSize) {
			throw new IllegalArgumentException();
		}
		if( decPosition == null) {
			throw new NoSuchElementException();
		}
		Plate s = decPosition;
		decPosition = null;
		return s;
		
	}
}

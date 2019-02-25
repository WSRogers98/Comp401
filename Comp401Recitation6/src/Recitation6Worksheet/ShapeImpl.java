package Recitation6Worksheet;
// Did not finish in recitation 
public abstract class  ShapeImpl implements Shape {

	private int numberOfSides;
	public ShapeImpl( int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}
	
	public int getNumberOfSides() {
		return numberOfSides;
	}
}

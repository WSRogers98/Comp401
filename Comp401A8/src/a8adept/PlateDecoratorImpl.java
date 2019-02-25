package a8adept;

import comp401.sushi.Plate;
import comp401.sushi.PlatePriceException;
import comp401.sushi.Sushi;

public class PlateDecoratorImpl implements PlateDecorator {

	private Plate decPlate;
	private int decAge;

	public PlateDecoratorImpl(Plate plate) {
		this.decPlate = plate;
	}
	
	@Override
	public Sushi getContents() {
		// TODO Auto-generated method stub
		return this.decPlate.getContents();
	}

	@Override
	public void setContents(Sushi s) throws PlatePriceException {
		// TODO Auto-generated method stub
		this.decPlate.setContents(s);
	}

	@Override
	public Sushi removeContents() {
		// TODO Auto-generated method stub
		return this.decPlate.removeContents();
	}

	@Override
	public boolean hasContents() {
		// TODO Auto-generated method stub
		return this.decPlate.hasContents();
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.decPlate.getPrice();
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return this.decPlate.getColor();
	}

	@Override
	public double getProfit() {
		// TODO Auto-generated method stub
		return this.decPlate.getProfit();
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return this.decAge;
	}

	@Override
	public Plate getPlate() {
		// TODO Auto-generated method stub
		return decPlate;
	}

	@Override
	public void IncAge() {
		// TODO Auto-generated method stub
		this.decAge++;
	}

}

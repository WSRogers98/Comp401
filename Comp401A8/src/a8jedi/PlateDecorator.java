package a8jedi;

import comp401.sushi.Plate;

public interface PlateDecorator extends Plate {
 int getAge();
 Plate getPlate();
 void IncAge();
}

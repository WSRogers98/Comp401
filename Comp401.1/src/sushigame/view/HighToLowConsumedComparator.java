package sushigame.view;

import java.util.Comparator;

import sushigame.model.Chef;

public class HighToLowConsumedComparator implements Comparator<Chef>{
	
	public int compare(Chef eins, Chef zwei) {
		// We do b - a because we want largest to smallest
		return (int) (Math.round(zwei.getFoodConsumedCount()*100.0) - 
				Math.round(eins.getFoodConsumedCount()*100));
	}	
}

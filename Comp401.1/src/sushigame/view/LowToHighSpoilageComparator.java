package sushigame.view;

import java.util.Comparator;

import sushigame.model.Chef;

public class LowToHighSpoilageComparator implements Comparator<Chef>{

	public int compare(Chef eins, Chef zwei) {
		return (int) (Math.round(eins.getFoodSpoiledCount()*100) - Math.round(zwei.getFoodSpoiledCount()*100.0));
	}	
}

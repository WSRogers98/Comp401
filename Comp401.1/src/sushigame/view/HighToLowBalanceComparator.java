package sushigame.view;

import java.util.Comparator;

import sushigame.model.Chef;

public class HighToLowBalanceComparator implements Comparator<Chef> {

	@Override
	public int compare(Chef eins, Chef zwei) {
		// We do b - a because we want largest to smallest
		return (int) (Math.round(zwei.getBalance()*100.0) - 
				Math.round(eins.getBalance()*100));
	}			
}

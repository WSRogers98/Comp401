package sushigame.view;
// dear kmp... why just why
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.Crab;
import comp401.sushi.Plate;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;

public class BeltView extends JPanel implements BeltObserver {

	private Belt belt;
	private BeltDisplay[] plateWidget;

	public BeltView(Belt b) {
		this.belt = b;
		belt.registerBeltObserver(this);
		setLayout(new GridLayout(belt.getSize(), 1));
		// belt_labels = new JLabel[belt.getSize()];
		plateWidget = new BeltDisplay[belt.getSize()];

		for (int i = 0; i < belt.getSize(); i++) {

			BeltDisplay display = new BeltDisplay(Color.GRAY);
			display.setMinimumSize(new Dimension(550, 150));
			display.setPreferredSize(new Dimension(550, 150));
			display.setOpaque(true);
			display.setBackground(Color.GRAY);
			

			this.add(display);
			plateWidget[i] = display;
		}
		refresh();

	}

	@Override
	public void handleBeltEvent(BeltEvent e) {
		refresh();
	}

	private void refresh() {
		for (int i = 0; i < belt.getSize(); i++) {
			BeltDisplay display = this.plateWidget[i];
			display.setPlate(belt.getPlateAtPosition(i), belt.getAgeOfPlateAtPosition(i));
		}
	}
}

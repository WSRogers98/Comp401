package sushigame.view;

import javax.swing.JPanel;
import comp401.sushi.IngredientPortion;
import comp401.sushi.Plate;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class BeltDisplay extends JPanel {
	private List leftPanelList;
	private List centerPanelList;
	private List rightPanelList;

	public BeltDisplay(Color c) {

		this.setMinimumSize(new Dimension(300, 300));
		this.setPreferredSize(new Dimension(300, 300));
		this.setLayout(new GridLayout(1, 3));

		this.leftPanelList = new List();
		this.centerPanelList = new List();
		this.rightPanelList = new List();

		this.add(leftPanelList);
		this.add(centerPanelList);
		this.add(rightPanelList);
	}

	private void setColor(Plate p) {

		Color backGroundColor = Color.GRAY;
		Color foreGroundColor = Color.BLACK;

		if (p != null) {

			if (p.getColor() == Plate.Color.BLUE) {
				backGroundColor = Color.BLUE;
				foreGroundColor = Color.WHITE;
			}

			if (p.getColor() == Plate.Color.GOLD) {
				backGroundColor = Color.YELLOW;
			}

			if (p.getColor() == Plate.Color.GREEN) {
				backGroundColor = Color.GREEN;
				foreGroundColor = Color.BLACK;

			}
			if (p.getColor() == Plate.Color.RED) {
				backGroundColor = Color.RED;
				foreGroundColor = Color.WHITE;
			}
		}

		leftPanelList.setBackground(backGroundColor);
		centerPanelList.setBackground(backGroundColor);
		rightPanelList.setBackground(backGroundColor);

		leftPanelList.setForeground(foreGroundColor);
		centerPanelList.setForeground(foreGroundColor);
		rightPanelList.setForeground(foreGroundColor);
	}

	public void setPlate(Plate p, int Age) {
		this.resetPlateInfo();

		if (p == null) {
			return;
		}

		this.setColor(p);
		this.setSushiTypeLabel(p);
		this.setChefLabel(p);
		this.setPlateAge(Age);
		this.setIngredients(p);
	}

	private void setSushiTypeLabel(Plate p) {
		if (p != null) {
			if (p.getContents().getName().contains("sashimi")) {
				leftPanelList.add("Sushi Type: Sashimi");
				return;
			}
			if (p.getContents().getName().contains("nigiri")) {
				leftPanelList.add("Sushi Type: Nigiri");
				return;
			}
			if (p.getContents().getName().contains("Roll")) {
				leftPanelList.add("Sushi Type: Roll");

				return;
			}

			leftPanelList.add("Sushi Type: Unknown");
		} else {
			this.resetPlateInfo();
		}
	}

	private void setChefLabel(Plate p) {
		if (p != null) {
			String s = "Chef: " + p.getChef().getName();
			centerPanelList.add(s);
		} else {
			this.resetPlateInfo();
		}
	}

	private void resetPlateInfo() {
		Color backGroundColor = Color.GRAY;
		Color foreGroundColor = Color.BLACK;

		leftPanelList.setBackground(backGroundColor);
		centerPanelList.setBackground(backGroundColor);
		rightPanelList.setBackground(backGroundColor);

		leftPanelList.setForeground(foreGroundColor);
		centerPanelList.setForeground(foreGroundColor);
		rightPanelList.setForeground(foreGroundColor);

		leftPanelList.removeAll();
		centerPanelList.removeAll();
		rightPanelList.removeAll();
	}

	private void setPlateAge(int Age) {
		String s = "Plate Age: " + Integer.toString(Age);
		this.leftPanelList.add(s);
	}

	private void setIngredients(Plate p) {
		this.rightPanelList.add("Ingredient(s):");
		for (IngredientPortion I : p.getContents().getIngredients()) {
			String s = I.getName() + " " + this.RoundDouble(I.getAmount());
			this.rightPanelList.add(s);
		}
	}

	private double RoundDouble(double d) {

		double dd = Math.round(d * 100.0) / 100.0;
		return dd;
	}
}

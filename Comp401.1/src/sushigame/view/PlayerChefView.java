package sushigame.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import comp401.sushi.AvocadoPortion;
import comp401.sushi.CrabPortion;
import comp401.sushi.EelPortion;
import comp401.sushi.IngredientPortion;
import comp401.sushi.Nigiri;
import comp401.sushi.Plate;
import comp401.sushi.RedPlate;
import comp401.sushi.RicePortion;
import comp401.sushi.Roll;
import comp401.sushi.SalmonPortion;
import comp401.sushi.Sashimi;
import comp401.sushi.SeaweedPortion;
import comp401.sushi.ShrimpPortion;
import comp401.sushi.Sushi;
import comp401.sushi.TunaPortion;
import comp401.sushi.Sashimi.SashimiType;
import sushigame.model.Chef;

public class PlayerChefView extends JPanel implements ActionListener {

	private List<ChefViewListener> listeners;
	private int decBeltSize;
	private double goldPlatePrice = 0.0d;
	 private JComboBox<String> decPlateType;
	 private JComboBox<String> decSushiType;
	 private JComboBox<String> decSashimiType;
	private JComboBox<String> decNigiriType;
	private JComboBox<Integer> decBeltSlot;
	private int decSpotSelected = 0;
	private TextField decGoldPlatePriceText;
	private JPanel decRollContentPanel;
	// why did you forsake us with this code kmp whyyyyyyy...
	JButton SelectGoldPlatePriceButton;
	JButton NigiriTypeButton;
	JTextArea decConsoleText;
	TextField decRoleAvocadoAmount;
	TextField decRoleCrabAmount;
	TextField decRoleEelAmount;
	TextField decRoleRiceAmount;
	TextField decRoleSalmonAmount;
	TextField decRoleSeaweedAmount;
	TextField decRoleShrimpAmount;
	TextField decRoleTunaAmount;
	TextField decNigiriCrabAmount;
	TextField decNigiriEelAmount;
	TextField decNigiriSalmonAmount;
	TextField decNigiriShrimpAmount;
	TextField decNigiriTunaAmount;
	JButton SashimiTypeButton;
	Label goldPlatePriceHeading;
	Label decNigiriTypeHeading;
	Label decSashimiTypeHeading;
	Label decIngredientPanelHeader;
	TextField decSashimiCrabAmount;
	TextField decSashimiEelAmount;
	TextField decSashimiSalmonAmount;
	TextField decSashimiShrimpAmount;
	TextField decSashimiTunaAmount;

	public PlayerChefView(int beltSize) {
		this.decBeltSize = beltSize;
		listeners = new ArrayList<ChefViewListener>();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		Dimension decComboBoxDimension = new Dimension(300, 30);
		Dimension decLabelDimension = new Dimension(300, 30);
		Dimension decButtonDimension = new Dimension(200, 30);

		JPanel decPlatePanel = new JPanel();
		decPlatePanel.setLayout(new BoxLayout(decPlatePanel, BoxLayout.Y_AXIS));

		Label WarningHeading = new Label();
	//	String newLine = System.getProperty("line.separator");
		WarningHeading.setText("HIT BUTTON AFTER INPUT");
		WarningHeading.setMaximumSize(decLabelDimension);
		decPlatePanel.add(WarningHeading);
		Label plateColorHeading = new Label();
		plateColorHeading.setText("PLATE COLOR:");
		plateColorHeading.setMaximumSize(decLabelDimension);
		decPlatePanel.add(plateColorHeading);

		decPlateType = new JComboBox<String>();
		decPlateType.addItem("BLUE");
		decPlateType.addItem("GREEN");
		decPlateType.addItem("GOLD");
		decPlateType.addItem("RED");
		decPlateType.setMaximumSize(decComboBoxDimension);
		decPlatePanel.add(decPlateType);

		JButton selectPlateButton = new JButton("SELECT PLATE TYPE");
		selectPlateButton.setMaximumSize(decButtonDimension);
		selectPlateButton.setActionCommand("setPlateType");
		selectPlateButton.addActionListener(this);
		decPlatePanel.add(selectPlateButton);

		Label sushiTypeHeading = new Label();
		sushiTypeHeading.setText("SUSHI TYPE: ");
		sushiTypeHeading.setMaximumSize(decLabelDimension);
		decPlatePanel.add(sushiTypeHeading);

		decSushiType = new JComboBox<String>();
		decSushiType.addItem("Sashimi");
		decSushiType.addItem("Nigiri");
		decSushiType.addItem("Roll");
		decSushiType.setMaximumSize(decComboBoxDimension);
		decPlatePanel.add(decSushiType);

		JButton sushiTypeButton = new JButton("SELECT SUSHI TYPE");
		sushiTypeButton.setMaximumSize(decButtonDimension);
		sushiTypeButton.setActionCommand("setSushiType");
		sushiTypeButton.addActionListener(this);
		decPlatePanel.add(sushiTypeButton);

		Label beltSlotTypeHeading = new Label();
		beltSlotTypeHeading.setText("BELT SLOT: ");
		beltSlotTypeHeading.setMaximumSize(decLabelDimension);
		decPlatePanel.add(beltSlotTypeHeading);

		decBeltSlot = new JComboBox<Integer>();
		decBeltSlot.setMaximumSize(decComboBoxDimension);
		for (int l = 0; l < decBeltSize; l++) {
			decBeltSlot.addItem(l);
		}
		decPlatePanel.add(decBeltSlot);

		JButton beltPositionButton = new JButton("SELECT BELT SLOT");
		beltPositionButton.setMaximumSize(decButtonDimension);
		beltPositionButton.setActionCommand("setBeltPosition");
		beltPositionButton.addActionListener(this);
		decPlatePanel.add(beltPositionButton);

		decSashimiTypeHeading = new Label();
		decSashimiTypeHeading.setText("SASHIMI TYPE: ");
		decSashimiTypeHeading.setMaximumSize(decLabelDimension);
		decPlatePanel.add(decSashimiTypeHeading);

		decSashimiType = new JComboBox<String>();
		decSashimiType.addItem("Crab");
		decSashimiType.addItem("Eel");
		decSashimiType.addItem("Salmon");
		decSashimiType.addItem("Shrimp");
		decSashimiType.addItem("Tuna");
		decSashimiType.setMaximumSize(decComboBoxDimension);
		decPlatePanel.add(decSashimiType);

		SashimiTypeButton = new JButton("SELECT SASHIMI TYPE");
		SashimiTypeButton.setMaximumSize(decButtonDimension);
		SashimiTypeButton.setActionCommand("setSashimiType");
		SashimiTypeButton.addActionListener(this);
		decPlatePanel.add(SashimiTypeButton);

		decNigiriTypeHeading = new Label();
		decNigiriTypeHeading.setText("NITIRI TYPE: ");
		decNigiriTypeHeading.setMaximumSize(decLabelDimension);
		decNigiriTypeHeading.setVisible(false);
		decPlatePanel.add(decNigiriTypeHeading);

		decNigiriType = new JComboBox<String>();
		decNigiriType.addItem("Crab");
		decNigiriType.addItem("Eel");
		decNigiriType.addItem("Salmon");
		decNigiriType.addItem("Shrimp");
		decNigiriType.addItem("Tuna");
		decNigiriType.setMaximumSize(decComboBoxDimension);
		decNigiriType.setVisible(false);
		decPlatePanel.add(decNigiriType);

		NigiriTypeButton = new JButton("SELECT NIGIRI TYPE");
		NigiriTypeButton.setActionCommand("setSashimiType");
		NigiriTypeButton.addActionListener(this);
		NigiriTypeButton.setVisible(false);
		decPlatePanel.add(NigiriTypeButton);

		goldPlatePriceHeading = new Label();
		goldPlatePriceHeading.setText("GOLD PLATE PRICE: ");
		goldPlatePriceHeading.setMaximumSize(decLabelDimension);
		goldPlatePriceHeading.setVisible(false);
		decPlatePanel.add(goldPlatePriceHeading);

		decGoldPlatePriceText = new TextField("0.0", 0);
		decGoldPlatePriceText.setMaximumSize(new Dimension(300, 30));
		decGoldPlatePriceText.setVisible(false);
		decPlatePanel.add(decGoldPlatePriceText);

		SelectGoldPlatePriceButton = new JButton("SET PLATE PRICE");
		SelectGoldPlatePriceButton.setActionCommand("setGoldPlatePrice");
		SelectGoldPlatePriceButton.addActionListener(this);
		SelectGoldPlatePriceButton.setVisible(false);
		decPlatePanel.add(SelectGoldPlatePriceButton);

		this.add(decPlatePanel);

		decIngredientPanelHeader = new Label("Roll Ingredients");
		decIngredientPanelHeader.setMaximumSize(decLabelDimension);
		decIngredientPanelHeader.setVisible(false);
		this.add(decIngredientPanelHeader);

		this.setupRoleIngredientPanel();

		JLabel spacer1 = new JLabel(" ");
		add(spacer1);

		JButton create_button = new JButton("Create Plate");
		create_button.setActionCommand("createPlate");
		create_button.addActionListener(this);
		add(create_button);

		JLabel spacer2 = new JLabel(" ");
		add(spacer2);

		this.decConsoleText = new JTextArea();
		decConsoleText.setLineWrap(true);
		decConsoleText.setMaximumSize(new Dimension(300, 30));

		add(decConsoleText);
	}

	private void setupRoleIngredientPanel() {
		decRollContentPanel = new JPanel();
		decRollContentPanel.setLayout(new GridLayout(8, 2));
		decRollContentPanel.setMaximumSize(new Dimension(300, 200));
		decRollContentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		decRollContentPanel.setVisible(false);
		Label avocadoLabel = new Label("Avocado");
		decRollContentPanel.add(avocadoLabel);
		decRoleAvocadoAmount = new TextField("0.0", 0);
		decRollContentPanel.add(decRoleAvocadoAmount);
		Label crabLabel = new Label("Crab");
		decRollContentPanel.add(crabLabel);
		decRoleCrabAmount = new TextField("0.0", 0);
		decRollContentPanel.add(decRoleCrabAmount);
		Label eelLabel = new Label("Eel");
		decRollContentPanel.add(eelLabel);
		decRoleEelAmount = new TextField("0.0", 0);
		decRollContentPanel.add(decRoleEelAmount);
		Label riceLabel = new Label("Rice");
		decRollContentPanel.add(riceLabel);
		decRoleRiceAmount = new TextField("0.0", 0);
	decRollContentPanel.add(decRoleRiceAmount);
		
		Label salmonLabel = new Label("Salmon");
		decRollContentPanel.add(salmonLabel);
		decRoleSalmonAmount = new TextField("0.0", 0);
		decRollContentPanel.add(decRoleSalmonAmount);

		Label seaweedLabel = new Label("Seaweed");
		decRollContentPanel.add(seaweedLabel);
		decRoleSeaweedAmount = new TextField("0.0", 0);
		decRollContentPanel.add(decRoleSeaweedAmount);

		Label shrimpLabel = new Label("Shrimp");
		decRollContentPanel.add(shrimpLabel);
		decRoleShrimpAmount = new TextField("0.0", 0);
		decRollContentPanel.add(decRoleShrimpAmount);

		Label tunaLabel = new Label("Tuna");
		decRollContentPanel.add(tunaLabel);
		decRoleTunaAmount = new TextField("0.0", 0);
		decRollContentPanel.add(decRoleTunaAmount);

		add(decRollContentPanel);

	}

	public void registerChefListener(ChefViewListener cl) {
		listeners.add(cl);
		}
	private void setNigiriVisible(boolean b) {
		this.decNigiriTypeHeading.setVisible(b);
		this.NigiriTypeButton.setVisible(b);
		this.decNigiriType.setVisible(b);
		}

	private void setSashimiVisible(boolean b) {
		this.decSashimiTypeHeading.setVisible(b);
		this.SashimiTypeButton.setVisible(b);
		this.decSashimiType.setVisible(b);
		this.decSashimiTypeHeading.setEnabled(b);
		this.SashimiTypeButton.setEnabled(b);
		this.decSashimiType.setEnabled(b);

			}

	private void setSushiType() {

		String s = this.decSushiType.getSelectedItem().toString();
		s = s + "";
		if (s.equals("Roll")) {
			this.decRollContentPanel.setVisible(true);
			this.decIngredientPanelHeader.setVisible(true);
			this.setNigiriVisible(false);
			this.setSashimiVisible(false);
		}if (s.equals("Nigiri")) {
			this.decRollContentPanel.setVisible(false);
			this.decIngredientPanelHeader.setVisible(false);
			this.setNigiriVisible(true);
			this.setSashimiVisible(false);
		}if (s.equals("Sashimi")) {
			this.decRollContentPanel.setVisible(false);
			this.decIngredientPanelHeader.setVisible(false);
			this.setNigiriVisible(false);
			this.setSashimiVisible(true);
		}
	}

	private void makeRedPlateRequest(Sushi plateSushi, int platePosition) {
		for (ChefViewListener test : listeners) {
			test.handleRedPlateRequest(plateSushi, platePosition);
		}
	}

	private void makeGreenPlateRequest(Sushi plateSushi, int platePosition) {
		for (ChefViewListener test : listeners) {
			test.handleGreenPlateRequest(plateSushi, platePosition);
		}
	}

	private void makeBluePlateRequest(Sushi plateSushi, int platePosition) {
		for (ChefViewListener test : listeners) {
			test.handleBluePlateRequest(plateSushi, platePosition);
		}
	}

	private void makeGoldPlateRequest(Sushi plateSushi, int platePosition, double price) {
		for (ChefViewListener test : listeners) {
			test.handleGoldPlateRequest(plateSushi, platePosition, price);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "setSushiType":
			this.setSushiType();
			break;
		case "setGoldPlatePrice":
			this.setGoldPlatePrice();
			;
			break;
		case "createPlate":
			this.createPlate();
			break;
		case "setPlateType":
			this.setPlateType();
			break;
		case "setBeltPosition":
			this.setBeltPosition();
			break;
		}
	}

	private void setBeltPosition() {

		try {
			this.decSpotSelected = Integer.parseInt(this.decBeltSlot.getSelectedItem().toString());
		} catch (Exception ex) {
			this.printConsole(ex.getMessage());
		}
	}

	private void setPlateType() {
		String s = this.decPlateType.getSelectedItem().toString();
		if (s.equals("GOLD")) {
			this.goldPlatePriceHeading.setVisible(true);
			this.decGoldPlatePriceText.setVisible(true);
			this.SelectGoldPlatePriceButton.setVisible(true);
			this.decGoldPlatePriceText.setVisible(true);
		} else {
			this.goldPlatePriceHeading.setVisible(false);
			this.decGoldPlatePriceText.setVisible(false);
			this.SelectGoldPlatePriceButton.setVisible(false);
			this.decGoldPlatePriceText.setVisible(false);
		}
	}

	private void printConsole(String s) {
		this.decConsoleText.setText(s);
	}

	private void setGoldPlatePrice() {
		try {
			this.goldPlatePrice = Double.parseDouble(decGoldPlatePriceText.getText());
		} catch (Exception ex) {
			printConsole("Error: Invalid value provided for gold plate price.");
		}

		if (this.goldPlatePrice < 5 || this.goldPlatePrice > 10) {
			printConsole("Invalid price set for gold plate.  Price must be between $5.00 and $10.00.");
			this.goldPlatePrice = 0;
			decGoldPlatePriceText.setText("0.00");
		} else {
			printConsole("");
		}
	}

	private void createPlate() {
		this.printConsole("");
		Sushi s = null;

		if (this.decPlateType.getSelectedItem().toString().toLowerCase().equals("gold")) {
			if (this.goldPlatePrice < 5 || this.goldPlatePrice > 10) {
				this.printConsole("The price set for a Gold plate must not be less than $5.00 or greater than $10.00.");
				return;
			}
		}
		if (decSushiType.getSelectedItem().toString().equals("Roll")) {
			s = this.createRoll();
			if (s == null) {
				return;
			}
		}

		if (decSushiType.getSelectedItem().toString().equals("Nigiri")) {
			Nigiri.NigiriType decNigiriType = null;
			String t = this.decNigiriType.getSelectedItem().toString();

			switch (t.toLowerCase()) {
			case "crab":
				decNigiriType = Nigiri.NigiriType.CRAB;
				break;
			case "eel":
				decNigiriType = Nigiri.NigiriType.EEL;
				break;
			case "salmon":
				decNigiriType = Nigiri.NigiriType.SALMON;
				break;
			case "shrimp":
				decNigiriType = Nigiri.NigiriType.SHRIMP;
				break;
			case "tuna":
				decNigiriType = Nigiri.NigiriType.TUNA;
				break;
			}

			s = this.createNigiri(decNigiriType);
		}

		if (decSushiType.getSelectedItem().toString().equals("Sashimi")) {

			Sashimi.SashimiType decSashimiType = null;

			String t = this.decSashimiType.getSelectedItem().toString();

			switch (t.toLowerCase()) {
			case "crab":
		decSashimiType = Sashimi.SashimiType.CRAB;
					break;
			case "eel":
				decSashimiType = Sashimi.SashimiType.EEL;
				break;
			case "salmon":
				decSashimiType = Sashimi.SashimiType.SALMON;
				break;
			case "shrimp":
				decSashimiType = Sashimi.SashimiType.SHRIMP;
				break;
			case "tuna":
				decSashimiType = Sashimi.SashimiType.TUNA;
				break;
			}
			s = this.createSashimi(decSashimiType);
		}

		// CREATE PLATE
		if (this.decPlateType.getSelectedItem().toString().equalsIgnoreCase("blue")) {
			this.makeBluePlateRequest(s, this.decSpotSelected);
		}
		if (this.decPlateType.getSelectedItem().toString().equalsIgnoreCase("green")) {
			this.makeGreenPlateRequest(s, decSpotSelected);
		}
		if (this.decPlateType.getSelectedItem().toString().equalsIgnoreCase("gold")) {
			this.makeGoldPlateRequest(s, decSpotSelected, this.goldPlatePrice);
		}
		if (this.decPlateType.getSelectedItem().toString().equalsIgnoreCase("red")) {
			this.makeRedPlateRequest(s, decSpotSelected);
		}

	}

	private Roll createRoll() {
		double avocadoAmount = 0;
		double crabAmount = 0;
		double eelAmount = 0;
		double riceAmount = 0;
		double salmonAmount = 0;
		double seaweedAmount = 0;
		double shrimpAmount = 0;
		double tunaAmount = 0;
		try {
			avocadoAmount = Double.parseDouble(this.decRoleAvocadoAmount.getText());
} catch (Exception ex) {
			printConsole("An invalid amount as specified for the avocado portion.");
		return null;
			}
		if (avocadoAmount < 0 || avocadoAmount > 1.5) {
			printConsole("The amount of avocado must be greater than zero and less than or equal to 1.5.");
			return null;
		}
		try {
			crabAmount = Double.parseDouble(this.decRoleCrabAmount.getText());
		} catch (Exception ex) {
			printConsole("An invalid amount as specified for the crab portion.");
			return null;
	}
		if (crabAmount < 0 || crabAmount > 1.5) {
			printConsole("The amount of crab must be greater than zero and less than or equal to 1.5.");
			return null;
		}
		try {
			eelAmount = Double.parseDouble(this.decRoleEelAmount.getText());
		} catch (Exception ex) {
			printConsole("An invalid amount as specified for the eel portion.");
			return null;
			}
		if (eelAmount < 0 || eelAmount > 1.5) {
			printConsole("The amount of eel must be greater than zero and less than or equal to 1.5.");
			return null;
	}
		try {
			riceAmount = Double.parseDouble(this.decRoleRiceAmount.getText());
	} 	catch (Exception ex) {
			printConsole("An invalid amount as specified for the rice portion.");
			return null;
		}
		if (riceAmount < 0 || riceAmount > 1.5) {
			printConsole("The amount of rice must be greater than zero and less than or equal to 1.5.");
			return null;
		}
		try {
			salmonAmount = Double.parseDouble(this.decRoleSalmonAmount.getText());
		} catch (Exception ex) {
			printConsole("An invalid amount as specified for the salmon portion.");
			return null;
		}

		if (salmonAmount < 0 || salmonAmount > 1.5) {
			printConsole("The amount of salmon must be greater than zero and less than or equal to 1.5.");
			return null;
		}

		try {
			seaweedAmount = Double.parseDouble(this.decRoleSeaweedAmount.getText());
		} catch (Exception ex) {
			printConsole("An invalid amount as specified for the seaweed portion.");
			return null;
		}

		if (seaweedAmount < 0 || seaweedAmount > 1.5) {
			printConsole("The amount of seaweed must be greater than zero and less than or equal to 1.5.");
			return null;
		}

		try {
			shrimpAmount = Double.parseDouble(this.decRoleShrimpAmount.getText());
		} catch (Exception ex) {
			printConsole("An invalid amount as specified for the shrimp portion.");
			return null;
		}

		if (shrimpAmount < 0 || shrimpAmount > 1.5) {
			printConsole("The amount of shrimp must be greater than zero and less than or equal to 1.5.");
			return null;
		}

		try {
			tunaAmount = Double.parseDouble(this.decRoleTunaAmount.getText());
		} catch (Exception ex) {
			printConsole("An invalid amount as specified for the tuna portion.");
			return null;
		}

		if (tunaAmount < 0 || tunaAmount > 1.5) {
			printConsole("The amount of tuna must be greater than zero and less than or equal to 1.5.");
			return null;
		}

		List<IngredientPortion> ingredients = new ArrayList();

		if (avocadoAmount > 0) {
			ingredients.add(new AvocadoPortion(avocadoAmount));
		}
		if (crabAmount > 0) {
			ingredients.add(new CrabPortion(crabAmount));
		}
		if (eelAmount > 0) {
			ingredients.add(new EelPortion(eelAmount));
		}
		if (riceAmount > 0) {
			ingredients.add(new RicePortion(riceAmount));
		}
		if (salmonAmount > 0) {
			ingredients.add(new SalmonPortion(salmonAmount));
		}
		if (seaweedAmount > 0) {
			ingredients.add(new SeaweedPortion(seaweedAmount));
		}
		if (shrimpAmount > 0) {
			ingredients.add(new ShrimpPortion(shrimpAmount));
		}
		if (tunaAmount > 0) {
			ingredients.add(new TunaPortion(tunaAmount));
		}

		IngredientPortion[] portion = new IngredientPortion[ingredients.size()];
		int count = 0;
		for (IngredientPortion I : ingredients) {
			portion[count] = I;
			count++;
		}

		if (count == 0) {
			this.printConsole("At least one ingredient must be specified to create a roll.");
			return null;
		}

		Roll testRoll = new Roll("Roll", portion);

		return testRoll;
	}

	private Nigiri createNigiri(Nigiri.NigiriType T) {
		return new Nigiri(T);
	}

	private Sashimi createSashimi(Sashimi.SashimiType T) {
		return new Sashimi(T);
	}
}

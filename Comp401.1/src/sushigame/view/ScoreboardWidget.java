package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.Chef;
import sushigame.model.SushiGameModel;

public class ScoreboardWidget extends JPanel implements BeltObserver, ActionListener {

	private SushiGameModel game_model;
	private JLabel display;
	private JLabel label1;
	final private JComboBox<String> filterBox; 
	private JButton selectViewButton;	
	private JLabel scoreResults;
	private boolean useBalanceScoreboard = true;
	private boolean useFoodSoldScoreboard = false;
	private boolean useFoodSpoiledScoreboard = false;
	
	public ScoreboardWidget(SushiGameModel gm) {
		game_model = gm;
		game_model.getBelt().registerBeltObserver(this);	
		
		display = new JLabel();
		JPanel displayPanel = new JPanel();
		displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
		displayPanel.setMaximumSize(new Dimension(300,300));
		displayPanel.setPreferredSize(new Dimension(300,300));
		
		scoreResults = new JLabel();
		scoreResults.setLayout(new BoxLayout(scoreResults, BoxLayout.Y_AXIS));
		scoreResults.setMaximumSize(new Dimension(300,300));
		scoreResults.setPreferredSize(new Dimension(300,300));
		displayPanel.add(scoreResults);		
		
		label1 = new JLabel("Select Scoring ");
		label1.setMaximumSize(new Dimension(300,40));		
		displayPanel.add(label1);
		
		filterBox = new JComboBox<String>();
		
		filterBox.setMaximumSize(new Dimension(150,50));
		filterBox.addItem("Balance Order");
		filterBox.addItem("Food Consumed Order");
		filterBox.addItem("Food Spoiled Order");
		displayPanel.add(filterBox);		
		
		selectViewButton = new JButton("Save Score");
		selectViewButton.setActionCommand("setScoreboardView");
		selectViewButton.addActionListener(this);
		displayPanel.add(selectViewButton);
		
		this.add(displayPanel, BorderLayout.LINE_START);
		
	}


	 private String makeScoreboardHTML() {

		String sb_html = "<html>";
		sb_html += "<h1>Scoreboard</h1>";

		// Create an array of all chefs and sort by balance.
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		Arrays.sort(chefs, new HighToLowBalanceComparator());
		
		for (Chef c : chefs) {
			sb_html += c.getName() + " ($" + Math.round(c.getBalance()*100.0)/100.0 + ") <br>";
		}
		return sb_html;
	}


	public void refresh() {
		if(this.useBalanceScoreboard){
			this.scoreResults.setText(this.makeBalanceScoreboardHTML());			
			return;
		}
		
		if(this.useFoodSoldScoreboard){
			this.scoreResults.setText(this.makeFoodSoldScoreboardHTML());
			return;
		}
		
		if(this.useFoodSpoiledScoreboard){
			this.scoreResults.setText(this.makeFoodSpoiledScoreboardHTML());
				return;
			}				
	}
	
	@Override
	public void handleBeltEvent(BeltEvent e) {
		if (e.getType() == BeltEvent.EventType.ROTATE) {
			refresh();
		}		
	}
	
	private String makeBalanceScoreboardHTML() {
		String sb_html = "<html>";
		sb_html += "<h1>Chef Balance</h1>";
		sb_html += "<br>";
	
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		Arrays.sort(chefs, new HighToLowBalanceComparator());
		
		for (Chef c : chefs) {
			sb_html += c.getName() + " : $" + Math.round(c.getBalance()*100.0)/100.0 + " <br>";
		}
		
		sb_html += "</html";
		return sb_html;	
	}
	
	private String makeFoodSoldScoreboardHTML() {
		String sb_html = "<html>";
		sb_html += "<h1>Food Sold</h1>";
		sb_html += "<br>";
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		Arrays.sort(chefs, new HighToLowConsumedComparator());
		
		for (Chef c : chefs) {
			sb_html += c.getName() + " : " + Math.round(c.getFoodConsumedCount()*100.0)/100.0 + " <br>";
		}
		
		sb_html += "</html";
		return sb_html;
	}
	
	private String makeFoodSpoiledScoreboardHTML() {
		String sb_html = "<html>";
		sb_html += "<h1>Food Spoiled</h1>";
		sb_html += "<br>";	
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		Arrays.sort(chefs, new LowToHighSpoilageComparator());
		
		for (Chef c : chefs) {
			sb_html += c.getName() + " : " + Math.round(c.getFoodSpoiledCount()*100.0)/100.0 + " <br>";
		}
		sb_html += "</html";
		return sb_html;
	}
	
	private void setScoreboardView(){
		String s = this.filterBox.getSelectedItem().toString();
		switch(s.toLowerCase()){
			case "balance order" :
				this.useBalanceScoreboard = true;
			this.useFoodSoldScoreboard = false;
				this.useFoodSpoiledScoreboard = false;
				break;			
			case "food sold order" :
				this.useBalanceScoreboard = false;
				this.useFoodSoldScoreboard = true;
				this.useFoodSpoiledScoreboard = false;
				break;				
			case "food spoiled order" :
				this.useBalanceScoreboard = false;
				this.useFoodSoldScoreboard = false;
				this.useFoodSpoiledScoreboard = true;
				break;
			}
		
		this.refresh();
			}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "setScoreboardView":
			this.setScoreboardView();
			break;
		}
	}

}
// at this point there is no way I haven't gone insane'
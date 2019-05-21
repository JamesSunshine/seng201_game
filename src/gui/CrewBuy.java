package gui;

import javax.swing.JFrame;

import main.Game;
import javax.swing.JLabel;

public class CrewBuy {

	private JFrame crewBuy;
	private Game manager;


	public CrewBuy(Game incomingManager) {
		manager = incomingManager;
		initialize();
		crewBuy.setVisible(true);
	}

	public void closeWindow() {
		crewBuy.dispose();
	}
	
	public void finishedWindow() {
		manager.closeCrewBuy(this);
	}
	
	private void initialize() {
		crewBuy = new JFrame();
		crewBuy.setBounds(100, 100, 450, 300);
		crewBuy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crewBuy.getContentPane().setLayout(null);
		
		JLabel lblCrewBuy = new JLabel("Crew Buy");
		lblCrewBuy.setBounds(224, 111, 66, 15);
		crewBuy.getContentPane().add(lblCrewBuy);
	}
}

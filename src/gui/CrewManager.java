package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.Game;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrewManager {

	private JFrame crewManager;
	private Game manager;
	


	/**
	 * Create the application.
	 */
	public CrewManager(Game incomingManager) {
		manager = incomingManager;
		initialize();
		crewManager.setVisible(true);
	}
	
	public void closeWindow() {
		crewManager.dispose();
	}
	
	public void finishedWindow() {
		manager.closeCrewManager(this);
	}
	
	public CrewManager returnThis() {
		return this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		crewManager = new JFrame();
		crewManager.setBounds(100, 100, 450, 300);
		crewManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crewManager.getContentPane().setLayout(null);
		
		JButton btnShop = new JButton("View Shop");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchShopWindow();
			}
		});
		btnShop.setBounds(168, 122, 114, 25);
		crewManager.getContentPane().add(btnShop);
	}

}

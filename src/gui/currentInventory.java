package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.Game;
import main.Ship;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class currentInventory {

	private JFrame invWindow;
	private Game manager;

	
	/**
	 * Create the application.
	 */
	public currentInventory(Game incomingManager) {
		manager = incomingManager;
		initialize();
		invWindow.setVisible(true);
	}
	
	public void closeWindow() {
		invWindow.dispose();
	}
	
	public void finishedWindow() {
		manager.closecurrentInventory(this);
	}
	
	public currentInventory returnThis() {
		return this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		invWindow = new JFrame();
		invWindow.setBounds(100, 100, 450, 300);
		invWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		invWindow.getContentPane().setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.closecurrentInventory(returnThis());
			}
		});
		btnClose.setBounds(324, 235, 114, 25);
		invWindow.getContentPane().add(btnClose);
	}
}

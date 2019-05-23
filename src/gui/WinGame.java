package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.Game;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WinGame {

	private JFrame WinGame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public WinGame() {
		initialize();
		WinGame.setVisible(true);
	}
	
	public void closeWindow() {
		WinGame.dispose();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		WinGame = new JFrame();
		WinGame.setBounds(100, 100, 445, 272);
		WinGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WinGame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Congratulations!");
		lblNewLabel.setFont(new Font("DejaVu Sans Light", Font.BOLD, 26));
		lblNewLabel.setBounds(101, 43, 298, 82);
		WinGame.getContentPane().add(lblNewLabel);
		
		JLabel lblYouFoundAll = new JLabel("You Found All The Transporter Parts!");
		lblYouFoundAll.setBounds(101, 118, 335, 15);
		WinGame.getContentPane().add(lblYouFoundAll);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeWindow();
			}
		});
		btnExit.setBounds(265, 182, 114, 25);
		WinGame.getContentPane().add(btnExit);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.main(new String[1]);
				closeWindow();
			}
		});
		btnMainMenu.setBounds(66, 182, 114, 25);
		WinGame.getContentPane().add(btnMainMenu);
	}
}

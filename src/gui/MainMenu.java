package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import main.Game;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

// TODO: Auto-generated Javadoc
/**
 * The Class MainMenu.
 */

public class MainMenu {

	/** The main menu. */
	private JFrame mainMenu;
	
	/** The manager. */
	private Game manager;

	/**
	 * Instantiates a new main menu.
	 *
	 * @param incomingGame the incoming game
	 */
	public MainMenu(Game incomingGame) {
		manager = incomingGame;
		initialize();
		mainMenu.setVisible(true);
	}
	
	
	
	/**
	 * Close window.
	 */
	public void closeWindow() {
		mainMenu.dispose();
	}

	/**
	 * Initialize.
	 */
	private void initialize() {
		mainMenu = new JFrame();
		mainMenu.setBounds(100, 100, 450, 300);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenu.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchStartup(manager);
				closeWindow();
			}
		});
		btnNewButton.setBounds(152, 169, 121, 25);
		mainMenu.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeWindow();
			}
		});
		btnNewButton_1.setBounds(152, 206, 121, 25);
		mainMenu.getContentPane().add(btnNewButton_1);
		
<<<<<<< HEAD
		JLabel lblNewLabel = new JLabel(" (the game based on the TV show Based on the other TV show about the Island or whatever that show ");
		lblNewLabel.setFont(new Font("DejaVu Sans Light", Font.BOLD, 8));
		lblNewLabel.setBounds(12, 97, 691, 34);
=======
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(181, 37, 66, 15);
>>>>>>> dc00c9ee9ba4b5f3d9f77d0bcda8b902af59c3ce
		mainMenu.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("was about, you get it, right?)");
		lblNewLabel_2.setFont(new Font("DejaVu Sans Light", Font.BOLD, 8));
		lblNewLabel_2.setBounds(167, 129, 238, 15);
		mainMenu.getContentPane().add(lblNewLabel_2);
		
		JLabel lblLostInSpace = new JLabel("Lost in Space");
		lblLostInSpace.setFont(new Font("L M Roman Dunh10", Font.BOLD, 32));
		lblLostInSpace.setBounds(122, 30, 223, 68);
		mainMenu.getContentPane().add(lblLostInSpace);
	}
}

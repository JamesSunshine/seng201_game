package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import main.Game;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {

	private JFrame mainMenu;
	private Game manager;

	/**
	 * Create the application.
	 */
	public MainMenu(Game incomingGame) {
		manager = incomingGame;
		initialize();
		mainMenu.setVisible(true);
	}
	
	public void closeWindow() {
		mainMenu.dispose();
	}

	/**
	 * Initialize the contents of the frame.
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
		btnNewButton.setBounds(152, 141, 121, 25);
		mainMenu.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeWindow();
			}
		});
		btnNewButton_1.setBounds(152, 178, 121, 25);
		mainMenu.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("How To Play");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameInstructions dialog = new GameInstructions();
				dialog.showDialog();
			}
		});
		btnNewButton_2.setBounds(152, 215, 121, 25);
		mainMenu.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(181, 37, 66, 15);
		mainMenu.getContentPane().add(lblNewLabel);
	}
}

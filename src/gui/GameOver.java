package gui;

import javax.swing.JFrame;

import main.Game;
import main.Ship;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class GameOver.
 */
public class GameOver {

	/** The Game over. */
	private JFrame GameOver;
	
	/** The my ship. */
	private Ship myShip;

	/**
	 * Instantiates a new game over.
	 *
	 * @param incomingShip the incoming ship
	 */
	public GameOver(Ship incomingShip) {
		myShip = incomingShip;
		initialize();
		GameOver.setVisible(true);
	}
	
	/**
	 * Close window.
	 */
	public void closeWindow() {
		GameOver.dispose();
	}
	
	/**
	 * Initialize.
	 */
	private void initialize() {
		GameOver = new JFrame();
		GameOver.setBounds(100, 100, 404, 246);
		GameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameOver.getContentPane().setLayout(null);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.main(new String[1]);
				closeWindow();
			}
		});
		btnMainMenu.setBounds(48, 161, 114, 25);
		GameOver.getContentPane().add(btnMainMenu);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeWindow();
			}
		});
		btnExit.setBounds(245, 161, 114, 25);
		GameOver.getContentPane().add(btnExit);
		
		JLabel lblGameOver = new JLabel("Game Over!");
		lblGameOver.setFont(new Font("Chandas", Font.BOLD | Font.ITALIC, 26));
		lblGameOver.setBounds(108, 35, 223, 46);
		GameOver.getContentPane().add(lblGameOver);
		
		JLabel lblNewLabel = new JLabel("You collected " + myShip.getParts() + " transporter parts.");
		lblNewLabel.setBounds(88, 106, 231, 15);
		GameOver.getContentPane().add(lblNewLabel);
	}
}

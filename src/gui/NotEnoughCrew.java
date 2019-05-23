package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class NotEnoughCrew.
 */
public class NotEnoughCrew extends JDialog {

	/**
	 * Show dialog.
	 */
	public static void showDialog() {
		NotEnoughCrew dialog = new NotEnoughCrew();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	/**
	 * Close dialog.
	 */
	public void closeDialog() {
		this.dispose();
	}
	
	/**
	 * Instantiates a new not enough crew.
	 */
	public NotEnoughCrew() {
		setBounds(100, 100, 272, 172);
		getContentPane().setLayout(null);
		
		JLabel lblYourCrewIs = new JLabel("Your Crew is Not Big Enough!");
		lblYourCrewIs.setBounds(30, 23, 230, 24);
		getContentPane().add(lblYourCrewIs);
		
		JButton btnMyBad = new JButton("My bad!");
		btnMyBad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeDialog();
			}
		});
		btnMyBad.setBounds(71, 85, 114, 25);
		getContentPane().add(btnMyBad);
	}
}

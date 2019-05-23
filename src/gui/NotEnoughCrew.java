package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NotEnoughCrew extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void showDialog() {
		NotEnoughCrew dialog = new NotEnoughCrew();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	public void closeDialog() {
		this.dispose();
	}
	
	/**
	 * Create the dialog.
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

package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class CrewFull.
 */
public class CrewFull extends JDialog {

	/** The content panel. */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Show dialog.
	 */

	public static void showDialog() {
		CrewFull dialog = new CrewFull();
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
	 * Instantiates a new crewfull.
	 */
	public CrewFull() {
		setBounds(100, 100, 272, 172);
		getContentPane().setLayout(null);
		
		JLabel lblYourCrewIs = new JLabel("Your Crew is full!");
		lblYourCrewIs.setBounds(66, 22, 143, 24);
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


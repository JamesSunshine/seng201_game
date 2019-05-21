package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewRecruit extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField recruitName;

	
	public NewRecruit() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 450, 237);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			recruitName = new JTextField();
			recruitName.setBounds(93, 123, 253, 28);
			contentPanel.add(recruitName);
			recruitName.setColumns(10);
		}
		
		JLabel lblNameyourNewRecruit = new JLabel("Name Your New Recruit");
		lblNameyourNewRecruit.setBounds(144, 67, 235, 28);
		contentPanel.add(lblNameyourNewRecruit);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 237, 450, 35);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

package gui;
import main.CrewFactory;
import main.Game;
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
import main.Ship;
import main.Items.AidsCure;
import main.Items.Bandages;
import main.Items.CabinBread;
import main.Items.CaesarSalad;
import main.Items.ConcretePill;
import main.Items.Doritos;
import main.Items.Item;
import main.Items.MiGoreng;
import main.Items.SpaceWhopper;
import main.Items.TunaMelt;
public class NewRecruit extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField recruitName;
	private String name;
	private static String type;
	private static Game manager;

	public static void showDialog() {
		NewRecruit dialog = new NewRecruit(type, manager);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	
	public void setName() {
		this.name = recruitName.getText();
	}
	
	public String getName() {
		return name;
	}
	
	public void closeDialog() {
		this.dispose();
	}
	
	public void subPoints(String type) {
        switch (type){
            case "grunt": {
            	manager.removeShipPoints(1);
            }
            case "gunner": {
            	manager.removeShipPoints(2); 
            }
            case "pilot": {
            	manager.removeShipPoints(3);
            }
            case "medic": {
            	manager.removeShipPoints(4);
            }
            case "engineer": {
            	manager.removeShipPoints(5);
            }
            case "scout": {
            	manager.removeShipPoints(5);
            }
                    
        }
    }
	public NewRecruit(String crewType, Game incomingManager) {
		type = crewType;
		manager = incomingManager;
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
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setName();
						manager.makeCrew(type, name);
						subPoints(type);
						closeDialog();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						closeDialog();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

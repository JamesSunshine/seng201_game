package gui;
import gui.CrewBuy;
import main.Game;
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
	private String name;
	private static String type;
	private static Game manager;
	private static CrewBuy crewBuy;

	public static void showDialog() {
		NewRecruit dialog = new NewRecruit(type, manager, crewBuy);
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
            	break;
            }
            case "gunner": {
            	manager.removeShipPoints(2);
            	break;
            }
            case "pilot": {
            	manager.removeShipPoints(3);
            	break;
            }
            case "medic": {
            	manager.removeShipPoints(4);
            	break;
            }
            case "engineer": {
            	manager.removeShipPoints(5);
            	break;
            }
            case "scout": {
            	manager.removeShipPoints(5);
            	break;
            }
                    
        }
    }
	public NewRecruit(String crewType, Game incomingManager, CrewBuy incomingCrewBuy) {
		type = crewType;
		manager = incomingManager;
		crewBuy = incomingCrewBuy;
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
						crewBuy.updatecrewCount();
						crewBuy.updateCrewSize();
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

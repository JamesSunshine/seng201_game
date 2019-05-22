package gui;
import main.Game;
import main.Ship;

import java.awt.EventQueue;

import main.Game;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.Ship;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Startup {

	private JFrame frmWelcome;
	private JTextField shipText;
	private Game manager;
	private int shipPoints;


	public Startup(Game incomingManager) {
		manager = incomingManager;
		initialize();
		frmWelcome.setVisible(true);
	}
	
	public void closeWindow() {
		frmWelcome.dispose();
	}
	
	public void close() {
        manager.closeStartup(this);
	}
	public void finishedWindow() {
		manager.closeStartup(this);
	}


	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setTitle("Welcome");
		frmWelcome.setBounds(100, 100, 450, 300);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name your ship!");
		lblNewLabel.setBounds(156, 42, 138, 30);
		frmWelcome.getContentPane().add(lblNewLabel);
		
		shipText = new JTextField();
		shipText.setBounds(103, 84, 230, 19);
		frmWelcome.getContentPane().add(shipText);
		shipText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("How many days is your adventure?");
		lblNewLabel_1.setBounds(115, 115, 271, 15);
		frmWelcome.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(156, 153, 138, 24);
		frmWelcome.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Choose Crew");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//make a Ship object with selected text 
				String shipName = shipText.getText();
				manager.makeShip(shipName);
				
				//Add crew points to Ship based on game length 
		        String selected = (String) comboBox.getSelectedItem();
		        manager.setnumberDays(Integer.parseInt(selected));
		        shipPoints = Integer.parseInt(selected)*2;
		        manager.addShipPoints(shipPoints);
		        
		        close();
		        
		       
		        
				
				
			}
		});
		btnNewButton.setBounds(263, 238, 165, 25);
		frmWelcome.getContentPane().add(btnNewButton);
	}
}

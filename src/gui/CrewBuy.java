package gui;

import javax.swing.JFrame;

import main.Game;
import javax.swing.JLabel;
import seng201_project.Ship;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class CrewBuy {

	private JFrame crewBuy;
	private Game manager;
	private int crewCount;
	private JTable table_1;
	


	public CrewBuy(Game incomingManager) {
		manager = incomingManager;
		initialize();
		crewBuy.setVisible(true);
	}

	public void closeWindow() {
		crewBuy.dispose();
	}
	
	public void finishedWindow() {
		manager.closeCrewBuy(this);
	}
	
	private void initialize() {
		crewBuy = new JFrame();
		crewBuy.setBounds(100, 100, 789, 552);
		crewBuy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crewBuy.getContentPane().setLayout(null);
		Ship myShip = manager.getShip();
		JLabel lblCrewBuy = new JLabel("Build Your Crew");
		lblCrewBuy.setBounds(309, 12, 139, 15);
		crewBuy.getContentPane().add(lblCrewBuy);
		int crewPoints = myShip.getPoints();
		
		JLabel lblNewLabel = new JLabel(Integer.toString(crewPoints));
		lblNewLabel.setBounds(110, 31, 66, 15);
		crewBuy.getContentPane().add(lblNewLabel);
		
		JLabel lblCrewPoints = new JLabel("Crew Points");
		lblCrewPoints.setBounds(12, 31, 104, 15);
		crewBuy.getContentPane().add(lblCrewPoints);
		
		JLabel lblCrewSize = new JLabel("Crew Size (Min 2, Max 4)");
		lblCrewSize.setBounds(522, 31, 172, 15);
		crewBuy.getContentPane().add(lblCrewSize);
		
		crewCount = myShip.getnumberofCrew();
		JLabel crewSize = new JLabel(Integer.toString(crewCount));
		crewSize.setBounds(723, 31, 66, 15);
		crewBuy.getContentPane().add(crewSize);
		
		JLabel lblGrunthp = new JLabel("HP");
		lblGrunthp.setBounds(266, 77, 172, 15);
		crewBuy.getContentPane().add(lblGrunthp);
		
		JLabel lblGunnerhp = new JLabel("Class");
		lblGunnerhp.setBounds(151, 77, 224, 15);
		crewBuy.getContentPane().add(lblGunnerhp);
		
		JLabel lblClassHp = new JLabel("Specialisation");
		lblClassHp.setBounds(387, 77, 208, 15);
		crewBuy.getContentPane().add(lblClassHp);
		
		JLabel lblPilothp = new JLabel("5");
		lblPilothp.setBounds(266, 104, 58, 15);
		crewBuy.getContentPane().add(lblPilothp);
		
		JLabel lblMedichp = new JLabel("10");
		lblMedichp.setBounds(266, 156, 58, 15);
		crewBuy.getContentPane().add(lblMedichp);
		
		JLabel lblEngineerhp = new JLabel("10");
		lblEngineerhp.setBounds(266, 206, 235, 15);
		crewBuy.getContentPane().add(lblEngineerhp);
		
		JLabel lblScouthp = new JLabel("12");
		lblScouthp.setBounds(266, 260, 250, 15);
		crewBuy.getContentPane().add(lblScouthp);
		
		JLabel label = new JLabel("15");
		label.setBounds(266, 308, 66, 15);
		crewBuy.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("15");
		label_1.setBounds(266, 358, 66, 15);
		crewBuy.getContentPane().add(label_1);
		
		JButton btnGrunt = new JButton("Grunt");
		btnGrunt.setBounds(110, 99, 114, 25);
		crewBuy.getContentPane().add(btnGrunt);
		
		JButton btnGunner = new JButton("Gunner");
		btnGunner.setBounds(110, 151, 114, 25);
		crewBuy.getContentPane().add(btnGunner);
		
		JButton btnPilot = new JButton("Pilot");
		btnPilot.setBounds(110, 201, 114, 25);
		crewBuy.getContentPane().add(btnPilot);
		
		JButton btnMedic = new JButton("Medic");
		btnMedic.setBounds(110, 255, 114, 25);
		crewBuy.getContentPane().add(btnMedic);
		
		JButton btnEngineer = new JButton("Engineer");
		btnEngineer.setBounds(110, 303, 114, 25);
		crewBuy.getContentPane().add(btnEngineer);
		
		JButton btnScout = new JButton("Scout");
		btnScout.setBounds(110, 353, 114, 25);
		crewBuy.getContentPane().add(btnScout);
		
		JLabel lblNewLabel_1 = new JLabel("Bonus to space combat.");
		lblNewLabel_1.setBounds(380, 156, 354, 15);
		crewBuy.getContentPane().add(lblNewLabel_1);
		
		JLabel lblBonusToAsteroid = new JLabel("Bonus to asteroid belt navigation.");
		lblBonusToAsteroid.setBounds(380, 206, 312, 15);
		crewBuy.getContentPane().add(lblBonusToAsteroid);
		
		JLabel lblHelpsMaintainA = new JLabel("Helps maintain a healthier crew.");
		lblHelpsMaintainA.setBounds(380, 260, 273, 15);
		crewBuy.getContentPane().add(lblHelpsMaintainA);
		
		JLabel lblBonusToShip = new JLabel("Bonus to ship repairs.");
		lblBonusToShip.setBounds(380, 308, 273, 15);
		crewBuy.getContentPane().add(lblBonusToShip);
		
		JLabel lblMoreLikelyTo = new JLabel("More likely to find loot.");
		lblMoreLikelyTo.setBounds(380, 353, 273, 15);
		crewBuy.getContentPane().add(lblMoreLikelyTo);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(309, 77, 66, 15);
		crewBuy.getContentPane().add(lblCost);
		
		JLabel label_2 = new JLabel("1");
		label_2.setBounds(309, 104, 66, 15);
		crewBuy.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("2");
		label_3.setBounds(309, 156, 66, 15);
		crewBuy.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("3");
		label_4.setBounds(309, 206, 66, 15);
		crewBuy.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("4");
		label_5.setBounds(309, 260, 66, 15);
		crewBuy.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("5");
		label_6.setBounds(309, 308, 66, 15);
		crewBuy.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("5");
		label_7.setBounds(309, 358, 66, 15);
		crewBuy.getContentPane().add(label_7);
		
		
		//table.setBounds(585, 359, -369, -215);
		//crewBuy.getContentPane().add(table);
	}
}

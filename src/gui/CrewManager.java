package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.Game;
import main.Types.CrewMember;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class CrewManager {

	private JFrame crewManager;
	private Game manager;
	private CrewMember crew1;
	private CrewMember crew2;
	private CrewMember crew3;
	private CrewMember crew4;
	


	/**
	 * Create the application.
	 */
	public CrewManager(Game incomingManager) {
		manager = incomingManager;
		initialize();
		crewManager.setVisible(true);
	}
	
	public void closeWindow() {
		crewManager.dispose();
	}
	
	public void finishedWindow() {
		manager.closeCrewManager(this);
	}
	
	public CrewManager returnThis() {
		return this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		crewManager = new JFrame();
		crewManager.setTitle(manager.getShipName() + "Crew Manager");
		crewManager.setBounds(100, 100, 900, 769);
		crewManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crewManager.getContentPane().setLayout(null);
		
		JButton btnShop = new JButton("View Shop");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchShopWindow();
			}
		});
		btnShop.setBounds(25, 686, 156, 25);
		crewManager.getContentPane().add(btnShop);
		
		JButton btnViewInventory = new JButton("View Inventory");
		btnViewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchcurrentInventory();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(579, 548, 285, 159);
		crewManager.getContentPane().add(scrollPane);
		
		JTextPane txtConsole = new JTextPane();
		txtConsole.setEditable(false);
		scrollPane.setViewportView(txtConsole);
		
		//Crewmember 1
		crew1 = manager.getCrewMember(0);
		JLabel lblName1 = new JLabel(crew1.getName());
		lblName1.setBounds(79, 180, 66, 15);
		crewManager.getContentPane().add(lblName1);
		
		JProgressBar progressHealth1 = new JProgressBar();
		progressHealth1.setForeground(Color.GREEN);
		progressHealth1.setBounds(100, 230, 92, 14);
		crewManager.getContentPane().add(progressHealth1);
		progressHealth1.setValue(100);
		
		JProgressBar progressTiredness1 = new JProgressBar();
		progressTiredness1.setBounds(100, 257, 93, 14);
		crewManager.getContentPane().add(progressTiredness1);
		
		JProgressBar progressHunger1 = new JProgressBar();
		progressHunger1.setBounds(100, 283, 92, 14);
		crewManager.getContentPane().add(progressHunger1);
		
		JLabel lblAction1 = new JLabel(Integer.toString(crew1.getActions()));
		lblAction1.setBounds(103, 310, 66, 15);
		crewManager.getContentPane().add(lblAction1);
		
		JButton btnEat1 = new JButton("Eat");
		btnEat1.setBounds(52, 334, 151, 25);
		crewManager.getContentPane().add(btnEat1);
		
		JButton btnSleep1 = new JButton("Sleep");
		btnSleep1.setBounds(52, 371, 151, 25);
		crewManager.getContentPane().add(btnSleep1);
		
		JButton btnRepair1 = new JButton("Repair Ship");
		btnRepair1.setBounds(54, 408, 149, 25);
		crewManager.getContentPane().add(btnRepair1);
		
		JButton btnSearch1 = new JButton("Search Planet");
		btnSearch1.setBounds(54, 445, 149, 25);
		crewManager.getContentPane().add(btnSearch1);
		
		JButton btnPilot1 = new JButton("Pilot Ship");
		btnPilot1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String currentText = txtConsole.getText();
				txtConsole.setText(currentText + "\n" + "poop");
			}
		});
		btnPilot1.setBounds(52, 482, 151, 25);
		crewManager.getContentPane().add(btnPilot1);
		
		JLabel lblClass1 = new JLabel(crew1.getType());
		lblClass1.setBounds(100, 203, 66, 15);
		crewManager.getContentPane().add(lblClass1);
		
		JLabel lblHealth = new JLabel("Health");
		lblHealth.setBounds(27, 230, 66, 15);
		crewManager.getContentPane().add(lblHealth);
		
		JLabel lblTiredness = new JLabel("Tiredness");
		lblTiredness.setBounds(25, 256, 68, 15);
		crewManager.getContentPane().add(lblTiredness);
		
		JLabel lblHunger = new JLabel("Hunger");
		lblHunger.setBounds(25, 283, 66, 15);
		crewManager.getContentPane().add(lblHunger);
		
		JLabel lblActionsRemaning = new JLabel("Actions");
		lblActionsRemaning.setBounds(25, 310, 66, 15);
		crewManager.getContentPane().add(lblActionsRemaning);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setBounds(27, 203, 66, 15);
		crewManager.getContentPane().add(lblClass);
		
		
		
		//Crewmember 2
		crew2 = manager.getCrewMember(1);
		JLabel lblName2 = new JLabel(crew2.getName());
		lblName2.setBounds(291, 180, 66, 15);
		crewManager.getContentPane().add(lblName2);
		
		JLabel label_1 = new JLabel("Class");
		label_1.setBounds(240, 207, 66, 15);
		crewManager.getContentPane().add(label_1);
		
		JLabel lblClass2 = new JLabel(crew2.getType());
		lblClass2.setBounds(318, 203, 66, 15);
		crewManager.getContentPane().add(lblClass2);
		
		JLabel label_3 = new JLabel("Health");
		label_3.setBounds(240, 230, 66, 15);
		crewManager.getContentPane().add(label_3);
		
		JProgressBar progressHealth2 = new JProgressBar();
		progressHealth2.setForeground(Color.GREEN);
		progressHealth2.setBounds(318, 230, 92, 14);
		crewManager.getContentPane().add(progressHealth2);
		progressHealth2.setValue(100);
		
		JLabel label_4 = new JLabel("Tiredness");
		label_4.setBounds(240, 256, 68, 15);
		crewManager.getContentPane().add(label_4);
		
		JProgressBar progressTiredness2 = new JProgressBar();
		progressTiredness2.setBounds(318, 256, 93, 14);
		crewManager.getContentPane().add(progressTiredness2);
		
		JLabel label_5 = new JLabel("Hunger");
		label_5.setBounds(240, 283, 66, 15);
		crewManager.getContentPane().add(label_5);
		
		JProgressBar progressHunger2 = new JProgressBar();
		progressHunger2.setBounds(318, 283, 92, 14);
		crewManager.getContentPane().add(progressHunger2);
		
		JLabel label_6 = new JLabel("Actions");
		label_6.setBounds(240, 310, 66, 15);
		crewManager.getContentPane().add(label_6);
		
		JLabel lblAction2 = new JLabel(Integer.toString(crew2.getActions()));
		lblAction2.setBounds(318, 310, 66, 15);
		crewManager.getContentPane().add(lblAction2);
		
		JButton btnEat2 = new JButton("Eat");
		btnEat2.setBounds(259, 334, 151, 25);
		crewManager.getContentPane().add(btnEat2);
		
		JButton btnSleep2 = new JButton("Sleep");
		btnSleep2.setBounds(259, 371, 151, 25);
		crewManager.getContentPane().add(btnSleep2);
		
		JButton btnRepair2 = new JButton("Repair Ship");
		btnRepair2.setBounds(261, 408, 149, 25);
		crewManager.getContentPane().add(btnRepair2);
		
		JButton btnSearch2 = new JButton("Search Planet");
		btnSearch2.setBounds(259, 445, 149, 25);
		crewManager.getContentPane().add(btnSearch2);
		
		JButton btnPilot2 = new JButton("Pilot Ship");
		btnPilot2.setBounds(259, 482, 151, 25);
		crewManager.getContentPane().add(btnPilot2);
		
		JLabel lblShipStatus = new JLabel("Ship Status");
		lblShipStatus.setBounds(302, 548, 111, 15);
		crewManager.getContentPane().add(lblShipStatus);
		
		JLabel lblHealth_1 = new JLabel("Health");
		lblHealth_1.setBounds(240, 585, 66, 15);
		crewManager.getContentPane().add(lblHealth_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(301, 585, 183, 14);
		crewManager.getContentPane().add(progressBar);
		
		JLabel lblPartsFound = new JLabel("Parts Found");
		lblPartsFound.setBounds(199, 617, 91, 15);
		crewManager.getContentPane().add(lblPartsFound);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(302, 612, 182, 14);
		crewManager.getContentPane().add(progressBar_1);
		
		
		
		
		
		//Crewmember 3
		if (manager.getNumCrew() >= 3) {
			crew3 = manager.getCrewMember(2);
			JLabel lblName3 = new JLabel(crew3.getName());
			lblName3.setBounds(512, 180, 66, 15);
			crewManager.getContentPane().add(lblName3);
			
			JLabel label_8 = new JLabel("Class");
			label_8.setBounds(468, 207, 66, 15);
			crewManager.getContentPane().add(label_8);
			
			JLabel lblClass3 = new JLabel(crew3.getType());
			lblClass3.setBounds(561, 203, 66, 15);
			crewManager.getContentPane().add(lblClass3);
			
			JLabel label_10 = new JLabel("Health");
			label_10.setBounds(468, 230, 66, 15);
			crewManager.getContentPane().add(label_10);
			
			JProgressBar progressHealth3 = new JProgressBar();
			progressHealth3.setForeground(Color.GREEN);
			progressHealth3.setBounds(557, 230, 92, 14);
			crewManager.getContentPane().add(progressHealth3);
			progressHealth3.setValue(100);
			
			JLabel label_11 = new JLabel("Tiredness");
			label_11.setBounds(468, 256, 68, 15);
			crewManager.getContentPane().add(label_11);
			
			JProgressBar progressTiredness3 = new JProgressBar();
			progressTiredness3.setBounds(556, 257, 93, 14);
			crewManager.getContentPane().add(progressTiredness3);
			
			JLabel label_12 = new JLabel("Hunger");
			label_12.setBounds(468, 283, 66, 15);
			crewManager.getContentPane().add(label_12);
			
			JProgressBar progressHunger3 = new JProgressBar();
			progressHunger3.setBounds(557, 283, 92, 14);
			crewManager.getContentPane().add(progressHunger3);
			
			JLabel label_13 = new JLabel("Actions");
			label_13.setBounds(468, 310, 66, 15);
			crewManager.getContentPane().add(label_13);
			
			JLabel lblAction3 = new JLabel(Integer.toString(crew3.getActions()));
			lblAction3.setBounds(561, 310, 66, 15);
			crewManager.getContentPane().add(lblAction3);
			
			JButton btnEat3 = new JButton("Eat");
			btnEat3.setBounds(478, 334, 151, 25);
			crewManager.getContentPane().add(btnEat3);
			
			JButton btnSleep3 = new JButton("Sleep");
			btnSleep3.setBounds(478, 371, 151, 25);
			crewManager.getContentPane().add(btnSleep3);
			
			JButton btnRepair3 = new JButton("Repair Ship");
			btnRepair3.setBounds(478, 408, 149, 25);
			crewManager.getContentPane().add(btnRepair3);
			
			JButton btnSearch3 = new JButton("Search Planet");
			btnSearch3.setBounds(480, 445, 149, 25);
			crewManager.getContentPane().add(btnSearch3);
			
			JButton btnPilot3 = new JButton("Pilot Ship");
			btnPilot3.setBounds(478, 482, 151, 25);
			crewManager.getContentPane().add(btnPilot3);
		}
		
		
		
		
		//Crewmember 4
		if (manager.getNumCrew() >= 4) {
			crew4 = manager.getCrewMember(3);
			JLabel label_15 = new JLabel("Class");
			label_15.setBounds(666, 203, 66, 15);
			crewManager.getContentPane().add(label_15);
			
			JLabel lblClass4 = new JLabel(crew4.getType());
			lblClass4.setBounds(743, 203, 66, 15);
			crewManager.getContentPane().add(lblClass4);
			
			JLabel label_17 = new JLabel("Health");
			label_17.setBounds(666, 230, 66, 15);
			crewManager.getContentPane().add(label_17);
			
			JProgressBar progressHealth4 = new JProgressBar();
			progressHealth4.setForeground(Color.GREEN);
			progressHealth4.setBounds(743, 230, 92, 14);
			crewManager.getContentPane().add(progressHealth4);
			progressHealth4.setValue(100);
			
			JLabel label_18 = new JLabel("Tiredness");
			label_18.setBounds(664, 256, 68, 15);
			crewManager.getContentPane().add(label_18);
			
			JProgressBar progressTiredness4 = new JProgressBar();
			progressTiredness4.setBounds(742, 256, 93, 14);
			crewManager.getContentPane().add(progressTiredness4);
			
			JLabel label_19 = new JLabel("Hunger");
			label_19.setBounds(666, 283, 66, 15);
			crewManager.getContentPane().add(label_19);
			
			JProgressBar progressHunger4 = new JProgressBar();
			progressHunger4.setBounds(743, 283, 92, 14);
			crewManager.getContentPane().add(progressHunger4);
			
			JLabel label_20 = new JLabel("Actions");
			label_20.setBounds(666, 310, 66, 15);
			crewManager.getContentPane().add(label_20);
			
			JLabel lblAction4 = new JLabel(Integer.toString(crew4.getActions()));
			lblAction4.setBounds(743, 310, 66, 15);
			crewManager.getContentPane().add(lblAction4);
			
			JButton btnEat4 = new JButton("Eat");
			btnEat4.setBounds(684, 334, 151, 25);
			crewManager.getContentPane().add(btnEat4);
			
			JButton btnSleep4 = new JButton("Sleep");
			btnSleep4.setBounds(684, 371, 151, 25);
			crewManager.getContentPane().add(btnSleep4);
			
			JButton btnRepair4 = new JButton("Repair Ship");
			btnRepair4.setBounds(686, 408, 149, 25);
			crewManager.getContentPane().add(btnRepair4);
			
			JButton btnSearch4 = new JButton("Search Planet");
			btnSearch4.setBounds(684, 445, 149, 25);
			crewManager.getContentPane().add(btnSearch4);
			
			JButton btnPilot4 = new JButton("Pilot Ship");
			btnPilot4.setBounds(684, 482, 151, 25);
			crewManager.getContentPane().add(btnPilot4);
			
			JLabel lblName4 = new JLabel(crew4.getName());
			lblName4.setBounds(712, 180, 66, 15);
			crewManager.getContentPane().add(lblName4);
		}
		
		btnViewInventory.setBounds(25, 649, 156, 25);
		crewManager.getContentPane().add(btnViewInventory);
		
		JProgressBar progressDays = new JProgressBar();
		progressDays.setBounds(25, 26, 842, 14);
		crewManager.getContentPane().add(progressDays);
		
		JLabel lblProgress = new JLabel("Progress");
		lblProgress.setBounds(400, 12, 100, 15);
		crewManager.getContentPane().add(lblProgress);
		
		JButton btnFly = new JButton("Fly to Next Planet");
		btnFly.setBounds(25, 612, 156, 25);
		crewManager.getContentPane().add(btnFly);
		
		JLabel lblPlayerActions = new JLabel("Player Actions");
		lblPlayerActions.setBounds(52, 548, 105, 15);
		crewManager.getContentPane().add(lblPlayerActions);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crew1.getHungry();
				crew1.getTired();
				crew2.getHungry();
				crew2.getTired();
				if (manager.getNumCrew() >= 3) {
					crew3.getHungry();
					crew3.getTired();
				}
				if (manager.getNumCrew() >= 4) {
					crew4.getHungry();
					crew4.getTired();
				}
				
			}
		});
		btnNextDay.setBounds(25, 575, 156, 25);
		crewManager.getContentPane().add(btnNextDay);
		

		
		
		
		
		
		
		
		
		
		

		
	}
}

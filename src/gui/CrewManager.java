package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.Game;
import main.RNGEvent;
import main.Ship;
import main.Types.CrewMember;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	private JProgressBar progressHunger3;
	private JProgressBar progressHunger4;
	private JProgressBar progressTiredness3;
	private JProgressBar progressTiredness4;
	private JProgressBar progressShipHealth;
	private JLabel lblAction3;
	private JLabel lblAction4;
	public static ArrayList<CrewMember> pilotList = new ArrayList<CrewMember>();
	public JTextPane txtConsole;
	public Ship myShip;
	public RNGEvent event = new RNGEvent();  
	
	


	/**
	 * Create the application.
	 */
	public CrewManager(Game incomingManager) {
		manager = incomingManager;
		initialize();
		crewManager.setVisible(true);
	}
	
	/**
	 * Methods to run random events
	 */
	public void eventPirate() {
		if (event.spacePirates(myShip) == "Gunner Pass") {
			String currentText = txtConsole.getText();
			txtConsole.setText(currentText + "\nYour gunner protected the ship from pirates.");
		}
		else if (event.spacePirates(myShip) == "Gunner Fail") {
			
			String currentText = txtConsole.getText();
			txtConsole.setText(currentText + "\nYour ship was attacked by pirates, I think they"
					+ " took something!");	
		} else {
			;
		}
	}
	
	public void eventAids() {
		
	}
	
	public void eventBelt() {
		if (event.asteroidBelt(myShip) == "Pilot Pass") {
			String currentText = txtConsole.getText();
			txtConsole.setText(currentText + "\nYour pilot avoided an asteroid belt.");
		} else if (event.asteroidBelt(myShip) == "Pilot Fail") {
			String currentText = txtConsole.getText();
			txtConsole.setText(currentText + "\nYour ship was damaged by an asteroid belt.");
		} else {
			;
		}
	}
	
	
	/**
	 * Window manager methods
	 */
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
	 * Console print methods
	 */
	public void printNoRepair() {
		String currentText = txtConsole.getText();
		txtConsole.setText(currentText + "\nThe ship does not need repairing.");
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		myShip = manager.getShip();
		crewManager = new JFrame();
		crewManager.setTitle(manager.getShipName() + "Crew Manager");
		crewManager.setBounds(100, 100, 900, 769);
		crewManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crewManager.getContentPane().setLayout(null);
		

				
		/**
		 * Console initialise
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(543, 548, 321, 159);
		crewManager.getContentPane().add(scrollPane);
		
		txtConsole = new JTextPane();
		txtConsole.setText("Welcome to day 1 Captain");
		txtConsole.setEditable(false);
		scrollPane.setViewportView(txtConsole);
		
		/**
		 * CrewMember 1
		 */
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
		
		/**
		 * Use item
		 */
		JButton btnEat1 = new JButton("Use Item");
		btnEat1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (crew1.getActions() > 0) {
					if (Ship.Inventory.size() > 0) {
					manager.launchUseItem();
					}
					else {
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + "You do not currently have any items to use");
					}
				}
				else {
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + crew1.getName() + " does not have enough actions to use item");
				}
			}
		});
		btnEat1.setBounds(52, 334, 151, 25);
		crewManager.getContentPane().add(btnEat1);
		
		/**
		 * Sleep
		 */
		JButton btnSleep1 = new JButton("Sleep");
		btnSleep1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (crew1.getActions() > 0) {
					crew1.sleep();
					progressTiredness1.setValue(crew1.getTiredness());
					crew1.useAction();
					lblAction1.setText(Integer.toString(crew1.getActions()));
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + crew1.getName() + " had a dnap.");
				} else {
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + crew1.getName() + " does not have enough actions to sleep.");
				}
				
			}
		});
		btnSleep1.setBounds(52, 371, 151, 25);
		crewManager.getContentPane().add(btnSleep1);
		
		/**
		 * Repair
		 */
		JButton btnRepair1 = new JButton("Repair Ship");
		btnRepair1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (myShip.checkCondition() == 0) {
					printNoRepair();
				}
				else if (crew1.getActions() > 0) {
					crew1.useAction();
					lblAction1.setText(Integer.toString(crew1.getActions()));
					if (crew1.getType() == "Engineer") {
						myShip.shipRepair("Engineer");
					} else {
						myShip.shipRepair("");
					}
				} else {
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + crew1.getName() + " does not have enough actions to repair the ship.");
				}
				progressShipHealth.setValue(myShip.checkCondition());
			}
		});
		btnRepair1.setBounds(54, 408, 149, 25);
		crewManager.getContentPane().add(btnRepair1);
		
		
		/**
		 * Search planet
		 */
		JButton btnSearch1 = new JButton("Search Planet");
		btnSearch1.setBounds(54, 445, 149, 25);
		crewManager.getContentPane().add(btnSearch1);
		
		/**
		 * Pilot ship
		 */
		JButton btnPilot1 = new JButton("Pilot Ship");
		btnPilot1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (pilotList.contains(crew1)) {
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + crew1.getName() + " is already in the cockpit.");
				}
				else if (pilotList.size() >= 2){
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + "The cockpit is full!");
				}
				else if ((crew1.getActions() > 0) && (!pilotList.contains(crew1))) {
					pilotList.add(crew1);
					crew1.useAction();
					lblAction1.setText(Integer.toString(crew1.getActions()));
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + crew1.getName() + " is now in the cockpit.");
				} else if (crew1.getActions() <= 0) {
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + crew1.getName() + " does not have enough actions to fly.");
				} 
				
			}
		});
		btnPilot1.setBounds(52, 482, 151, 25);
		crewManager.getContentPane().add(btnPilot1);
		
		/**
		 * Crew1 labels
		 */
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
		
		
		
		/**
		 * CrewMember 2
		 */
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
		
		/**
		 * Use item
		 */
		JButton btnEat2 = new JButton("Use Item");
		btnEat2.setBounds(259, 334, 151, 25);
		crewManager.getContentPane().add(btnEat2);
		
		/**
		 * Sleep
		 */
		JButton btnSleep2 = new JButton("Sleep");
		btnSleep2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (crew2.getActions() > 0) {
					crew2.sleep();
					progressTiredness2.setValue(crew2.getTiredness());
					crew2.useAction();
					lblAction2.setText(Integer.toString(crew2.getActions()));
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + crew2.getName() + " had a nap.");
				} else if (pilotList.size() > 2){
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + crew2.getName() + " does not have enough actions to sleep.");
				}
			}
		});
		btnSleep2.setBounds(259, 371, 151, 25);
		crewManager.getContentPane().add(btnSleep2);
		
		/**
		 * Repair ship
		 */
		JButton btnRepair2 = new JButton("Repair Ship");
		btnRepair2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (myShip.checkCondition() == 0) {
					printNoRepair();
				}
				else if (crew2.getActions() > 0) {
					crew2.useAction();
					lblAction2.setText(Integer.toString(crew2.getActions()));
					if (crew2.getType() == "Engineer") {
						myShip.shipRepair("Engineer");
					} else {
						myShip.shipRepair("");
					}
				} else {
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + crew2.getName() + " does not have enough actions to repair the ship.");
				}
				progressShipHealth.setValue(myShip.checkCondition());
			}
		});
		btnRepair2.setBounds(261, 408, 149, 25);
		crewManager.getContentPane().add(btnRepair2);
		
		/**
		 * Search planet
		 */
		JButton btnSearch2 = new JButton("Search Planet");
		btnSearch2.setBounds(259, 445, 149, 25);
		crewManager.getContentPane().add(btnSearch2);
		
		/**
		 * Pilot Ship
		 */
		JButton btnPilot2 = new JButton("Pilot Ship");
		btnPilot2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (pilotList.contains(crew2)) {
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + crew2.getName() + " is already in the cockpit.");
				}
				else if (pilotList.size() >= 2){
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + "The cockpit is full!");
				}
				else if ((crew2.getActions() > 0) && (!pilotList.contains(crew2))) {
					pilotList.add(crew2);
					crew2.useAction();
					lblAction2.setText(Integer.toString(crew2.getActions()));
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + crew2.getName() + " is now in the cockpit.");
				} else if (crew2.getActions() <= 0) {
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + crew2.getName() + " does not have enough actions to fly.");
				}
				
			}
		});
		btnPilot2.setBounds(259, 482, 151, 25);
		crewManager.getContentPane().add(btnPilot2);
		
		/**
		 * CrewMember 3		
		 */
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
			
			progressTiredness3 = new JProgressBar();
			progressTiredness3.setBounds(556, 257, 93, 14);
			crewManager.getContentPane().add(progressTiredness3);
			
			JLabel label_12 = new JLabel("Hunger");
			label_12.setBounds(468, 283, 66, 15);
			crewManager.getContentPane().add(label_12);
			
			progressHunger3 = new JProgressBar();
			progressHunger3.setBounds(557, 283, 92, 14);
			crewManager.getContentPane().add(progressHunger3);
			
			JLabel label_13 = new JLabel("Actions");
			label_13.setBounds(468, 310, 66, 15);
			crewManager.getContentPane().add(label_13);
			
			lblAction3 = new JLabel(Integer.toString(crew3.getActions()));
			lblAction3.setBounds(561, 310, 66, 15);
			crewManager.getContentPane().add(lblAction3);
			
			/**
			 * Use item
			 */
			JButton btnEat3 = new JButton("Use Item");
			btnEat3.setBounds(478, 334, 151, 25);
			crewManager.getContentPane().add(btnEat3);
			
			/**
			 * Sleep
			 */
			JButton btnSleep3 = new JButton("Sleep");
			btnSleep3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (crew3.getActions() > 0) {
						crew3.sleep();
						progressTiredness3.setValue(crew3.getTiredness());
						crew3.useAction();
						lblAction3.setText(Integer.toString(crew3.getActions()));
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + crew3.getName() + " had a nap.");
					} else {
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + crew3.getName() + " does not have enough actions to sleep.");
					}
				}
			});
			btnSleep3.setBounds(478, 371, 151, 25);
			crewManager.getContentPane().add(btnSleep3);
			
			/**
			 * Repair ship
			 */
			JButton btnRepair3 = new JButton("Repair Ship");
			btnRepair3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (myShip.checkCondition() == 0) {
						printNoRepair();
					}
					else if (crew3.getActions() > 0) {
						crew3.useAction();
						lblAction3.setText(Integer.toString(crew3.getActions()));
						if (crew3.getType() == "Engineer") {
							myShip.shipRepair("Engineer");
						} else {
							myShip.shipRepair("");
						}
					} else {
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + crew3.getName() + " does not have enough actions to repair the ship.");
					}
					progressShipHealth.setValue(myShip.checkCondition());
				}
			});
			btnRepair3.setBounds(478, 408, 149, 25);
			crewManager.getContentPane().add(btnRepair3);
			
			/**
			 * Search planet
			 */
			JButton btnSearch3 = new JButton("Search Planet");
			btnSearch3.setBounds(480, 445, 149, 25);
			crewManager.getContentPane().add(btnSearch3);
			
			/**
			 * Pilot Ship
			 */
			JButton btnPilot3 = new JButton("Pilot Ship");
			btnPilot3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if (pilotList.contains(crew3)) {
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + crew3.getName() + " is already in the cockpit.");
					}
					else if (pilotList.size() >= 2){
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + "The cockpit is full!");
					}
					else if ((crew3.getActions() > 0) && (!pilotList.contains(crew3))) {
						pilotList.add(crew3);
						crew3.useAction();
						lblAction3.setText(Integer.toString(crew3.getActions()));
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + crew3.getName() + " is now in the cockpit.");
					} else if (crew3.getActions() <= 0) {
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + crew3.getName() + " does not have enough actions to fly.");
					}
					
				}
			});
			btnPilot3.setBounds(478, 482, 151, 25);
			crewManager.getContentPane().add(btnPilot3);
		}
		
		
		/**
		 * CrewMember 4
		 */
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
			
			progressTiredness4 = new JProgressBar();
			progressTiredness4.setBounds(742, 256, 93, 14);
			crewManager.getContentPane().add(progressTiredness4);
			
			JLabel label_19 = new JLabel("Hunger");
			label_19.setBounds(666, 283, 66, 15);
			crewManager.getContentPane().add(label_19);
			
			progressHunger4 = new JProgressBar();
			progressHunger4.setBounds(743, 283, 92, 14);
			crewManager.getContentPane().add(progressHunger4);
			
			JLabel label_20 = new JLabel("Actions");
			label_20.setBounds(666, 310, 66, 15);
			crewManager.getContentPane().add(label_20);
			
			lblAction4 = new JLabel(Integer.toString(crew4.getActions()));
			lblAction4.setBounds(743, 310, 66, 15);
			crewManager.getContentPane().add(lblAction4);
			
			/**
			 * Use item
			 */
			JButton btnEat4 = new JButton("Use Item");
			btnEat4.setBounds(684, 334, 151, 25);
			crewManager.getContentPane().add(btnEat4);
			
			/**
			 * Sleep
			 */
			JButton btnSleep4 = new JButton("Sleep");
			btnSleep4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (crew4.getActions() > 0) {
						crew4.sleep();
						progressTiredness4.setValue(crew4.getTiredness());
						crew4.useAction();
						lblAction4.setText(Integer.toString(crew4.getActions()));
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + crew4.getName() + " had a nap.");
					} else {
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + crew4.getName() + " does not have enough actions to sleep.");
					}
				}
			});
			btnSleep4.setBounds(684, 371, 151, 25);
			crewManager.getContentPane().add(btnSleep4);
			
			/**
			 * Repair
			 */
			JButton btnRepair4 = new JButton("Repair Ship");
			btnRepair4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (myShip.checkCondition() == 0) {
						printNoRepair();
					}
					else if (crew4.getActions() > 0) {
						crew4.useAction();
						lblAction4.setText(Integer.toString(crew4.getActions()));
						if (crew4.getType() == "Engineer") {
							myShip.shipRepair("Engineer");
						} else {
							myShip.shipRepair("");
						}
					} else {
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + crew4.getName() + " does not have enough actions to repair the ship.");
					}
					progressShipHealth.setValue(myShip.checkCondition());
				}
			});
			btnRepair4.setBounds(686, 408, 149, 25);
			crewManager.getContentPane().add(btnRepair4);
			
			/**
			 * Search Planet
			 */
			JButton btnSearch4 = new JButton("Search Planet");
			btnSearch4.setBounds(684, 445, 149, 25);
			crewManager.getContentPane().add(btnSearch4);
			
			/**
			 * Pilot Ship
			 */
			JButton btnPilot4 = new JButton("Pilot Ship");
			btnPilot4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if (pilotList.contains(crew4)) {
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + crew4.getName() + " is already in the cockpit.");
					}
					else if (pilotList.size() >= 2){
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + "The cockpit is full!");
					}
					else if ((crew4.getActions() > 0) && (!pilotList.contains(crew4))) {
						pilotList.add(crew4);
						crew4.useAction();
						lblAction4.setText(Integer.toString(crew4.getActions()));
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + crew4.getName() + " is now in the cockpit.");
					} else if (crew4.getActions() <= 0) {
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + crew4.getName() + " does not have enough actions to fly.");
					} 
					
				}
			});
			btnPilot4.setBounds(684, 482, 151, 25);
			crewManager.getContentPane().add(btnPilot4);
			
			JLabel lblName4 = new JLabel(crew4.getName());
			lblName4.setBounds(712, 180, 66, 15);
			crewManager.getContentPane().add(lblName4);
		}
		
		/**
		 * Stats for player
		 */
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
		btnViewInventory.setBounds(25, 649, 156, 25);
		crewManager.getContentPane().add(btnViewInventory);
		
		JProgressBar progressDays = new JProgressBar();
		progressDays.setForeground(Color.BLUE);
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
		
		/**
		 * Game stats
		 */
		JLabel lblShipStatus = new JLabel("Ship Status");
		lblShipStatus.setBounds(302, 548, 111, 15);
		crewManager.getContentPane().add(lblShipStatus);
		

		JLabel lblHealth_1 = new JLabel("Damage");
		lblHealth_1.setBounds(240, 585, 66, 15);
		crewManager.getContentPane().add(lblHealth_1);
		
		progressShipHealth = new JProgressBar();
		progressShipHealth.setForeground(Color.RED);
		progressShipHealth.setBounds(301, 585, 183, 14);
		crewManager.getContentPane().add(progressShipHealth);
		progressShipHealth.setValue(0);
		
		JLabel lblPartsFound = new JLabel("Parts Found");
		lblPartsFound.setBounds(199, 643, 91, 15);
		crewManager.getContentPane().add(lblPartsFound);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(291, 644, 182, 14);
		crewManager.getContentPane().add(progressBar_1);
		
		/**
		 * NEXT DAY BUTTON 
		 */
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtConsole.setText("Welcome to day " + (manager.getcurrentDay() + 1) + " Captain" );
				
				eventPirate();
				
				pilotList = new ArrayList<CrewMember>();
				crew1.resetActions();
				lblAction1.setText(Integer.toString(crew1.getActions()));
				crew1.getHungry();
				progressHunger1.setValue(crew1.getHunger());
				crew1.getTired();
				progressTiredness1.setValue(crew1.getTiredness());
				crew2.resetActions();
				lblAction2.setText(Integer.toString(crew2.getActions()));
				crew2.getHungry();
				progressHunger2.setValue(crew2.getHunger());
				crew2.getTired();
				progressTiredness2.setValue(crew2.getTiredness());
				if (manager.getNumCrew() >= 3) {
					crew3.getHungry();
					progressHunger3.setValue(crew3.getHunger());
					crew3.getTired();
					progressTiredness3.setValue(crew3.getTiredness());
					crew3.resetActions();
					lblAction3.setText(Integer.toString(crew3.getActions()));
				}
				if (manager.getNumCrew() >= 4) {
					crew4.getHungry();
					crew4.resetActions();
					lblAction4.setText(Integer.toString(crew4.getActions()));
					progressHunger4.setValue(crew4.getHunger());
					crew4.getTired();
					progressTiredness4.setValue(crew4.getTiredness());
				}
				manager.addDay();
				progressShipHealth.setValue(myShip.checkCondition());
				int dayStatus = (int) ((double)manager.getcurrentDay()/(double)manager.getnumberDays()*100);
				progressDays.setValue(dayStatus);
				
			}
		});
		btnNextDay.setBounds(25, 575, 156, 25);
		crewManager.getContentPane().add(btnNextDay);
		
		JLabel label = new JLabel("4/5");
		label.setBounds(371, 673, 66, 15);
		crewManager.getContentPane().add(label);
		
		
		
	}
	
}

package gui;

import javax.swing.JFrame;

import main.Game;
import main.Planet;
import main.RNGEvent;
import main.Ship;
import main.SpaceOutpost;
import main.Types.CrewMember;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Font;

// TODO: Auto-generated Javadoc
/**
 * The Class CrewManager.
 */
public class CrewManager {

	/** The crew manager. */
	private JFrame crewManager;
	
	/** The manager. */
	private Game manager;
	
	/** The crew 1. */
	private CrewMember crew1;
	
	/** The crew 2. */
	private CrewMember crew2;
	
	/** The crew 3. */
	private CrewMember crew3;
	
	/** The crew 4. */
	private CrewMember crew4;
	
	/** The progress hunger 1. */
	private JProgressBar progressHunger1;
	
	/** The progress hunger 2. */
	private JProgressBar progressHunger2;
	
	/** The progress hunger 3. */
	private JProgressBar progressHunger3;
	
	/** The progress hunger 4. */
	private JProgressBar progressHunger4;
	
	/** The progress tiredness 3. */
	private JProgressBar progressTiredness3;
	
	/** The progress tiredness 4. */
	private JProgressBar progressTiredness4;
	
	/** The progress ship health. */
	private JProgressBar progressShipHealth;
	
	/** The progress health 1. */
	private JProgressBar progressHealth1;
	
	/** The progress health 2. */
	private JProgressBar progressHealth2;
	
	/** The progress health 3. */
	private JProgressBar progressHealth3;
	
	/** The progress health 4. */
	private JProgressBar progressHealth4;
	
	/** The progress parts. */
	private JProgressBar progressParts;
	
	/** The btn eat 3. */
	private JButton btnEat3;
	
	/** The btn sleep 3. */
	private JButton btnSleep3;
	
	/** The btn repair 3. */
	private JButton btnRepair3;
	
	/** The btn search 3. */
	private JButton btnSearch3;
	
	/** The btn pilot 3. */
	private JButton btnPilot3;
	
	/** The btn eat 4. */
	private JButton btnEat4;
	
	/** The btn sleep 4. */
	private JButton btnSleep4;
	
	/** The btn repair 4. */
	private JButton btnRepair4;
	
	/** The btn search 4. */
	private JButton btnSearch4;
	
	/** The btn pilot 4. */
	private JButton btnPilot4;
	
	/** The lbl planet. */
	private JLabel lblPlanet;
	
	/** The lbl parts. */
	private JLabel lblParts;
	
	/** The lbl action 3. */
	private JLabel lblAction3;
	
	/** The lbl action 4. */
	private JLabel lblAction4;
	
	/** The pilot list. */
	public static ArrayList<CrewMember> pilotList = new ArrayList<CrewMember>();
	
	/** The crew list. */
	private static ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();
	
	/** The txt console. */
	private JTextPane txtConsole;
	
	/** The my ship. */
	private Ship myShip;
	
	/** The event. */
	private RNGEvent event = new RNGEvent();
	
	/** The current planet. */
	private Planet currentPlanet = new Planet();
	
	/** The space outpost. */
	private SpaceOutpost spaceOutpost = new SpaceOutpost();
    
    /** The rand. */
    private Random rand = new Random();
	
	/** The max parts. */
	private int maxParts;
	
	/** The rand num. */
	private double randNum;
	
	
	


	/**
	 * Instantiates a new crew manager.
	 *
	 * @param incomingManager the incoming manager
	 */
	public CrewManager(Game incomingManager) {
		manager = incomingManager;
		crewList = new ArrayList<CrewMember>();
		pilotList = new ArrayList<CrewMember>();
		initialize();
		crewManager.setVisible(true);
	}
	
	
	
	/**
	 * Game over.
	 *
	 * @param myShip the my ship
	 */
	public void gameOver(Ship myShip) {
		GameOver gameOver = new GameOver(myShip);
		closeWindow();
	}
	
	/**
	 * Check end game.
	 */
	public void checkEndGame() {
		if (manager.getcurrentDay() == manager.getnumberDays()) {
			gameOver(myShip);
		}
		if (myShip.checkCondition() >= 100) {	
			gameOver(myShip);
		}
		if (Ship.crewList.size() == 0) {
			gameOver(myShip);
		}
	}
	
	/**
	 * Check win.
	 */
	public void checkWin() {
		if (myShip.getParts() == maxParts) {
			WinGame winGame = new WinGame();
			closeWindow();
		}
	}
	
	/**
	 * Event pirate.
	 */
	
	/**
	 * Encounter Space Pirates
	 */
	public void eventPirate() {
		if (event.spacePirates(myShip) == "Gunner Pass") {
			String currentText = txtConsole.getText();
			txtConsole.setText(currentText + "\nYour gunner protected the ship from pirates.");
		}
		else if (event.spacePirates(myShip) == "Gunner Fail") {
        	myShip.shipDamage(10);
        	checkEndGame();
			String currentText = txtConsole.getText();
			txtConsole.setText(currentText + "\nYour ship was attacked by pirates, I think they"
					+ " took something!");	
		} else if (event.spacePirates(myShip) == "Fail")  {
			int maxIndex = Ship.Inventory.size() - 1;
    		randNum = Math.random() * ((maxIndex - 1) + 1) + 0;
    		Ship.Inventory.remove((int) randNum);
    		myShip.shipDamage(10);
        	checkEndGame();
			String currentText = txtConsole.getText();
			txtConsole.setText(currentText + "\nYour ship was attacked by pirates, I think they"
					+ " took something!");	
		}
	}
	
	/**
	 * Event aids.
	 */
	public void eventAids() {
		for (CrewMember member : crewList) {
			if (event.spaceAids(member)) {
				String currentText = txtConsole.getText();
				txtConsole.setText(currentText + "\n" + member.getName() + " contracted space aids");
			} else {
				;
			}
		}
	}
	
	/**
	 * Event asteroid belt.
	 */
	public void eventBelt() {
		if (event.asteroidBelt(myShip) == "Pilot Pass") {
			String currentText = txtConsole.getText();
			txtConsole.setText(currentText + "\nYour pilot avoided an asteroid belt.");
		} else if (event.asteroidBelt(myShip) == "Pilot Fail") {
			int damage = myShip.checkCondition() / 2;
			myShip.shipDamage(damage);
			checkEndGame();
			progressShipHealth.setValue(myShip.checkCondition());
			String currentText = txtConsole.getText();
			txtConsole.setText(currentText + "\nYour ship was damaged by an asteroid belt.");
		} else {
			;
		}
	}
	
	/**
	 * Search planet.
	 *
	 * @param member the member
	 */
	public void searchPlanet(CrewMember member) {
		int foundID = (int) (Math.random() * 4 + 1);
		if (member.getType() == "Scout") {
			if (foundID == 1) {
				foundID += 1;
			}
		}
		if (currentPlanet.checkSearched() == true) {
			String currentText = txtConsole.getText();
			txtConsole.setText(currentText + "\nPlanet " + currentPlanet.getplanetName() +
					" has already been searched");
		}
		else {
			if (event.planetSearch(member, foundID) == "Found Nothing") {
				currentPlanet.setSearched();
				member.useAction();
				String currentText = txtConsole.getText();
				txtConsole.setText(currentText + "\n" + member.getName() + " found nothing while searching " + currentPlanet.getplanetName() + ".");
			}
			else if (event.planetSearch(member, foundID) == "Found Money") {
				currentPlanet.setSearched();
				member.useAction();
				myShip.addMoney(10);
				String currentText = txtConsole.getText();
				txtConsole.setText(currentText + "\n" + member.getName() + " found some money while searching " + currentPlanet.getplanetName() + ".");
			}
			else if (event.planetSearch(member, foundID) == "Found Item") {
				currentPlanet.setSearched();
				member.useAction();
				int index = rand.nextInt(8);
				index += 1;
				Ship.Inventory.add(spaceOutpost.purchase(RNGEvent.foundItem.get(index)));
				String currentText = txtConsole.getText();
				txtConsole.setText(currentText + "\n" + member.getName() + " found an item while searching " + currentPlanet.getplanetName() + ".");
			}
			else if (event.planetSearch(member, foundID) == "Found Part") {
				currentPlanet.setSearched();
				member.useAction();
				myShip.addParts();
				checkWin();
				int partsStatus = (int) ((double)myShip.getParts()/(double)maxParts *100);
				progressParts.setValue(partsStatus);
				lblParts.setText(myShip.getParts() + "/" + maxParts);
				String currentText = txtConsole.getText();
				txtConsole.setText(currentText + "\n" + member.getName() + " found a transporter part while searching " + currentPlanet.getplanetName() + ".");
			}
		}
	}
	
	/**
	 * Check if crew member dead.
	 *
	 * @param member the member
	 * @return true, if successful
	 */
	public boolean checkDead(CrewMember member) {
		if (member.isDead()) {
			return true;
		}
		else if ((member.getHealth() == 0) || (member.getHunger() == 100) || (member.getTiredness() == 100)) {
			member.setDead();
			Ship.crewList.remove(member);
			checkEndGame();
			String currentText = txtConsole.getText();
			txtConsole.setText(currentText + "\n" + member.getName() + " died. RIP.");
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Update crew bars.
	 */
	public void updateBars() {
		progressHealth1.setValue(crew1.getHealth());
		progressHunger1.setValue(crew1.getHunger());
		progressHealth2.setValue(crew2.getHealth());
		progressHunger2.setValue(crew2.getHunger());
		if (crewList.size() >= 3) {
			progressHealth3.setValue(crew3.getHealth());
			progressHunger3.setValue(crew3.getHunger());
		}
		if (crewList.size() >= 4) {
		progressHealth4.setValue(crew4.getHealth());
		progressHunger4.setValue(crew4.getHunger());
		}
	}
	
	/**
	 * Update gui if crewmember is cured.
	 *
	 * @param member the member
	 */
	public void cured(CrewMember member) {
		String currentText = txtConsole.getText();
		txtConsole.setText(currentText + "\n" + member.getName() + " has been cured.");
		int index = crewList.indexOf(member);
		switch (index) {
			case 0:
				progressHealth1.setForeground(Color.GREEN);
				break;
			case 1:
				progressHealth2.setForeground(Color.GREEN);
				break;
			case 2:
				progressHealth3.setForeground(Color.GREEN);
				break;
			case 3:
				progressHealth4.setForeground(Color.GREEN);
				break;
		}
	}
	
	
	/**
	 * Close window.
	 */
	public void closeWindow() {
		crewManager.dispose();
	}
	
	/**
	 * Finished window.
	 */
	public void finishedWindow() {
		manager.closeCrewManager(this);
	}
	
	/**
	 * Return this.
	 *
	 * @return the crew manager
	 */
	public CrewManager returnThis() {
		return this;
	}
	
	
	/**
	 * Prints the no repair needed message.
	 */
	public void printNoRepair() {
		String currentText = txtConsole.getText();
		txtConsole.setText(currentText + "\nThe ship does not need repairing.");
	}
	
    /**
     * Launch use item.
     *
     * @param member the member
     */
    public void launchUseItem(CrewMember member) {
    	UseItem useWindow = new UseItem(this, member);
    }
	
	/**
	 * Initialize.
	 */
	private void initialize() {
		myShip = manager.getShip();
		maxParts = manager.getnumberDays() / 3 * 2;
		crewManager = new JFrame();
		crewManager.setTitle(manager.getShipName() + " Crew Manager");
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
		crewList.add(crew1);
		JLabel lblName1 = new JLabel(crew1.getName());
		lblName1.setBounds(79, 180, 66, 15);
		crewManager.getContentPane().add(lblName1);
		
		progressHealth1 = new JProgressBar();
		progressHealth1.setForeground(Color.GREEN);
		progressHealth1.setBounds(100, 230, 92, 14);
		crewManager.getContentPane().add(progressHealth1);
		progressHealth1.setValue(100);

		
		JProgressBar progressTiredness1 = new JProgressBar();
		progressTiredness1.setBounds(100, 257, 93, 14);
		crewManager.getContentPane().add(progressTiredness1);
		
		progressHunger1 = new JProgressBar();
		progressHunger1.setBounds(100, 283, 92, 14);
		crewManager.getContentPane().add(progressHunger1);
		
		JLabel lblAction1 = new JLabel(Integer.toString(crew1.getActions()));
		lblAction1.setBounds(103, 310, 66, 15);
		crewManager.getContentPane().add(lblAction1);
		
		/**
		 * Crew 1 Use item
		 */
		JButton btnEat1 = new JButton("Use Item");
		btnEat1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (crew1.getActions() > 0) {
					if (Ship.Inventory.size() > 0) {
						crew1.useAction();
						lblAction1.setText(Integer.toString(crew1.getActions()));
						launchUseItem(crew1);
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
		 * Crew 1 Sleep
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
		 * Crew 1 Repair
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
		 * Crew 1 Search planet
		 */
		JButton btnSearch1 = new JButton("Search Planet");
		btnSearch1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (crew1.getActions() > 0){
				searchPlanet(crew1);
				lblAction1.setText(Integer.toString(crew1.getActions()));
				}
				else {
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + crew1.getName() + " does not have enough actions to search planet.");
				}
				
			}
		});
		btnSearch1.setBounds(54, 445, 149, 25);
		crewManager.getContentPane().add(btnSearch1);
		
		/**
		 * Crew 1 Pilot ship
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
		crewList.add(crew2);
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
		
		progressHealth2 = new JProgressBar();
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
		
		progressHunger2 = new JProgressBar();
		progressHunger2.setBounds(318, 283, 92, 14);
		crewManager.getContentPane().add(progressHunger2);
		
		JLabel label_6 = new JLabel("Actions");
		label_6.setBounds(240, 310, 66, 15);
		crewManager.getContentPane().add(label_6);
		
		JLabel lblAction2 = new JLabel(Integer.toString(crew2.getActions()));
		lblAction2.setBounds(318, 310, 66, 15);
		crewManager.getContentPane().add(lblAction2);
		
		/**
		 * Crew 2 Use item
		 */
		JButton btnEat2 = new JButton("Use Item");
		btnEat2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (crew2.getActions() > 0) {
					if (Ship.Inventory.size() > 0) {
						crew2.useAction();
						lblAction2.setText(Integer.toString(crew2.getActions()));
						launchUseItem(crew2);
					}
					else {
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + "You do not currently have any items to use");
					}
				}
				else {
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + crew2.getName() + " does not have enough actions to use item");
				}
			}
		});
		btnEat2.setBounds(259, 334, 151, 25);
		crewManager.getContentPane().add(btnEat2);
		
		/**
		 * Crew 2 Sleep
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
		 * Crew 2 Repair ship
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
		 * Crew 2 Search planet
		 */
		JButton btnSearch2 = new JButton("Search Planet");
		btnSearch2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (crew2.getActions() > 0){
					searchPlanet(crew2);
					lblAction2.setText(Integer.toString(crew2.getActions()));
					}
					else {
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + crew2.getName() + " does not have enough actions to search planet.");
					}
			}
		});
		btnSearch2.setBounds(259, 445, 149, 25);
		crewManager.getContentPane().add(btnSearch2);
		
		/**
		 * Crew 2 Pilot Ship
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
			crewList.add(crew3);
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
			
			progressHealth3 = new JProgressBar();
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
			 * Crew 3 Use item
			 */
			btnEat3 = new JButton("Use Item");
			btnEat3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (crew3.getActions() > 0) {
						if (Ship.Inventory.size() > 0) {
							crew3.useAction();
							lblAction3.setText(Integer.toString(crew3.getActions()));
							launchUseItem(crew3);
						}
						else {
							String currentText = txtConsole.getText();
							txtConsole.setText(currentText + "\n" + "You do not currently have any items to use");
						}
					}
					else {
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + crew3.getName() + " does not have enough actions to use item");
					}
				}
			});
			btnEat3.setBounds(478, 334, 151, 25);
			crewManager.getContentPane().add(btnEat3);
			
			/**
			 * Crew 3 Sleep
			 */
			btnSleep3 = new JButton("Sleep");
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
			 * crew 3 Repair ship
			 */
			btnRepair3 = new JButton("Repair Ship");
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
			 * Crew 3 Search planet
			 */
			btnSearch3 = new JButton("Search Planet");
			btnSearch3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (crew3.getActions() > 0){
						searchPlanet(crew3);
						lblAction3.setText(Integer.toString(crew3.getActions()));
						}
						else {
							String currentText = txtConsole.getText();
							txtConsole.setText(currentText + "\n" + crew3.getName() + " does not have enough actions to search planet.");
						}
				}
			});
			btnSearch3.setBounds(480, 445, 149, 25);
			crewManager.getContentPane().add(btnSearch3);
			
			/**
			 * Crew 3 Pilot Ship
			 */
			btnPilot3 = new JButton("Pilot Ship");
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
			crewList.add(crew4);
			JLabel label_15 = new JLabel("Class");
			label_15.setBounds(666, 203, 66, 15);
			crewManager.getContentPane().add(label_15);
			
			JLabel lblClass4 = new JLabel(crew4.getType());
			lblClass4.setBounds(743, 203, 66, 15);
			crewManager.getContentPane().add(lblClass4);
			
			JLabel label_17 = new JLabel("Health");
			label_17.setBounds(666, 230, 66, 15);
			crewManager.getContentPane().add(label_17);
			
			progressHealth4 = new JProgressBar();
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
			 * Crew 4 Use item
			 */
			btnEat4 = new JButton("Use Item");
			btnEat4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (crew4.getActions() > 0) {
						if (Ship.Inventory.size() > 0) {
						crew4.useAction();
						lblAction4.setText(Integer.toString(crew4.getActions()));
						launchUseItem(crew4);
						}
						else {
							String currentText = txtConsole.getText();
							txtConsole.setText(currentText + "\n" + "You do not currently have any items to use");
						}
					}
					else {
						String currentText = txtConsole.getText();
						txtConsole.setText(currentText + "\n" + crew4.getName() + " does not have enough actions to use item");
					}
				}
			});
			btnEat4.setBounds(684, 334, 151, 25);
			crewManager.getContentPane().add(btnEat4);
			
			/**
			 * Crew 4 Sleep
			 */
			btnSleep4 = new JButton("Sleep");
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
			 * Crew 4 Repair
			 */
			btnRepair4 = new JButton("Repair Ship");
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
			 * Crew 4 Search Planet
			 */
			btnSearch4 = new JButton("Search Planet");
			btnSearch4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (crew4.getActions() > 0){
						searchPlanet(crew4);
						lblAction4.setText(Integer.toString(crew4.getActions()));
						}
						else {
							String currentText = txtConsole.getText();
							txtConsole.setText(currentText + "\n" + crew4.getName() + " does not have enough actions to search planet.");
						}
				}
			});
			btnSearch4.setBounds(684, 445, 149, 25);
			crewManager.getContentPane().add(btnSearch4);
			
			/**
			 * Crew 4 Pilot Ship
			 */
			btnPilot4 = new JButton("Pilot Ship");
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
		
		JLabel lblProgress = new JLabel("Days Passed");
		lblProgress.setBounds(400, 12, 100, 15);
		crewManager.getContentPane().add(lblProgress);
		
		JButton btnFly = new JButton("Fly to Next Planet");
		btnFly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pilotList.size() == 2) {
					currentPlanet = new Planet();
					lblPlanet.setText("Welcome to the planet " + currentPlanet.getplanetName());
					pilotList = new ArrayList<CrewMember>();
					eventBelt();
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + "You have successfully arrived on planet " + currentPlanet.getplanetName() + ".");
				} else {
					String currentText = txtConsole.getText();
					txtConsole.setText(currentText + "\n" + "There is not enough crew in the cockpit.");	
				}
			}
		});
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
		

		JLabel lblHealth_1 = new JLabel("Shield Damage");
		lblHealth_1.setBounds(195, 586, 111, 15);
		crewManager.getContentPane().add(lblHealth_1);
		
		progressShipHealth = new JProgressBar();
		progressShipHealth.setForeground(Color.RED);
		progressShipHealth.setBounds(317, 586, 183, 14);
		crewManager.getContentPane().add(progressShipHealth);
		progressShipHealth.setValue(0);
		
		JLabel lblPartsFound = new JLabel("Parts Found");
		lblPartsFound.setBounds(215, 649, 91, 15);
		crewManager.getContentPane().add(lblPartsFound);
		
		progressParts = new JProgressBar();
		progressParts.setForeground(Color.MAGENTA);
		progressParts.setBounds(318, 649, 182, 14);
		crewManager.getContentPane().add(progressParts);
		
		/**
		 * NEXT DAY BUTTON 
		 */
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkEndGame();
				
				txtConsole.setText("Welcome to day " + (manager.getcurrentDay() + 1) + " Captain" );
				
				eventPirate();
				eventAids();
				
				pilotList = new ArrayList<CrewMember>();
				
				//Crew1 methods
				crew1.resetActions();
				lblAction1.setText(Integer.toString(crew1.getActions()));
				crew1.getHungry();
				progressHunger1.setValue(crew1.getHunger());
				crew1.getTired();
				progressTiredness1.setValue(crew1.getTiredness());
				if (crew1.gotAids()) {
					progressHealth1.setForeground(Color.RED);
					crew1.takeDamage(2);
					progressHealth1.setValue(crew1.getHealth());
				}
				if (checkDead(crew1)) {
					crewManager.getContentPane().remove(btnEat1);
					crewManager.getContentPane().remove(btnSleep1);
					crewManager.getContentPane().remove(btnRepair1);
					crewManager.getContentPane().remove(btnSearch1);
					crewManager.getContentPane().remove(btnPilot1);
				}
				
				//Crew2 methods
				crew2.resetActions();
				lblAction2.setText(Integer.toString(crew2.getActions()));
				crew2.getHungry();
				progressHunger2.setValue(crew2.getHunger());
				crew2.getTired();
				progressTiredness2.setValue(crew2.getTiredness());
				if (crew2.gotAids()) {
					progressHealth2.setForeground(Color.RED);
					crew2.takeDamage(2);
					progressHealth2.setValue(crew2.getHealth());
				}
				if (checkDead(crew2)) {
					crewManager.getContentPane().remove(btnEat2);
					crewManager.getContentPane().remove(btnSleep2);
					crewManager.getContentPane().remove(btnRepair2);
					crewManager.getContentPane().remove(btnSearch2);
					crewManager.getContentPane().remove(btnPilot2);
				}
				//Crew3 methods
				if (crewList.size() >= 3) {
					crew3.resetActions();
					lblAction3.setText(Integer.toString(crew3.getActions()));
					crew3.getHungry();
					progressHunger3.setValue(crew3.getHunger());
					crew3.getTired();
					progressTiredness3.setValue(crew3.getTiredness());
					if (crew3.gotAids()) {
						progressHealth3.setForeground(Color.RED);
						crew3.takeDamage(2);
						progressHealth3.setValue(crew3.getHealth());
					}
					if (checkDead(crew3)) {
						crewManager.getContentPane().remove(btnEat3);
						crewManager.getContentPane().remove(btnSleep3);
						crewManager.getContentPane().remove(btnRepair3);
						crewManager.getContentPane().remove(btnSearch3);
						crewManager.getContentPane().remove(btnPilot3);
					}
				}
				
				//Crew4 methods
				if (crewList.size() >= 4) {
					crew4.resetActions();
					lblAction4.setText(Integer.toString(crew4.getActions()));
					crew4.getHungry();
					progressHunger4.setValue(crew4.getHunger());
					crew4.getTired();
					progressTiredness4.setValue(crew4.getTiredness());
					if (crew4.gotAids()) {
						progressHealth4.setForeground(Color.RED);
						crew4.takeDamage(2);
						progressHealth4.setValue(crew4.getHealth());
					}
					if (checkDead(crew4)) {
						crewManager.getContentPane().remove(btnEat4);
						crewManager.getContentPane().remove(btnSleep4);
						crewManager.getContentPane().remove(btnRepair4);
						crewManager.getContentPane().remove(btnSearch4);
						crewManager.getContentPane().remove(btnPilot4);
					}
				}
				manager.addDay();
				progressShipHealth.setValue(myShip.checkCondition());
				int dayStatus = (int) (((double)manager.getcurrentDay() - 1)/(double)manager.getnumberDays()*100);
				progressDays.setValue(dayStatus);
				crewManager.getContentPane().revalidate();
				crewManager.repaint();
			}
		});
		btnNextDay.setBounds(25, 575, 156, 25);
		crewManager.getContentPane().add(btnNextDay);
		
		lblParts = new JLabel(myShip.getParts() + "/" + maxParts);
		lblParts.setBounds(400, 675, 66, 15);
		crewManager.getContentPane().add(lblParts);
		
		lblPlanet = new JLabel("Welcome to the planet " + currentPlanet.getplanetName());
		lblPlanet.setFont(new Font("DejaVu Sans Light", Font.BOLD, 28));
		lblPlanet.setBounds(187, 80, 594, 64);
		crewManager.getContentPane().add(lblPlanet);
		
		
		
	}
}

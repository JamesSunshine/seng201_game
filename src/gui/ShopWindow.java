package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.Game;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopWindow {

	private JFrame shopWindow;
	private Game manager;
	private JLabel moneyValue;

	
	
	/**
	 * Create the application.
	 */
	public ShopWindow(Game incomingManager) {
		manager = incomingManager;
		initialize();
		shopWindow.setVisible(true);
	}
	
	public void closeWindow() {
		shopWindow.dispose();
	}
	
	public void finishedWindow() {
		manager.closeShopWindow(this);
	}
	
	public ShopWindow returnThis() {
		return this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		shopWindow = new JFrame();
		shopWindow.setBounds(100, 100, 559, 418);
		shopWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		shopWindow.getContentPane().setLayout(null);
		int shipMoney = manager.getShipMoney();
		
		JLabel medHeader = new JLabel("Medicine");
		medHeader.setBounds(12, 12, 66, 15);
		shopWindow.getContentPane().add(medHeader);
		
		JLabel pkillerName = new JLabel("Pain Killers");
		pkillerName.setBounds(40, 39, 91, 15);
		shopWindow.getContentPane().add(pkillerName);
		
		JLabel bandageName = new JLabel("Bandages");
		bandageName.setBounds(40, 66, 91, 15);
		shopWindow.getContentPane().add(bandageName);
		
		JLabel cureName = new JLabel("Aids Cure");
		cureName.setBounds(40, 93, 91, 15);
		shopWindow.getContentPane().add(cureName);
		
		JLabel foodHeader = new JLabel("Food");
		foodHeader.setBounds(12, 120, 66, 15);
		shopWindow.getContentPane().add(foodHeader);
		
		JLabel breadName = new JLabel("Cabin Bread");
		breadName.setBounds(40, 147, 91, 15);
		shopWindow.getContentPane().add(breadName);
		
		JLabel mgorengName = new JLabel("Mi Goreng");
		mgorengName.setBounds(40, 174, 66, 15);
		shopWindow.getContentPane().add(mgorengName);
		
		JLabel doritosName = new JLabel("Doritos");
		doritosName.setBounds(40, 201, 66, 15);
		shopWindow.getContentPane().add(doritosName);
		
		JLabel sandwichName = new JLabel("Tuna Melt Sandwich");
		sandwichName.setBounds(40, 228, 66, 15);
		shopWindow.getContentPane().add(sandwichName);
		
		JLabel saladName = new JLabel("Caesar Salad");
		saladName.setBounds(40, 255, 66, 15);
		shopWindow.getContentPane().add(saladName);
		
		JLabel whopperName = new JLabel("Space Whopper");
		whopperName.setBounds(40, 282, 66, 15);
		shopWindow.getContentPane().add(whopperName);
		
		JButton pkillerButton = new JButton("Purchase");
		pkillerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (manager.getShipMoney() - 1 < 0) {
					NotEnoughMoney dialog = new NotEnoughMoney();
					dialog.showDialog();
				}
				else {
					manager.subShipMoney(1);
					manager.makeItem("Pain Killers");
				}
			}
		});
		pkillerButton.setBounds(416, 34, 114, 25);
		shopWindow.getContentPane().add(pkillerButton);
		
		JButton bandagesButton = new JButton("Purchase");
		bandagesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (manager.getShipMoney() - 2 < 0) {
					NotEnoughMoney dialog = new NotEnoughMoney();
					dialog.showDialog();
				}
				else {
					manager.subShipMoney(2);
					manager.makeItem("Bandages");
				}
			}
		});
		bandagesButton.setBounds(416, 61, 114, 25);
		shopWindow.getContentPane().add(bandagesButton);
		
		JButton cureButton = new JButton("Purchase");
		cureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (manager.getShipMoney() - 4 < 0) {
					NotEnoughMoney dialog = new NotEnoughMoney();
					dialog.showDialog();
				}
				else {
					manager.subShipMoney(4);
					manager.makeItem("Aids Cure");
				}
			}
		});
		cureButton.setBounds(416, 88, 114, 25);
		shopWindow.getContentPane().add(cureButton);
		
		JButton breadButton = new JButton("Purchase");
		breadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (manager.getShipMoney() - 1 < 0) {
					NotEnoughMoney dialog = new NotEnoughMoney();
					dialog.showDialog();
				}
				else {
					manager.subShipMoney(1);
					manager.makeItem("Cabin Bread");
				}
			}
		});
		breadButton.setBounds(416, 142, 114, 25);
		shopWindow.getContentPane().add(breadButton);
		
		JButton gorengButton = new JButton("Purchase");
		gorengButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (manager.getShipMoney() - 2 < 0) {
					NotEnoughMoney dialog = new NotEnoughMoney();
					dialog.showDialog();
				}
				else {
					manager.subShipMoney(2);
					manager.makeItem("Mi Goreng");
				}
			}
		});
		gorengButton.setBounds(416, 169, 114, 25);
		shopWindow.getContentPane().add(gorengButton);
		
		JButton doritosButton = new JButton("Purchase");
		doritosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (manager.getShipMoney() - 3 < 0) {
					NotEnoughMoney dialog = new NotEnoughMoney();
					dialog.showDialog();
				}
				else {
					manager.subShipMoney(3);
					manager.makeItem("Doritos");
				}
			}
		});
		doritosButton.setBounds(416, 196, 114, 25);
		shopWindow.getContentPane().add(doritosButton);
		
		JButton sandwichButton = new JButton("Purchase");
		sandwichButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (manager.getShipMoney() - 4 < 0) {
					NotEnoughMoney dialog = new NotEnoughMoney();
					dialog.showDialog();
				}
				else {
					manager.subShipMoney(4);
					manager.makeItem("Tuna Melt Sandwich");
				}
			}
		});
		sandwichButton.setBounds(416, 223, 114, 25);
		shopWindow.getContentPane().add(sandwichButton);
		
		JButton saladButton = new JButton("Purchase");
		saladButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (manager.getShipMoney() - 5 < 0) {
					NotEnoughMoney dialog = new NotEnoughMoney();
					dialog.showDialog();
				}
				else { 
					manager.subShipMoney(5);
					manager.makeItem("Caesar Salad");
				}
			}
		});
		saladButton.setBounds(416, 250, 114, 25);
		shopWindow.getContentPane().add(saladButton);
		
		JButton whopperButton = new JButton("Purchase");
		whopperButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (manager.getShipMoney() - 6 < 0) {
					NotEnoughMoney dialog = new NotEnoughMoney();
					dialog.showDialog();
				}
				else {
					manager.subShipMoney(6);
					manager.makeItem("Space Whopper");
				}
			}
		});
		whopperButton.setBounds(416, 277, 114, 25);
		shopWindow.getContentPane().add(whopperButton);
		
		JButton exitButton = new JButton("Close");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.closeShopWindow(returnThis());
			}
		});
		exitButton.setBounds(416, 353, 114, 25);
		shopWindow.getContentPane().add(exitButton);
		
		JButton btnInventory = new JButton("Veiw Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchcurrentInventory();
			}
		});
		btnInventory.setBounds(17, 353, 136, 25);
		shopWindow.getContentPane().add(btnInventory);
		
		JLabel moneyLabel = new JLabel("Money: ");
		moneyLabel.setBounds(420, 12, 66, 15);
		shopWindow.getContentPane().add(moneyLabel);
		
		JLabel moneyValue = new JLabel(Integer.toString(shipMoney));
		moneyValue.setBounds(481, 12, 66, 15);
		shopWindow.getContentPane().add(moneyValue);
	}
}

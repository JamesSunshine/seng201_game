package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.Game;
import main.Ship;

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
	public void updateMoney() {
		moneyValue.setText(Integer.toString(manager.getShipMoney()));
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
		
		JLabel medHeader = new JLabel("MEDICINE");
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
		
		JLabel foodHeader = new JLabel("FOOD");
		foodHeader.setBounds(12, 120, 66, 15);
		shopWindow.getContentPane().add(foodHeader);
		
		JLabel breadName = new JLabel("Cabin Bread");
		breadName.setBounds(40, 147, 91, 15);
		shopWindow.getContentPane().add(breadName);
		
		JLabel mgorengName = new JLabel("Mi Goreng");
		mgorengName.setBounds(40, 174, 91, 15);
		shopWindow.getContentPane().add(mgorengName);
		
		JLabel doritosName = new JLabel("Doritos");
		doritosName.setBounds(40, 201, 91, 15);
		shopWindow.getContentPane().add(doritosName);
		
		JLabel sandwichName = new JLabel("Tuna Melt Sandwich");
		sandwichName.setBounds(40, 228, 148, 15);
		shopWindow.getContentPane().add(sandwichName);
		
		JLabel saladName = new JLabel("Caesar Salad");
		saladName.setBounds(40, 255, 113, 15);
		shopWindow.getContentPane().add(saladName);
		
		JLabel whopperName = new JLabel("Space Whopper");
		whopperName.setBounds(40, 282, 113, 15);
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
					updateMoney();
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
					System.out.println(Ship.Inventory);
				}
				else {
					manager.subShipMoney(2);
					manager.makeItem("Bandages");
					updateMoney();
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
					updateMoney();
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
					updateMoney();
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
					updateMoney();
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
					updateMoney();
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
					updateMoney();
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
					updateMoney();
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
					updateMoney();
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
		
		moneyValue = new JLabel(Integer.toString(shipMoney));
		moneyValue.setBounds(481, 12, 66, 15);
		shopWindow.getContentPane().add(moneyValue);
		
		JLabel pkPrice = new JLabel();
		pkPrice.setText("$1");
		pkPrice.setBounds(200, 39, 66, 15);
		shopWindow.getContentPane().add(pkPrice);
		
		JLabel bandagePrice = new JLabel("$2");
		bandagePrice.setBounds(200, 66, 66, 15);
		shopWindow.getContentPane().add(bandagePrice);
		
		JLabel curePrice = new JLabel("$4");
		curePrice.setBounds(200, 93, 66, 15);
		shopWindow.getContentPane().add(curePrice);
		
		JLabel sandwichPrice = new JLabel("$4");
		sandwichPrice.setBounds(200, 228, 66, 15);
		shopWindow.getContentPane().add(sandwichPrice);
		
		JLabel saladPrice = new JLabel("$5");
		saladPrice.setBounds(200, 255, 66, 15);
		shopWindow.getContentPane().add(saladPrice);
		
		JLabel whopperPrice = new JLabel("$6");
		whopperPrice.setBounds(200, 282, 66, 15);
		shopWindow.getContentPane().add(whopperPrice);
		
		JLabel doritosPrice = new JLabel("$3");
		doritosPrice.setBounds(200, 201, 66, 15);
		shopWindow.getContentPane().add(doritosPrice);
		
		JLabel gorengPrice = new JLabel("$2");
		gorengPrice.setBounds(200, 174, 66, 15);
		shopWindow.getContentPane().add(gorengPrice);
		
		JLabel breadPrice = new JLabel("$1");
		breadPrice.setBounds(200, 147, 66, 15);
		shopWindow.getContentPane().add(breadPrice);
		
		JLabel pkEffect = new JLabel("Restores 2 Health");
		pkEffect.setBounds(262, 39, 120, 15);
		shopWindow.getContentPane().add(pkEffect);
		
		JLabel bandEffect = new JLabel("Restores 4 Health");
		bandEffect.setBounds(262, 66, 136, 15);
		shopWindow.getContentPane().add(bandEffect);
		
		JLabel cureEffect = new JLabel("Cures Space Aids");
		cureEffect.setBounds(262, 93, 136, 15);
		shopWindow.getContentPane().add(cureEffect);
		
		JLabel breadEffect = new JLabel("Reduces Hunger by 1");
		breadEffect.setBounds(262, 147, 154, 15);
		shopWindow.getContentPane().add(breadEffect);
		
		JLabel gorengEffect = new JLabel("Reduces Hunger by 2");
		gorengEffect.setBounds(262, 174, 154, 15);
		shopWindow.getContentPane().add(gorengEffect);
		
		JLabel doritosEffect = new JLabel("Reduces Hunger by 3");
		doritosEffect.setBounds(262, 201, 154, 15);
		shopWindow.getContentPane().add(doritosEffect);
		
		JLabel sandwichEffect = new JLabel("Reduces Hunger by 4");
		sandwichEffect.setBounds(262, 228, 154, 15);
		shopWindow.getContentPane().add(sandwichEffect);
		
		JLabel saladEffect = new JLabel("Reduces Hunger by 5");
		saladEffect.setBounds(262, 255, 154, 15);
		shopWindow.getContentPane().add(saladEffect);
		
		JLabel whopperEffect = new JLabel("Reduces Hunger by 6");
		whopperEffect.setBounds(262, 282, 154, 15);
		shopWindow.getContentPane().add(whopperEffect);
		
		JLabel costHeader = new JLabel("COST");
		costHeader.setBounds(189, 12, 66, 15);
		shopWindow.getContentPane().add(costHeader);
		
		JLabel effectHeader = new JLabel("EFFECT");
		effectHeader.setBounds(262, 12, 66, 15);
		shopWindow.getContentPane().add(effectHeader);
	}
}

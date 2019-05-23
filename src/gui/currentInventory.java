package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.Game;
import main.Ship;
import main.Items.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class currentInventory {

	private JFrame invWindow;
	private Game manager;
	private Item item;

	
	/**
	 * Create the application.
	 */
	public currentInventory(Game incomingManager) {
		manager = incomingManager;
		initialize();
		invWindow.setVisible(true);
	}
	
	public void closeWindow() {
		invWindow.dispose();
	}
	
	public void finishedWindow() {
		manager.closecurrentInventory(this);
	}
	
	public currentInventory returnThis() {
		return this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		invWindow = new JFrame();
		invWindow.setBounds(100, 100, 450, 300);
		invWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		invWindow.getContentPane().setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.closecurrentInventory(returnThis());
			}
		});
		btnClose.setBounds(324, 235, 114, 25);
		invWindow.getContentPane().add(btnClose);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 426, 211);
		invWindow.getContentPane().add(scrollPane);
		
		DefaultListModel listModel = new DefaultListModel();
		for (int i = 0; i < Ship.Inventory.size(); i++)
		{
		    item = Ship.Inventory.get(i);
			listModel.addElement(item.getName() + "" + item.getEffect());
		}
		JList<Item> list = new JList<Item>(listModel);
		list.setBounds(12, 12, 426, 211);
		invWindow.getContentPane().add(list);
		scrollPane.setViewportView(list);
		
	}
}

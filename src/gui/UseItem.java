package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import main.Game;
import main.Ship;
import main.Items.Item;
import main.Types.CrewMember;

public class UseItem extends CrewManager {

	private JFrame useWindow;
	private CrewManager manager;
	private Item item;
	private String type;
	private int stat;
	private CrewMember member;

	
	/**
	 * Create the application.
	 */
	public UseItem(CrewManager incomingManager, CrewMember incomingMember) {
		manager = incomingManager;
		member = incomingMember;
		initialize();
		useWindow.setVisible(true);
	}
	
	
	public void closeWindow() {
		useWindow.dispose();
	}
	
	
	public UseItem returnThis() {
		return this;
	}
	
	public void getVariables(Item i) {
		type = i.getType();
		stat = i.getStat();
	}
	
	public String getType() {
		return type;
	}
	
	public int getStat() {
		return stat;
	}
	
	public void itemUse() {
		if (getType() == "Medicine") {
			member.heal(getStat());
		}
		else if (getType() == "Food") {
			member.eat(getStat());
		}
		else {
			member.cureAids();
			manager.cured(member);
		}
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		useWindow = new JFrame();
		useWindow.setBounds(100, 100, 450, 300);
		useWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		useWindow.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 420, 247);
		useWindow.getContentPane().add(scrollPane);
		
		DefaultListModel listModel = new DefaultListModel();
		for (int i = 0; i < Ship.Inventory.size(); i++)
		{
		    item = Ship.Inventory.get(i);
			listModel.addElement(item.getName() + " - " + item.getEffect());
		}
		JList<Item> list = new JList<Item>(listModel);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				JList list = (JList) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2) {
					int index = list.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
					getVariables(Ship.Inventory.get(index));
					itemUse();
					Ship.Inventory.remove(index);
					closeWindow();
					manager.updateBars();
					}
				}
			}
		});
		list.setBounds(12, 12, 426, 211);
		scrollPane.setViewportView(list);
		
	}
}

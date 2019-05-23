package main;

import main.Items.Item;
import main.Types.CrewMember;
import java.util.ArrayList;

public class Ship {

    private String name;
    private int numberofCrew = 0;
    private int shipCondition = 0;
    private int crewPoints = 0;
    private int money = 100;
    private int shipParts = 0;

    public static ArrayList<Item> Inventory = new ArrayList<Item>();
    public static ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();

    public static void createShip(String inputName) {
        Ship myShip = new Ship(inputName);
    }

    public Ship(String mName) {
        name = mName;
    }
    
    public String getName() {
    	return name;
    }
    
    
    public void addCrew(CrewMember member) {
        crewList.add(member);
    }

    public void subCrew(CrewMember deadMember) {
        crewList.remove(deadMember);
    }

    public int getnumberofCrew() {
        return crewList.size();
    }

    public void addInventory(Item item) {
        Inventory.add(item);
    }
    
    public void subInventory(Item item) {
    	Inventory.remove(item);
    }

    public int getMoney() {
    	return money;
    }
    
    public void addMoney(int foundMoney) {
    	money = money + foundMoney;
    }
    
    public void subMoney(int cost) {
    	money -= cost;
    }
    
    public int getPoints() {
        return crewPoints;
    }

    public void addPoints(int points) {
        crewPoints += points;
    }

    public void subPoints(int points) {
        crewPoints = crewPoints - points;
    }

    public void shipRepair(String type) {
    	if (type == "Engineer") {
    		if (this.checkCondition() >= 20) {
    			shipCondition -= 20;
    		} else {
    			shipCondition = 0;
    		}
    	} else {
    		if (this.checkCondition() >= 10) {
    			shipCondition -= 10;
    		} else {
    			shipCondition = 0;
    		}
    		
    	}
    }

    public void shipDamage(int damage) {
        shipCondition = shipCondition + damage;
    }

    public int checkCondition() {
        return shipCondition;

    }
    
    public int getParts() {
    	return shipParts;
    }
    
    public void addParts() {
    	shipParts += 1;
    }

}

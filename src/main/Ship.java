package main;

import main.Items.Item;
import main.Types.CrewMember;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Ship.
 */
public class Ship {

    /** The name. */
    private String name;
    
    /** The numberof crew. */
    private int numberofCrew = 0;
    
    /** The ship condition. */
    private int shipCondition = 0;
    
    /** The crew points. */
    private int crewPoints = 0;
    
    /** The money. */
    private int money = 15;
    
    /** The ship parts. */
    private int shipParts = 0;

    /** The Inventory. */
    public static ArrayList<Item> Inventory  = new ArrayList<Item>();
    
    /** The crew list. */
    public static ArrayList<CrewMember> crewList  = new ArrayList<CrewMember>();

    /**
     * Resets the ship.
     */
    public void resetShip() {
        Inventory = new ArrayList<Item>();
        crewList =  new ArrayList<CrewMember>();
    }
    
    /**
     * Instantiates a new ship.
     *
     * @param mName the m name
     */
    public Ship(String mName) {
        name = mName;
    }
    
    /**
     * Gets the ship name.
     *
     * @return the name
     */
    public String getName() {
    	return name;
    }
    
    
    /**
     * Adds the crew to the ship.
     *
     * @param member the member
     */
    public void addCrew(CrewMember member) {
        crewList.add(member);
    }

    /**
     * Subtracts crew from the ship
     *
     * @param deadMember the dead member
     */
    public void subCrew(CrewMember deadMember) {
        crewList.remove(deadMember);
    }

    /**
     * Gets the number of crew.
     *
     * @return the numberof crew
     */
    public int getnumberofCrew() {
        return crewList.size();
    }

    /**
     * Adds to the inventory.
     *
     * @param item the item
     */
    public void addInventory(Item item) {
        Inventory.add(item);
    }
    
    /**
     * Subtracts from the inventory.
     *
     * @param item the item
     */
    public void subInventory(Item item) {
    	Inventory.remove(item);
    }

    /**
     * Gets the ships total money.
     *
     * @return the money
     */
    public int getMoney() {
    	return money;
    }
    
    /**
     * Adds to ship money.
     *
     * @param foundMoney the found money
     */
    public void addMoney(int foundMoney) {
    	money = money + foundMoney;
    }
    
    /**
     * Subtracts from ship money.
     *
     * @param cost the cost
     */
    public void subMoney(int cost) {
    	money -= cost;
    }
    
    /**
     * Gets the current ship points.
     *
     * @return the points
     */
    public int getPoints() {
        return crewPoints;
    }

    /**
     * Adds to the ship points.
     *
     * @param points the points
     */
    public void addPoints(int points) {
        crewPoints += points;
    }

    /**
     * Subtract from ship points.
     *
     * @param points the points
     */
    public void subPoints(int points) {
        crewPoints = crewPoints - points;
    }

    /**
     * repair the ship.
     *
     * @param type the type
     */
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

    /**
     * Damage the ship.
     *
     * @param damage the damage
     */
    public void shipDamage(int damage) {
        shipCondition = shipCondition + damage;
    }

    /**
     * Check ship condition.
     *
     * @return the int
     */
    public int checkCondition() {
        return shipCondition;
    }
    
    /**
     * Gets the current ship parts.
     *
     * @return the parts
     */
    public int getParts() {
    	return shipParts;
    }
    
    /**
     * Adds to the ship parts.
     */
    public void addParts() {
    	shipParts += 1;
    }

}

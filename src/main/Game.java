package main;

import gui.CrewBuy;
import gui.CrewManager;
import gui.MainMenu;
import gui.Startup;
import gui.UseItem;
import gui.currentInventory;
import main.Types.CrewMember;
import gui.ShopWindow;


/**
 * The Class Game.
 */
public class Game extends Planet {

    /** The number days. */
    private int numberDays;
    
    /** The current day. */
    private int currentDay = 1;
    
    /** The point buy. */
    private static int pointBuy;
    
    /** The selection. */
    private static  String selection = "0";
    
    /** The my ship. */
    private Ship myShip;
    
    /** The startup window. */
    private Startup startupWindow;
    
    /** The crew factory. */
    private CrewFactory crewFactory = new CrewFactory();
    
    /** The item factory. */
    private SpaceOutpost itemFactory = new SpaceOutpost();
    
    /** The max parts. */
    private int maxParts = (int) ((numberDays * 2) / 3);

    
    /**
     * Gets the current day.
     *
     * @return the current day
     */
    public int getcurrentDay() {
    	return currentDay;
    }
    
    /**
     * Gets the number of days.
     *
     * @return the number days
     */
    public int getnumberDays() {
    	return numberDays;
    }
    
    /**
     * Adds a day.
     */
    public void addDay() {
    	currentDay += 1;
    }
    
    /**
     * Sets the number days.
     *
     * @param input the new number days
     */
    public void setnumberDays(int input) {
    	numberDays = input;
    }
    
    //game Ship object methods
    
    /**
     * Makes a ship.
     *
     * @param name the name
     */
    public void makeShip(String name) {
    	myShip = new Ship(name);
    	myShip.resetShip();
    }
    
    /**
     * Gets the ship name.
     *
     * @return the ship name
     */
    public String getShipName() {
    	return myShip.getName();
    }
    
    /**
     * Gets the ship points.
     *
     * @return the ship points
     */
    public int getShipPoints() {
    	return myShip.getPoints();
    }
    
    /**
     * Adds to ship points.
     *
     * @param points the points
     */
    public void addShipPoints(int points) {
    	myShip.addPoints(points);
    }
    
    /**
     * Removes from ship points.
     *
     * @param points the points
     */
    public void removeShipPoints(int points) {
    	myShip.subPoints(points);
    }
    
    /**
     * Gets the ship money.
     *
     * @return the ship money
     */
    public int getShipMoney() {
    	return myShip.getMoney();
    }
    
    /**
     * Adds to ship money.
     *
     * @param foundMoney the found money
     */
    public void addShipMoney(int foundMoney) {
    	myShip.addMoney(foundMoney);
    }
    
    /**
     * Subtracts from ship money.
     *
     * @param cost the cost
     */
    public void subShipMoney(int cost) {
    	myShip.subMoney(cost);
    }
    
    /**
     * Make a crew member using the factory
     *
     * @param type the type
     * @param name the name
     */
    public void makeCrew(String type, String name) {
		myShip.addCrew(crewFactory.recruit(type, name));
    	
    }
    
    /**
     * Make an item using the factory
     *
     * @param itemName the item name
     */
    public void makeItem(String itemName) {
    	myShip.addInventory(itemFactory.purchase(itemName));
    }
    
    /**
     * Gets the ship.
     *
     * @return the ship
     */
    public Ship getShip() {
    	return myShip;
    }
    
    /**
     * Gets the number of crew.
     *
     * @return the num crew
     */
    public int getNumCrew() {
    	return myShip.getnumberofCrew();
    }
    
    /**
     * Gets the crew member.
     *
     * @param index the index
     * @return the crew member
     */
    public CrewMember getCrewMember(int index) {
    	return Ship.crewList.get(index);
    }
    
    /**
     * Repair the ship.
     *
     * @param type the type
     */
    public void repairShip(String type) {
    	myShip.shipRepair(type);
    }
    
    /**
     * Gets the ship status.
     *
     * @return the ship status
     */
    public int getShipStatus() {
    	return myShip.checkCondition();
    }
    
    /**
     * Damage the ship.
     */
    public void damageShip() {
    	myShip.shipDamage(20);
    }
    
    //game Ship object methods

    
    //GUI methods
    
    /**
     * Launch main menu.
     */
    public void launchmainMenu() {
    	MainMenu menuWindow = new MainMenu(this);
    }
    
    /**
     * Launch startup.
     *
     * @param incomingManager the incoming manager
     */
    public void launchStartup(Game incomingManager) {
    	Startup startWindow = new Startup(incomingManager);
    }
    
    /**
     * Close startup.
     *
     * @param startupWindow the startup window
     */
    public void closeStartup(Startup startupWindow) {
    	startupWindow.closeWindow();
    	launchCrewBuy();
    }
    
    /**
     * Launch crew buy.
     */
    public void launchCrewBuy() {
    	CrewBuy crewbuyWindow = new CrewBuy(this);
    }
    
    /**
     * Close crew buy.
     *
     * @param crewbuyWindow the crewbuy window
     */
    public void closeCrewBuy(CrewBuy crewbuyWindow) {
    	crewbuyWindow.closeWindow();
    }
    
    /**
     * Launch shop window.
     */
    public void launchShopWindow() {
    	ShopWindow shopWindow = new ShopWindow(this);
    }
    
    /**
     * Close shop window.
     *
     * @param shopWindow the shop window
     */
    public void closeShopWindow(ShopWindow shopWindow) {
    	shopWindow.closeWindow();
    }
    
    /**
     * Launch crew manager.
     */
    public void launchCrewManager() {
    	CrewManager crewManager = new CrewManager(this);
    }
    
    /**
     * Close crew manager.
     *
     * @param crewManager the crew manager
     */
    public void closeCrewManager(CrewManager crewManager) {
    	crewManager.closeWindow();
    }
    
    /**
     * Launch current inventory.
     */
    public void launchcurrentInventory() {
    	currentInventory invWindow = new currentInventory(this);
    }
    
    /**
     * Close current inventory.
     *
     * @param invWindow the inv window
     */
    public void closecurrentInventory(currentInventory invWindow) {
    	invWindow.closeWindow();
    }
    
    //GUI methods
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
                
        Game manager = new Game();
        
        manager.launchmainMenu();
               
        }



    }

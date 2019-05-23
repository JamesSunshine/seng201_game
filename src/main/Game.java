package main;

import gui.CrewBuy;
import gui.CrewManager;
import gui.MainMenu;
import gui.Startup;
import gui.UseItem;
import gui.currentInventory;
import main.Types.CrewMember;
import gui.ShopWindow;

public class Game {

    private int numberDays;
    private int currentDay = 0;
    private static int pointBuy;
    private static  String selection = "0";
    private Ship myShip;
    private Startup startupWindow;
    private CrewFactory crewFactory = new CrewFactory();
    private SpaceOutpost itemFactory = new SpaceOutpost();
    private int maxParts = (int) ((numberDays * 2) / 3);

    
    public int getcurrentDay() {
    	return currentDay;
    }
    
    public int getnumberDays() {
    	return numberDays;
    }
    public void addDay() {
    	currentDay += 1;
    }
    
    public void setnumberDays(int input) {
    	numberDays = input;
    }
    
    //game Ship object methods
    
    public void makeShip(String name) {
    	myShip = new Ship(name);
    }
    
    public String getShipName() {
    	return myShip.getName();
    }
    
    public int getShipPoints() {
    	return myShip.getPoints();
    }
    
    public void addShipPoints(int points) {
    	myShip.addPoints(points);
    }
    
    public void removeShipPoints(int points) {
    	myShip.subPoints(points);
    }
    
    public int getShipMoney() {
    	return myShip.getMoney();
    }
    
    public void addShipMoney(int foundMoney) {
    	myShip.addMoney(foundMoney);
    }
    
    public void subShipMoney(int cost) {
    	myShip.subMoney(cost);
    }
    
    public void makeCrew(String type, String name) {
		myShip.addCrew(crewFactory.recruit(type, name));
    	
    }
    
    public void makeItem(String itemName) {
    	myShip.addInventory(itemFactory.purchase(itemName));
    }
    public Ship getShip() {
    	return myShip;
    }
    
    public int getNumCrew() {
    	return myShip.getnumberofCrew();
    }
    
    public CrewMember getCrewMember(int index) {
    	return Ship.crewList.get(index);
    }
    
    public void repairShip(String type) {
    	myShip.shipRepair(type);
    }
    
    public int getShipStatus() {
    	return myShip.checkCondition();
    }
    
    public void damageShip() {
    	myShip.shipDamage(20);
    }
    
    //game Ship object methods

    
    //GUI methods
    
    public void launchmainMenu() {
    	MainMenu menuWindow = new MainMenu(this);
    }
    
    public void launchStartup(Game incomingManager) {
    	Startup startWindow = new Startup(incomingManager);
    }
    
    public void closeStartup(Startup startupWindow) {
    	startupWindow.closeWindow();
    	launchCrewBuy();
    }
    
    public void launchCrewBuy() {
    	CrewBuy crewbuyWindow = new CrewBuy(this);
    }
    
    public void closeCrewBuy(CrewBuy crewbuyWindow) {
    	crewbuyWindow.closeWindow();
    }
    
    public void launchShopWindow() {
    	ShopWindow shopWindow = new ShopWindow(this);
    }
    
    public void closeShopWindow(ShopWindow shopWindow) {
    	shopWindow.closeWindow();
    }
    
    public void launchCrewManager() {
    	CrewManager crewManager = new CrewManager(this);
    }
    
    public void closeCrewManager(CrewManager crewManager) {
    	crewManager.closeWindow();
    }
    
    public void launchcurrentInventory() {
    	currentInventory invWindow = new currentInventory(this);
    }
    
    public void closecurrentInventory(currentInventory invWindow) {
    	invWindow.closeWindow();
    }
    
    //GUI methods
    
    public static void main(String[] args) {
                
        Game manager = new Game();
        
        manager.launchmainMenu();
               
        }



    }

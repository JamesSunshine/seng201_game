package main;

import gui.CrewBuy;
import gui.CrewManager;
import gui.Startup;
import gui.currentInventory;
import gui.ShopWindow;

public class Game {

    private static int numberDays;
    private static int pointBuy;
    private static  String selection = "0";
    private Ship myShip;
    private Startup startupWindow;
    private CrewFactory crewFactory = new CrewFactory();
    private SpaceOutpost itemFactory = new SpaceOutpost();

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
    
    //game Ship object methods

    
    //GUI methods
    
    public void launchStartup() {
    	Startup startWindow = new Startup(this);
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
        
        manager.launchStartup();
               
        }



    }

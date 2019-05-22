package main;

import gui.CrewBuy;
import gui.Startup;

public class Game {

    private static int numberDays;
    private static int pointBuy;
    private static  String selection = "0";
    private Ship myShip;
    private Startup startupWindow;
    private CrewFactory crewFactory = new CrewFactory();

    //game Ship object methods
    
    public void makeShip(String name) {
    	myShip = new Ship(name);
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
    
    public String getShipName() {
    	System.out.println(myShip.getName());
    	return myShip.getName();
    }
    
    public void makeCrew(String type, String name) {
		myShip.addCrew(crewFactory.recruit(type, name));
    	
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
    
    //GUI methods
    
    public static void main(String[] args) {
                
        Game manager = new Game();
        
        manager.launchStartup();
               
        }



    }

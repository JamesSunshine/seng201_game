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

    public void setShip(Ship newShip) {
    	myShip = newShip;
    }
    
    public void makeCrew(String type, String name) {
		myShip.addCrew(crewFactory.recruit(type, name));
    	
    }
    public Ship getShip() {
    	return myShip;
    }

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
    
    public static void main(String[] args) {
                
        Game manager = new Game();
        
        manager.launchStartup();
        System.out.println(Ship.crewList);
               
        }



    }

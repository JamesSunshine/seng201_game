package seng201_project;

import java.util.InputMismatchException;
import java.util.Scanner;

import gui.CrewBuy;
import gui.Startup;

public class Game {

    private static int numberDays;
    private static int pointBuy;
    private static  String selection = "0";
    private Ship myShip;
    private Startup startupWindow;

    public void setShip(Ship newShip) {
    	myShip = newShip;
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
       
        CrewFactory crewFactory = new CrewFactory();
        
        Game manager = new Game();
        
        manager.launchStartup();   
               
        }



    }

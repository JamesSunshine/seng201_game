package main;

import gui.CrewBuy;
import gui.Startup;

public class Game {

    private static int numberDays;
    private static int pointBuy;
    private static  String selection = "0";


    public void launchStartup() {
    	Startup startWindow = new Startup(this);
    }
    
    public void closeStartup(Startup startupWindow) {
    	startupWindow.closeWindow();
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

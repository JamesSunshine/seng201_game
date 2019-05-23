package main;

import main.Types.CrewMember;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import gui.CrewManager;
import main.Ship;

public class RNGEvent {

    private int shipDamage;
    private int threshold = 15;
    private double occurrence;
    private int maxIndex;
    private double randNum;
    private Ship yourShip;
    private boolean hasGunner = false;
    private boolean hasPilot = false;
    private int foundID;
    private Random rand = new Random();
    
    
    public static List<String> foundItem = Arrays.asList("Pain Killers", "Bandages", "Aids Cure", "Cabin Bread", "Mi Goreng", "Doritos", "Tuna Melt Sandwich", "Caesar Salad", "Space Whopper");
    


    public String spacePirates(Ship incomingShip) {
    	shipDamage = 0;
    	this.hasGunner = false;
        this.threshold = 10;
    	yourShip = incomingShip;
        occurrence = rand.nextInt(19);
        occurrence += 1;
        for (CrewMember member : Ship.crewList) {
        	if (member.getType() == "Gunner" ) {
        		this.hasGunner = true;
        	}
        }
        if (occurrence >= threshold) {
            if ((this.hasGunner == true) && (occurrence < (this.threshold += 2))) {
            	return "Gunner Pass";
            } else { 
            	
            	if (Ship.Inventory.size() == 0) {
            		return "Gunner Fail";
            	} else {
            		
            		return "Fail ";
            	}
            }
        } 	

		return "Pass";
    }

	public boolean spaceAids(CrewMember member){
        occurrence = rand.nextInt(19);
        occurrence += 1;
        if (member.getType() == "Medic") {
        	return false;
        }
        else if (member.gotAids()) {
        	return false;
        }
        else if (occurrence >= threshold) {
            member.contractAids();
            return true;
        } else {
        	return false;
        }
    }

    public String asteroidBelt(Ship yourShip) {
    	hasPilot = false;
    	threshold = 10;
        occurrence = rand.nextInt(19);
        occurrence += 1;
        for (CrewMember member : CrewManager.pilotList) {
        	if (member.getType() == "Pilot") {
        		hasPilot = true;
        	}
        }
        if (occurrence >= threshold) {
        	if ((hasPilot == true) && ((occurrence) < (threshold += 2))) {
        		return "Pilot Pass";
        	}
        	else {
        		shipDamage = 5;
            	yourShip.shipDamage(shipDamage);
            	return "Pilot Fail";
        	}
        }
        return "Pass";
    }
    
    public String planetSearch(CrewMember member, int randInt) {
    	foundID = randInt;
		switch (foundID) {
			case 1: {
				return "Found Nothing";
			}
			case 2:{
				return "Found Money";
			}
			case 3: {
				return "Found Item";
			}
			case 4: {
				return "Found Part";
			}
		}
		return "Found Nothing";
    }
}

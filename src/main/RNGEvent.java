package main;

import main.Types.CrewMember;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import gui.CrewManager;
import main.Ship;
import main.Items.Item;

public class RNGEvent {

    private int shipDamage;
    private int threshold = 10;
    private double occurrence;
    private int maxIndex;
    private double randNum;
    private Ship yourShip;
    private boolean hasGunner = false;
    private boolean hasPilot = false;
    private int foundID;
    
    
    public static List<String> foundItem = Arrays.asList("Pain Killers", "Bandages", "Aids Cure", "Cabin Bread", "Mi Goreng", "Doritos", "Tuna Melt Sandwich", "Caesar Salad", "Space Whopper");
    


    public String spacePirates(Ship incomingShip) {
    	this.hasGunner = false;
        this.threshold = 10;
    	yourShip = incomingShip;
        occurrence = Math.random() * ((20 - 1) + 1) + 1;
        for (CrewMember member : Ship.crewList) {
        	if (member.getType() == "Gunner" ) {
        		this.hasGunner = true;
        	}
        }
        if (occurrence >= threshold) {
            if ((this.hasGunner == true) && (occurrence < (this.threshold += 2))) {
            	return "Gunner Pass";
            	}
            else {
            	shipDamage = 10;
            	yourShip.shipDamage(shipDamage);
          
            	if (Ship.Inventory.size() == 0) {
            	return "Gunner Fail";
            	}
            	else {
            	maxIndex = Ship.Inventory.size() - 1;
            	randNum = Math.random() * ((maxIndex - 1) + 1) + 0;
            	Ship.Inventory.remove((int) randNum);
            	return "Gunner Fail ";
            	}
            }
        } 	

		return "Pass";
    }

	public boolean spaceAids(CrewMember member){
        occurrence = Math.random() * ((20 - 1) + 1) + 1;
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
        occurrence = Math.random() * ((20 - 1) + 1) + 1;
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
        		shipDamage = 20;
            	yourShip.shipDamage(shipDamage);
            	return "Pilot Fail";
        	}
        }
        return "Pass";
    }
    
    public String planetSearch(CrewMember member, int randInt) {
    	//Scout cannot find nothing
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

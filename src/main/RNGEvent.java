package main;

import main.Types.CrewMember;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private int index;
    private SpaceOutpost spaceOutpost = new SpaceOutpost();
    
    public List<String> foundItem = Arrays.asList("Pain Killers", "Bandages", "Aids Cure", "Cabin Bread", "Mi Goreng", "Doritos", "Tuna Melt Sandwich", "Caesar Salad", "Space Whopper");
    


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
    
    public String planetSearch(CrewMember member) {
    	//Scout cannot find nothing
    	System.out.println("el poopo");
    	if (member.getType() == "Scout") {
    		System.out.println("el poopo 2");
    		foundID = (int) Math.random() * ((4 - 2) + 1) + 2;
    		switch (foundID) {
    			case 2:{
    				yourShip.addMoney(10);
    				return "Found Money";
    			}
    			case 3: {
    				index = (int) Math.random() * ((9 - 1) + 1) + 1;
    				yourShip.addInventory(spaceOutpost.purchase(foundItem.get(index)));
    				return "Found Item";
    			}
    			case 4: {
    				yourShip.addParts();
    				return "Found Part";
    			}
    		}
    	}
    	else {
    		System.out.println("el poopo 3");
    		foundID = (int) Math.random() * ((4 - 1) + 1) + 1;
    		System.out.println(foundID);
    		switch (foundID) {
    			case 1: {
    				return "Found Nothing";
    			}
    		
    			case 2:{
    				yourShip.addMoney(10);
    				return "Found Money";
    			}
    			case 3: {
    				index = (int) Math.random() * ((9 - 1) + 1) + 1;
    				yourShip.addInventory(spaceOutpost.purchase(foundItem.get(index)));
    				return "Found Item";
    			}
    			case 4: {
    				yourShip.addParts();
    				return "Found Part";
    			}
    		}
    	}
		return null;
    }
}

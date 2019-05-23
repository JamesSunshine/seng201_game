package main;

import main.Types.CrewMember;
import gui.CrewManager;
import main.Ship;

public class RNGEvent {

    private int shipDamage;
    private int threshold = 10;
    private double occurrence;
    private int maxIndex;
    private double randNum;
    private Ship yourShip;
    private boolean hasGunner = false;
    private boolean hasPilot = false;


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
            	;
            	}
            	else {
            	maxIndex = Ship.Inventory.size() - 1;
            	randNum = Math.random() * ((maxIndex - 1) + 1) + 0;
            	Ship.Inventory.remove((int) randNum);
            	return "Gunner Fail ";}
            }
        } 	

		return "Pass";
    }

    public void spaceAids(CrewMember member){
        occurrence = Math.random() * ((20 - 1) + 1) + 1;
        if (occurrence >= threshold) {
            member.contractAids();
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
}

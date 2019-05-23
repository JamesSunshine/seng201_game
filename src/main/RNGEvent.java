package main;

import main.Types.CrewMember;
import main.Ship;

public class RNGEvent {

    private int shipDamage;
    private int threshold = 10;
    private double occurrence;
    private int maxIndex;
    private double randNum;
    private Ship yourShip;
    private boolean hasGunner = false;


    public boolean spacePirates(Ship incomingShip) {
    	this.hasGunner = false;
        this.threshold = 10;
    	yourShip = incomingShip;
        occurrence = Math.random() * ((20 - 1) + 1) + 1;
        for (CrewMember member : Ship.crewList) {
        	if (member.getType() == "Gunner" ) {
        		this.hasGunner = true;
        	}
        }
        if (this.hasGunner == true) {
        	System.out.println("poop1");
        	this.threshold += 2;
        }
        if (occurrence >= threshold) {
        	System.out.println("poop2");
            shipDamage = 10;
            yourShip.shipDamage(shipDamage);
            
            if (Ship.Inventory.size() == 0) {
            	;
            }
            else {
            	maxIndex = Ship.Inventory.size() - 1;
            	randNum = Math.random() * ((maxIndex - 1) + 1) + 0;
            	Ship.Inventory.remove((int) randNum);
            }
        }
        else if ((hasGunner == true) && (occurrence < threshold)){
        	System.out.println("poop3");
        	return true;
        }
        System.out.println("poop4");
		return false;
    }

    public void spaceAids(CrewMember member){
        occurrence = Math.random() * ((20 - 1) + 1) + 1;
        if (occurrence >= threshold) {
            member.contractAids();
        }
    }

    public void asteroidBelt(Ship yourShip) {
        occurrence = Math.random() * ((20 - 1) + 1) + 1;
        if (occurrence >= threshold) {
            shipDamage = 20;
        	yourShip.shipDamage(shipDamage);

        }
    }
}

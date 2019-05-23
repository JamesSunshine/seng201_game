package main;

import main.Types.CrewMember;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import gui.CrewManager;
import main.Ship;

// TODO: Auto-generated Javadoc
/**
 * The Class RNGEvent.
 */
public class RNGEvent {

    /** The ship damage. */
    private int shipDamage;
    
    /** The threshold. */
    private int threshold = 15;
    
    /** The occurrence. */
    private double occurrence;
    
    /** The max index. */
    private int maxIndex;
    
    /** The rand num. */
    private double randNum;
    
    /** The your ship. */
    private Ship yourShip;
    
    /** The has gunner. */
    private boolean hasGunner = false;
    
    /** The has pilot. */
    private boolean hasPilot = false;
    
    /** The found ID. */
    private int foundID;
    
    /** The rand. */
    private Random rand = new Random();
    
    
    /** The found item. */
    public static List<String> foundItem = Arrays.asList("Pain Killers", "Bandages", "Aids Cure", "Cabin Bread", "Mi Goreng", "Doritos", "Tuna Melt Sandwich", "Caesar Salad", "Space Whopper");
    


    /**
     * Space pirates random event.
     *
     * @param incomingShip the incoming ship
     * @return the string
     */
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

	/**
	 * Space aids random event.
	 *
	 * @param member the member
	 * @return true, if successful
	 */
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

    /**
     * Asteroid belt random event.
     *
     * @param yourShip the your ship
     * @return the string
     */
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
    
    /**
     * Planet search random event.
     *
     * @param member the member
     * @param randInt the rand int
     * @return the string
     */
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

package seng201_project;

import seng201_project.Ship;
import seng201_project.Types.CrewMember;

public class Event {

    private int damage;
    private int threshold = 10;
    private double occurrence;


    public void spacePirates() {
        occurrence = Math.random() * ((20 - 1) + 1) + 1;
        if (occurrence >= threshold) {
            damage = 10;
            //TO DO: Pop-up window when event occurs
        }
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
            damage = 10;
        	yourShip.shipDamage(damage);
        	//TO DO:Pop window when events occurs
        }
    }
}

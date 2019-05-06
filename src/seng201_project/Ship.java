package seng201_project;

import java.util.Scanner;

public class Ship {

    public String name;
    public int NumberofCrew = 0;
    public int ShipCondition;
    public int CrewPoints = 0;
    public int Money = 100;

    pubilc void addCrew() {

    }

    public void subCrew() {

    }

    public int getNumberofCrew() {

    }

    public int getPoints() {

    }

    public void addPoints() {
        
    }

    public void subPoints() {

    }

    public void shipRepair() {

    }

    public void shipDamage() {

    }

    public int checkCondition() {

    }

    public static void main (string[] args) {
        Scanner user_input = new Scanner(System.in);
        String ship_name;
        System.out.print("Enter ship name: ");
        ship_name = user_input.next()

        ship newShip  = new ship();
        newShip.name = ship_name;
        //newShip.CrewPoints = Main.getCrewPoints()     To be implemented later in main
    }

}

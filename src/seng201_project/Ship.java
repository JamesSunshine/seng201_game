package seng201_project;

import seng201_project.Types.CrewMember;

import java.util.Scanner;

public class Ship {

    private String name;
    private int numberofCrew = 0;
    private int shipCondition;
    private int crewPoints = 0;
    private int money = 100;


    Ship(String mName) {
        name = mName;
    }
    public void addCrew() {

    }

    public void subCrew() {

    }

    public int getNumberofCrew() {
        return 1;

    }

    public int getPoints() {
        return 1;

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
        return 1;

    }

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        String ship_name;
        System.out.print("Enter ship name: ");
        ship_name = user_input.next();

        Ship newShip  = new Ship(ship_name);
        //newShip.CrewPoints = Main.getCrewPoints()     To be implemented later in main


        // TODO: ask for crew type
        // ["engineer", "medic", ...]

        CrewFactory crewFactory = new CrewFactory();
        CrewMember liam = crewFactory.recruit("engineer", "Liam");

        System.out.println(liam.toString());

//        liam.hungerDay();

        System.out.println(liam.toString());


    }

}

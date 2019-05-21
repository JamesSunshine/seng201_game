package main;

import main.Items.Item;
import main.Types.CrewMember;

import java.util.ArrayList;

public class Ship {

    private String name;
    private int numberofCrew = 0;
    private int shipCondition = 100;
    private int crewPoints = 0;
    private int money = 100;

    public static ArrayList<Item> Inventory = new ArrayList<Item>();
    public static ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();

    public static void createShip(String inputName) {
        Ship myShip = new Ship(inputName);
    }

    public Ship(String mName) {
        name = mName;
    }

    public static CrewMember addCrew(CrewMember member) {
        crewList.add(member);
        return member;
    }

    public void subCrew(CrewMember deadMember) {
        crewList.remove(deadMember);
    }

    public int getnumberofCrew() {
        return crewList.size();
    }

    public static void addInventory(Item item) {
        Inventory.add(item);
    }

    public int getPoints() {
        return crewPoints;
    }

    public void addPoints(int points) {
        crewPoints = crewPoints + points;
    }

    public void subPoints(int points) {
        crewPoints = crewPoints - points;
    }

    public int shipRepair(int repair) {
        shipCondition = shipCondition + repair;
        return shipCondition;
    }

    public void shipDamage(int damage) {
        this.shipCondition = shipCondition - damage;
    }

    public int checkCondition() {
        return shipCondition;

    }

}

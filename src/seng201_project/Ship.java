package seng201_project;

import seng201_project.Items.Item;
import seng201_project.Types.CrewMember;

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

    Ship(String mName) {
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
        return 1;

    }

    public void addPoints() {
        
    }

    public void subPoints() {

    }

    public void shipRepair(int repair) {
        shipCondition = shipCondition + repair;
    }

    public void shipDamage(int damage) {
        shipCondition = shipCondition - damage;
    }

    public int checkCondition() {
        return shipCondition;

    }

}

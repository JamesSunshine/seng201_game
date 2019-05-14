package seng201_project.Types;

public class Medic extends CrewMember {

    private int hunger = 10;
    private int tiredness = 10;
    private int health = 12;
    private String spec = "DW I'm a doctor";
    private int HungerChange = -2;
    private int TirednessChange = -2;

    public Medic(String name) {
        super(name);
    }
}

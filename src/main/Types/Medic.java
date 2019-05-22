package main.Types;

public class Medic extends CrewMember {

    private int hunger = 10;
    private int tiredness = 10;
    private int health = 12;
    private String spec = "DW I'm a doctor";
    private int hungerChange = -2;
    private int tirednessChange = -2;


    public Medic(String name) {

    	super(name, 15, 0, 0, -2, -2, "Medic");
    }
}

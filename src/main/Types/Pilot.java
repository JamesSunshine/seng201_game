package main.Types;

public class Pilot extends CrewMember {

    private int hunger = 10;
    private int tiredness = 10;
    private int health = 10;
    private String spec = "I can fly";
    private int hungerChange = -2;
    private int tirednessChange = -2;


    public Pilot(String name) {

    	super(name, 15, 0, 0, 20, 20, "Pilot");
    }
}

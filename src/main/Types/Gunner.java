package main.Types;

public class Gunner extends CrewMember {

    private int hunger = 10;
    private int tiredness = 10;
    private int health = 10;
    private String spec = "Shooty Boi";
    private int hungerChange = -2;
    private int tirednessChange = -1;


    public Gunner(String name) {

    	super(name, 15, 10, 10, -2, -2, "Gunner");
    }
}

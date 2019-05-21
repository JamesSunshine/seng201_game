package main.Types;

public class Scout extends CrewMember {

    private int hunger = 10;
    private int tiredness = 10;
    private int health = 15;
    private String spec = "I find things";
    private int hungerChange = -2;
    private int tirednessChange = -2;


    public Scout(String name) {

    	super(name, 15, 10, 10, -2, -2);
    }
}

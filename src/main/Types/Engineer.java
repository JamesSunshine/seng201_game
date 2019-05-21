package main.Types;

public class Engineer extends CrewMember {

    private int hunger = 10;
    private int tiredness = 10;
    private int health = 15;
    private String spec = "Quick Fix";
    private int hungerChange = -2;
    private int tirednessChange = -2;


    public Engineer(String name) {

        super(name);
    }
}

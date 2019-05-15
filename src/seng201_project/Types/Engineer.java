package seng201_project.Types;

public class Engineer extends CrewMember {

    private int hunger = 10;
    private int tiredness = 10;
    private int health = 15;
    private String spec = "Quick Fix";
    private int HungerChange = -2;
    private int TirednessChange = -2;


    public Engineer(String name) {
        super(name);
    }



    @Override
    public void hungerDay() {
        hunger -= 2;
    }
}

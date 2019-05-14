package seng201_project.Types;

class Pilot extends CrewMember {

    private int hunger = 10;
    private int tiredness = 10;
    private int health = 10;
    private String spec = "I can fly";
    private int HungerChange = -2;
    private int TirednessChange = -2;


    Pilot(String name) {
        super(name);
    }
}

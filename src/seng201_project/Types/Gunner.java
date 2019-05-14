package seng201_project.Types;

class Gunner extends CrewMember {

    private int hunger = 10;
    private int tiredness = 10;
    private int health = 10;
    private String spec = "Shooty Boi";
    private int HungerChange = -2;
    private int TirednessChange = -1;

    Gunner(String name) {
        super(name);
    }
}

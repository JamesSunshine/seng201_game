package seng201_project.Types;

class Scout extends CrewMember {

    private int hunger = 10;
    private int tiredness = 10;
    private int health = 20;
    private String spec = "I find things";
    private int HungerChange = -2;
    private int TirednessChange = -2;


    Scout(String name) {
        super(name);
    }
}

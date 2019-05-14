package seng201_project.Types;

class Grunt extends CrewMember {

    private int hunger = 10;
    private int tiredness = 10;
    private int health = 5;
    private String spec = "";
    private int HungerChange = -1;
    private int TirednessChange = -1;


    Grunt(String name) {
        super(name);
    }
}

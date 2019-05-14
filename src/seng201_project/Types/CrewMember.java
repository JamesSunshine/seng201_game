package seng201_project.Types;

public abstract class CrewMember {
    protected String name;
    protected int hunger;
    protected int tiredness;

    CrewMember(String mName) {
        name = mName;
    }


    void hungerDay() {
        hunger -= 1;
    }
}

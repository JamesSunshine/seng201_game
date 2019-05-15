package seng201_project.Types;

import java.util.ArrayList;

public abstract class CrewMember {

    protected String name;
    protected int hunger;
    protected int tiredness;
    private boolean isSick = false;

    public CrewMember(String mName) {
        name = mName;
    }

    void hungerDay() {
        hunger -= 1;
    }
}

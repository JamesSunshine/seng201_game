package seng201_project;

import java.lang.annotation.Inherited;

class Engineer extends CrewMember {

    private int hunger = 20;
    private int tiredness = 30;


    Engineer(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Engineer(name=\"" + name + "\", health=" + hunger + ")";
    }

    @Override
    public void hungerDay() {
        hunger -= 2;
    }
}

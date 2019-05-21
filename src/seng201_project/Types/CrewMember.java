package seng201_project.Types;

import java.util.ArrayList;

public abstract class CrewMember {

    protected String name;
    protected int hunger;
    protected int tiredness;
    private boolean hasAids = false;

    public CrewMember(String mName) {
        name = mName;
    }

    void hungerDay() {
        hunger -= 1;
    }

    public void takeDamage(){

    }

    public void heal(int healingAmount){

    }

    public void contractAids(){
        this.hasAids = true;
    }

    public void getHungry(){

    }

    public void eatFood(){

    }

    public void getTired(){

    }

    public void sleep(){

    }
}

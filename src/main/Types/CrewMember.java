package main.Types;

public abstract class CrewMember {

    protected String name;
    protected int hunger;
    protected int tiredness;
    private boolean hasAids = false;
    private int numActions = 2;
    private int hungerChange = 0;
    private int tirednessChange = 0;

    public CrewMember(String mName) {
        name = mName;
    }

    public void takeDamage(){

    }

    /**
     * heals crewmember for an amount of HP
     * @param healingAmount amount of HP healed by item
     */
    public void heal(int healingAmount){

    }

    public void contractAids(){
        this.hasAids = true;
    }

    public void getHungry() {
        hunger = hunger + hungerChange;
    }
    public void getTired(){
        tiredness = tiredness + tirednessChange;
    }

    public void useAction(){

    }

    public void resetActions(){
        numActions = 2;
    }
}

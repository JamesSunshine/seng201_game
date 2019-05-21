package main.Types;

public abstract class CrewMember {

    protected String name;
    protected int health = 10;
    protected int hunger;
    protected int tiredness;
    private boolean hasAids = false;
    private int numActions = 2;
    public int hungerChange = 0;
    private int tirednessChange = 0;

    public CrewMember(String mName, int mhealth, int mhunger, int mtiredness, int mhungerChange, int mtirednessChange) {
        name = mName;
        health = mhealth;
        hunger = mhunger;
        tiredness = mtiredness;
        hungerChange = mhungerChange;
        tirednessChange = mtirednessChange;
    }

    
	public int getHunger() {
		return hunger;
	}


	public void setHunger(int hunger) {
		this.hunger = hunger;
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

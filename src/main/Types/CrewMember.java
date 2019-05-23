package main.Types;

public abstract class CrewMember {

    protected String name;
    protected int health = 10;
    protected int hunger;
    protected int maxHealth = health;
    protected int tiredness;
    private boolean hasAids = false;
    private int numActions = 2;
    public int hungerChange = 0;
    private int tirednessChange = 0;
    private String type;
    private boolean dead = false;

    public CrewMember(String mName, int mhealth, int mhunger, int mtiredness, int mhungerChange, int mtirednessChange, String mtype) {
        name = mName;
        health = mhealth;
        hunger = mhunger;
        tiredness = mtiredness;
        hungerChange = mhungerChange;
        tirednessChange = mtirednessChange;
        type = mtype;
        maxHealth = mhealth;
    }

    public String getType() {
    	return type;
    }
    
    public void setDead() {
    	dead = true;
    }
    
    public boolean isDead() {
    	if (dead) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public int getHealth() {
    	return (int) (((double)health / (double)maxHealth) * 100);
    }
    
    public int getmaxHealth() {
    	return maxHealth;
    }
    
	public int getHunger() {
		return hunger;
	}
	
	public int getTiredness() {
		return tiredness;
	}
	
	public String getName() {
		return name;
	}
	
	public int getActions() {
		return numActions;
	}


	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	
	public void sleep() {
		tiredness -= 30;
	}
    public void takeDamage(int damage){
    		health -= damage;
    }

    /**
     * heals crewmember for an amount of HP
     * @param healingAmount amount of HP healed by item
     */
    public void heal(int healingAmount){
    	if (health + healingAmount >= maxHealth){
    		health = maxHealth;
    	}
    	else {
    		health += healingAmount;
    	}
    }

    public void contractAids(){
        this.hasAids = true;
    }
    
    public boolean gotAids() {
    	return this.hasAids;
    }
    
    public void cureAids() {
    	this.hasAids = false;
    }

    public void eat(int food) {
    	if ((hunger - food) <= 0) {
    		hunger = 0;
    	}
    	else {
    		hunger -= food;
    	}
    }
    
    public void getHungry() {
        hunger = hunger + hungerChange;
    }
    
    public void getTired(){
        tiredness = tiredness + tirednessChange;
    }

    public void useAction(){
    	numActions -= 1;
    }

    public void resetActions(){
        numActions = 2;
    }
}

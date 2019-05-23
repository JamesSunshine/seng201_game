package main.Types;

// TODO: Auto-generated Javadoc
/**
 * The Class CrewMember.
 */
public abstract class CrewMember {

    /** The name. */
    protected String name;
    
    /** The health. */
    protected int health = 10;
    
    /** The hunger. */
    protected int hunger;
    
    /** The max health. */
    protected int maxHealth = health;
    
    /** The tiredness. */
    protected int tiredness;
    
    /** The has aids. */
    private boolean hasAids = false;
    
    /** The num actions. */
    private int numActions = 2;
    
    /** The hunger change. */
    public int hungerChange = 0;
    
    /** The tiredness change. */
    private int tirednessChange = 0;
    
    /** The type. */
    private String type;
    
    /** The dead. */
    private boolean dead = false;

    /**
     * Instantiates a new crew member.
     *
     * @param mName the m name
     * @param mhealth the mhealth
     * @param mhunger the mhunger
     * @param mtiredness the mtiredness
     * @param mhungerChange the mhunger change
     * @param mtirednessChange the mtiredness change
     * @param mtype the mtype
     */
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

    /**
     * Gets crew member type type.
     *
     * @return the type
     */
    public String getType() {
    	return type;
    }
    
    /**
     * Sets crew member dead.
     */
    public void setDead() {
    	dead = true;
    }
    
    /**
     * Checks if crew member is dead.
     *
     * @return true, if crew member is dead
     */
    public boolean isDead() {
    	if (dead) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Gets crew members current health.
     *
     * @return health
     */
    public int getHealth() {
    	return (int) (((double)health / (double)maxHealth) * 100);
    }
    
    /**
     * Gets a crew members max health.
     *
     * @return the max health
     */
    public int getmaxHealth() {
    	return maxHealth;
    }
    
	/**
	 * Gets crew member hunger.
	 *
	 * @return hunger
	 */
	public int getHunger() {
		return hunger;
	}
	
	/**
	 * Gets crew members tiredness.
	 *
	 * @return tiredness
	 */
	public int getTiredness() {
		return tiredness;
	}
	
	/**
	 * Gets the crew members name.
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets number of actions a crew member has
	 *
	 * @return the actions
	 */
	public int getActions() {
		return numActions;
	}


	/**
	 * Sets the hunger.
	 *
	 * @param hunger
	 */
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	
	/**
	 * Sleeps crewmember reducing tiredness
	 */
	public void sleep() {
		tiredness -= 30;
	}
    
    /**
     * Does damage to crewmember.
     *
     * @param damage 
     */
    public void takeDamage(int damage){
    		health -= damage;
    }

    /**
     * Heal crew member.
     *
     * @param healingAmount is the healing amount
     */
    public void heal(int healingAmount){
    	if (health + healingAmount >= maxHealth){
    		health = maxHealth;
    	}
    	else {
    		health += healingAmount;
    	}
    }

    /**
     * Contract aids.
     */
    public void contractAids(){
        this.hasAids = true;
    }
    
    /**
     * Checks member has aids.
     *
     * @return true, if successful
     */
    public boolean gotAids() {
    	return this.hasAids;
    }
    
    /**
     * Cure aids.
     */
    public void cureAids() {
    	this.hasAids = false;
    }

    /**
     * crew member Eats dcreasing hunger.
     *
     * @param food
     */
    public void eat(int food) {
    	if ((hunger - food) <= 0) {
    		hunger = 0;
    	}
    	else {
    		hunger -= food;
    	}
    }
    
    /**
     *  Increases crewmember hunger.
     *
     */
    public void getHungry() {
        hunger = hunger + hungerChange;
    }
    
    /**
     * Increases Crewmember tiredness.
     *
     */
    public void getTired(){
        tiredness = tiredness + tirednessChange;
    }

    /**
     * Use action.
     */
    public void useAction(){
    	numActions -= 1;
    }

    /**
     * Reset actions.
     */
    public void resetActions(){
        numActions = 2;
    }
}

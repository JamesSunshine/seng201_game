package main;

import java.util.Random;


/**
 * The Class Planet.
 */
public class Planet {

    /** The name. */
    public String name;
    
    /** has the planet been searched. */
    public boolean searched = false;
    
    /**
     * Instantiates a new planet.
     */
    public Planet() {
    	name = nameGenerator();
    }


    /**
     * Name generator.
     *
     * @return the string
     */
    public String nameGenerator() {

       String[] Beginning = { "Kr", "Ca", "Ra", "Mrok", "Cru",
             "Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol",
             "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",
             "Mar", "Luk" };
       String[] Middle = { "air", "ir", "mi", "sor", "mee", "clo",
             "red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer",
             "marac", "zoir", "slamar", "salmar", "urak" };
       String[] End = { "d", "ed", "ark", "arc", "es", "er", "der",
             "tron", "med", "ure", "zur", "cred", "mur" };
       
       Random rand = new Random();


       return name =	Beginning[rand.nextInt(Beginning.length)] + 
                		Middle[rand.nextInt(Middle.length)]+
                		End[rand.nextInt(End.length)];
    }

    /**
     * Gets the planet name.
     *
     * @return the planet name
     */
    public String getplanetName() {
    	return name;
    }
    
    /**
     * Check searched.
     *
     * @return true, if successful
     */
    public boolean checkSearched() {
    	return searched;
    }
    
    /**
     * Sets searched to true.
     */
    public void setSearched() {
    	searched = true;
    }
}

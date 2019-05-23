package main;

import java.util.Random;

public class Planet {

    public String name;
    public boolean searched = false;
    
    public Planet() {
    	name = nameGenerator();
    }


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

    public String getplanetName() {
    	return name;
    }
    
    public boolean checkSearched() {
    	return searched;
    }
    
    public void setSearched() {
    	searched = true;
    }
}

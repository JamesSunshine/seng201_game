package seng201_project;

public class Event {

    private int damage;
    private int threshold = 10;
    private double occurrence;

    public boolean spacePirates() {

        occurrence = Math.random() * ((20 - 1) + 1) + 1;
        if (occurrence >= threshold) {
            damage = 10;
        	System.out.println("Your ship was attacked by space pirates "
        			+ "durning flight. ");
        	return true;
        }
        return false;
    }

    public boolean spaceAids() {

        occurrence = Math.random() * ((20 - 1) + 1) + 1;
        if (occurrence >= threshold) {
            return true;
        }

        return false;

    }

    public void asteroidBelt() {

        occurrence = Math.random() * ((20 - 1) + 1) + 1;
        if (occurrence >= threshold) {
            damage = 10;
        	System.out.println("Your ship ran into an asteroid belt durning flight "
            		+ "and sustained " + damage + "damage.");
        }
    }
}

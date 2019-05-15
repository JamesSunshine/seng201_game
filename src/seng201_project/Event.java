package seng201_project;

public class Event {

    private int damage;
    private int threshold = 10;
    private double occurrence;

    public boolean spacePirates() {

        occurrence = Math.random() * ((20 - 1) + 1) + 1;
        if (occurrence >= threshold) {
            return false;
        }

        return true;
    }

    public boolean spaceAids() {

        occurrence = Math.random() * ((20 - 1) + 1) + 1;
        if (occurrence >= threshold) {
            return false;
        }

        return true;

    }

    public boolean asteroidBelt() {

        occurrence = Math.random() * ((20 - 1) + 1) + 1;
        if (occurrence >= threshold) {
            return false;
        }

        return true;

    }
}

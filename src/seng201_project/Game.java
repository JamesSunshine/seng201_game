package seng201_project;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        String shipName;
        System.out.print("Enter ship name: ");
        shipName = user_input.next();
        Ship.createShip(shipName);
    }

}

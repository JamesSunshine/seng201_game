package seng201_project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private static int numberDays;
    private static int pointBuy;
    private static  String selection = "0";



    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        String shipName;                                                                                //Create ship
        System.out.print("Enter ship name: ");
        shipName = user_input.nextLine();
        Ship.createShip(shipName);
        CrewFactory crewFactory = new CrewFactory();
        }



    }

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

        while ((numberDays < 3) || (numberDays > 10)) {             //Enter number of days
            System.out.print("How many days is your voyage?: ");
            try {
            	numberDays = user_input.nextInt();
            }
            catch (InputMismatchException e) {
            	System.out.print("REEEEEEE");
            }
        
            if ((numberDays < 3) || (numberDays > 10)) {
                System.out.print("Number of days must be between 3 and 10\n");
            }
        }

        pointBuy = numberDays * 2;
        while ((pointBuy > 0) && ((Ship.crewList.size() < 2) || (Ship.crewList.size() != 4))) {             //Buy Crew for your ship
            System.out.print("What crew would you like to buy? Max 4, Min 2: Current points " + pointBuy +
                    "\n1: Grunt 1 point\n" + "2: Gunner 2 points\n3: Pilot 3 points\n4: Medic 4 points\n" +
                    "5: Engineer 5 points\n6: Scout 5 point\nEnter value:");
            selection = user_input.next();

            if ((pointBuy - Integer.parseInt(selection) < 0) || (Integer.parseInt(selection) > 6)){
                System.out.print("You do not have enough points for that selection.\n");
            } else if (Integer.parseInt(selection) == 6) {
                pointBuy = pointBuy - 5;
                crewFactory.recruit("scout", "Scott");
            } else {
                pointBuy = pointBuy - Integer.parseInt(selection);
                switch (selection) {

                    case "1": {
                        crewFactory.recruit("grunt", "Trent");
                        break;
                    }

                    case "2": {
                        crewFactory.recruit("gunner", "Gary");
                        break;
                    }

                    case "3": {
                        crewFactory.recruit("pilot", "Dave");
                        break;
                    }

                    case "4": {
                        crewFactory.recruit("medic", "Bob");
                        break;
                    }

                    case "5": {
                        crewFactory.recruit("engineer", "Mitch");
                        break;
                    }
                }

            }
        }



    }

}

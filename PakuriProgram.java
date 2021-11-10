import java.util.Scanner;
import java.util.InputMismatchException;
public class PakuriProgram {

    public static void main(String[] args) {

        Pakudex pakudex;
        int num;

        Scanner scanner = new Scanner(System.in);
	    System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.println("Enter max capacity of the Pakudex: ");

        //This causes an error when letters or negative numbers are used.
        String userInput = scanner.next();
        while (true) {
            //This causes an error when letters are used
            if (isInt(userInput) == false) {
                System.out.println("Please enter a valid size.");
                System.out.println("Enter max capacity of the Pakudex: ");
                userInput = scanner.next();
                continue;
            }
            //This causes an error when negative numbers are used.
            if (Integer.parseInt(userInput) < 0) {
                System.out.println("Please enter a valid size.");
                System.out.println("Enter max capacity of the Pakudex: ");
                userInput = scanner.next();
                continue;
            }
            break;
        }
        //This converts num into an integer
        num = Integer.parseInt(userInput);
        pakudex = new Pakudex(num);
        System.out.println("The Pakudex can hold " + num +  " species of Pakuri.");
        System.out.println("");


        //This prints the menu
        boolean continueGame = true;
            while(continueGame == true) {
                System.out.println("Pakudex Main Menu");
                System.out.println("-----------------");
                System.out.println("1. List Pakuri");
                System.out.println("2. Show Pakuri");
                System.out.println("3. Add Pakuri");
                System.out.println("4. Evolve Pakuri");
                System.out.println("5. Sort Pakuri");
                System.out.println("6. Exit");
                System.out.println("");
                System.out.println("What would you like to do?");

                String userInput2 = scanner.next();
                while (true) {
                    //This causes an error when letters are used
                    if (isInt(userInput2) == false) {
                        System.out.println("Unrecognized menu selection!");
                        System.out.println("Pakudex Main Menu");
                        System.out.println("-----------------");
                        System.out.println("1. List Pakuri");
                        System.out.println("2. Show Pakuri");
                        System.out.println("3. Add Pakuri");
                        System.out.println("4. Evolve Pakuri");
                        System.out.println("5. Sort Pakuri");
                        System.out.println("6. Exit");
                        System.out.println("");
                        System.out.println("What would you like to do?");
                        userInput2 = scanner.next();
                        continue;
                    }
                    //This causes an error when negative numbers are used.
                    if (Integer.parseInt(userInput2) < 0) {
                        System.out.println("Unrecognized menu selection!");
                        System.out.println("Pakudex Main Menu");
                        System.out.println("-----------------");
                        System.out.println("1. List Pakuri");
                        System.out.println("2. Show Pakuri");
                        System.out.println("3. Add Pakuri");
                        System.out.println("4. Evolve Pakuri");
                        System.out.println("5. Sort Pakuri");
                        System.out.println("6. Exit");
                        System.out.println("");
                        System.out.println("What would you like to do?");
                        userInput2 = scanner.next();
                        continue;
                    }
                    break;
                }
                //This converts choice into an integer
                int choice = Integer.parseInt(userInput2);

                //This prints the list of pakuri
                if (choice == 1) {
                    String[] test = pakudex.getSpeciesArray();
                    if (pakudex.getSpeciesArray() == null) {
                        System.out.println("No Pakuri in Pakudex yet!");
                    } else {
                        System.out.println("Pakuri In Pakudex: ");
                    int count;
                    for(int i = 0; i < pakudex.getSize(); i++) {
                        count = 1 + i;
                        System.out.println(count + ". " + test[i]);
                    }
                    }

                    //This displays the stats for the pakuri
                } else if (choice == 2) {
                    System.out.println("Enter the name of the species to display: ");
                    String speciesDisplay = scanner.next();
                    //If no such pakuri exists, this error message will be sent.
                    if (pakudex.getStats(speciesDisplay) == null) {
                        System.out.println("Error: No such Pakuri! ");
                    } else {
                    int[] printStat = pakudex.getStats(speciesDisplay);
                        System.out.print("Species: " + speciesDisplay);
                        System.out.println("Attack: " + printStat[0]);
                        System.out.println("Defense: " + printStat[1]);
                        System.out.println("Speed: " + printStat[2]);

                    }

                    //This adds a pakuri into the system.
                } else if (choice == 3) {
                    if (pakudex.getSize()-1 >= pakudex.getCapacity()-1) {
                        System.out.println("Error: Pakudex is full!");
                        continue;
                    }
                    System.out.println("Enter the name of the species to add: ");
                    String speciesAdd = scanner.next();
                    boolean full = pakudex.addPakuri(speciesAdd);
                    if (full == false) {
                        System.out.println("Error: Pakudex already contains this species!");
                    } else {
                        System.out.println("Pakuri species " + speciesAdd + " successfully added!");
                    }

                    //This evolves the pakuri
                } else if (choice == 4) {
                    System.out.println("Enter the name of the species to evolve: ");
                    String speciesEvolve = scanner.next();
                    if (pakudex.evolveSpecies(speciesEvolve) == false) {
                        System.out.println("Error: No such Pakuri!");
                    } else {
                        pakudex.evolveSpecies(speciesEvolve);
                        System.out.println(speciesEvolve + " has evolved!");
                    }
                    //This sorts the pakuri
                } else if (choice == 5) {
                    pakudex.sortPakuri();
                    System.out.println("Pakuri have been sorted!");
                    //This exits the pakudex
                } else if (choice == 6) {
                    System.out.println("Thanks for using Pakudex! Bye!");
                    continueGame = false;
                //This ensures that a number 1-6 is chosen.
                } else {
                    System.out.println("Unrecognized menu selection!");
                }

            }

    }
    //This tests to see if the input is a valid input
    public static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

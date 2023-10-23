import java.util.*;

public class Week4Task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String playerName;

        // Introduction
        System.out.println("Welcome to the Haunted House Adventure!");
        System.out.print("Enter your name: ");
        playerName = sc.nextLine();
        System.out.println("Hello, " + playerName + "!\n");

        // Start of the game
        System.out.println("You find yourself standing in front of an old, creepy house.");
        System.out.println("Do you want to go inside? (yes/no)");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("You enter the house and hear a wierd sound. It's dark all around.");
            System.out.println("Do you want to turn on your flashlight? (yes/no)");
            choice = sc.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("You turn on your flashlight and see a long, dimly lit hallway.");
                System.out.println("There are two doors. Which one do you choose? (left/right)");
                choice = sc.nextLine();

                if (choice.equalsIgnoreCase("left")) {
                    System.out.println("You enter the left room and find a treasure chest!");
                    System.out.println("Congratulations, " + playerName + "! You win!");
                } else if (choice.equalsIgnoreCase("right")) {
                    System.out.println("You enter the right room, and the door shut behind you.");
                    System.out.println("It's getting colder. You see a ghostly figure approaching.");
                    System.out.println("You're trapped! Game over.");
                } else {
                    System.out.println("Invalid input. You stand there confused and nothing happens.");
                }
            } else if (choice.equalsIgnoreCase("no")) {
                System.out.println("You choose not to turn on your flashlight.");
                System.out.println("You hear whispers but can't see anything.");
                System.out.println(
                        "Suddenly, something grabs you. You scream, and it's too late!. You are no more my friend.");
                System.out.println("Game over, " + playerName + "!");
            } else {
                System.out.println("Invalid input. You stand there in the dark and nothing happens.");
            }
        } else if (choice.equalsIgnoreCase("no")) {
            System.out.println("Coward!! You decide not to enter the house and walk away.");
            System.out.println("The end. Thanks for playing, " + playerName + "!");
        } else {
            System.out.println(
                    "Invalid input. You can't decide what to do and stand there as you don't have any work to do!.");
        }

    }
}

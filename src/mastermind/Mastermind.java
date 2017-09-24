/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * Chapter 4 Exercise 3
 *
 * Develop an algorithm for a simple 5-digit secret code guessing game.
 *
 * When the user enters a guess at the code, the program will return two values:
 *
 * 1) The number of digits in the guess that are in the correct position (e.g If
 * the secret code is 53840, and the user guesses 83241, the digits 3 and 4, so
 * the program should return the number 2)
 *
 * 2) The sum of the digits guessed correctly (e.g. From the previous example
 * above, if the user guessed 3 and 4 correctly, the sum that should be returned
 * would be 7)
 *
 * Allow the user to guess a fixed number of times (e.g. 3)
 *
 * @author skiroc
 */
public class Mastermind {

    // Hard-coding the number of guesses a user can attempt to crack the secret code
    public static int NUMBER_OF_GUESSES = 5;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Instance Variables
        Scanner kb = new Scanner(System.in);
        Random randomNumber = new Random();

        int secretCode, usersGuess;

        // Generating a random 5-digit number
        secretCode = 10000 + randomNumber.nextInt(90000);
        System.out.println(secretCode);

        /**
         * TODO: Compare integers in LinkedLists
         **/
        
        // Separating the 5-digit secret code into a LinkedList
//        LinkedList<Integer> secretCodeDigits = separateDigits(secretCode);

        System.out.println("I am thinking of a 5-digit code, can you crack it?");
        while (NUMBER_OF_GUESSES != 0) {
            usersGuess = kb.nextInt();

            // Separating the user's guess into a LinkedList
//            LinkedList<Integer> userGuessDigits = separateDigits(usersGuess);

            int result = Integer.compare(secretCode, usersGuess);

            switch (result) {
                case 0:
                    System.out.println("You cracked the code!" + "\n"
                            + "The secret is " + secretCode);
                    System.exit(0);
                case 1:
                    System.out.println("Sorry, that was an incorrect guess, "
                            + "please try again");
                    NUMBER_OF_GUESSES--;
                    System.out.println("You have " + NUMBER_OF_GUESSES + " guesse remaining." );
                    break;
                default:
                    break;
            } // end switch

        } // end while
        
        if (NUMBER_OF_GUESSES == 0) {
            System.out.println("You lose!");
            System.exit(0);
        }

    } // end main

    public static LinkedList<Integer> separateDigits(int number) {

        // Creating a Linked List to place the separated digits of the secret code
        LinkedList<Integer> digits = new LinkedList<Integer>();

        // Using the mod operator to separate the 5 digits of the secret code 
        while (number > 0) {
            digits.push(number % 10);
            number = number / 10;
        }

        while (!digits.isEmpty()) {
            digits.pop();
        }

        return digits;
    } // end public LinkedList<Integer> separateSecretCodeDigits(int number)

} // end class

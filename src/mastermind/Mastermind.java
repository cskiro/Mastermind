/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

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
    public static int NUMBER_OF_GUESSES = 3;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Instance Variables
        Scanner kb = new Scanner(System.in);
        Random randomNumber = new Random();

        int secretCode, usersGuess;

        // Generating a random 5-digit number
        secretCode = 100 + randomNumber.nextInt(900);
        System.out.println(secretCode);

        // Converting secret code number into a string
        String secret = String.valueOf(secretCode);

        System.out.println("I am thinking of a 5-digit code, can you crack it?");
        while (NUMBER_OF_GUESSES != 0) {
            usersGuess = kb.nextInt();

            String guess = String.valueOf(usersGuess);

            for (int i = 0; i < secret.length(); i++) {
                for (int j = 0; j < guess.length(); j++) {
                    Character c1 = secret.charAt(i);
                    Character c2 = guess.charAt(j);
                    String s1 = c1.toString();
                    String s2 = c2.toString();
                    int x = Integer.parseInt(s1);
                    int y = Integer.parseInt(s2);
                    
                    if (x == y) {
                        System.out.print(s1 + " matches " + s2 + " at position " + (i + 1) + "\n");
                    } // end if

            } // end for j
            
        } // end for i
            
            boolean doesMatch = secret.equals(guess);
                    
                    if (doesMatch) {
                        System.out.println("You cracked the code!" + "\n"
                                + "The secret is " + secretCode);
                        System.exit(0);
                    } else {
                        NUMBER_OF_GUESSES--;
                        System.out.println("You have " + NUMBER_OF_GUESSES + " guesses remaining.");
                    }
                } // end while

                if (NUMBER_OF_GUESSES == 0) {
                    System.out.println("You lose!");
                    System.exit(0);
                }

    } // end main

} // end class

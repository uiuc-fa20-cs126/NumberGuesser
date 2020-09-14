package edu.illinois;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * `NumberGuesser1`.
 * @author anonymous.
 */
public class NumberGuesser1 {
    private int lo;
    private int hi;

    public NumberGuesser1(int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
    }

    /**
     * Plays the game and returns the number of attempts taken to guess the correct answer.
     * @return the number of attempts if successful, else returns -1.
     */
    public int play() {
        Scanner input = new Scanner(System.in);
        final int correctNum = Utils.randomInteger(lo, hi);
        int numAttempts = 0;
        System.out.print("Implementation 1\n================\nType a number between ");
        System.out.print(lo);
        System.out.print(" and ");
        System.out.print(hi);
        System.out.print(": ");

        while (input.hasNextInt()) {
            // Check if input is valid.
            int guessedNum;
            try {
                guessedNum = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You didn't input a number.");
                continue;
            } finally {
               ++numAttempts;
            }

            // Process input.
            if (guessedNum > correctNum) {
                System.out.println("Too high!");
            } else if (guessedNum < correctNum) {
                System.out.println("Too low!");
            } else {
                // They guessed the correct number.
                System.out.println("Yay! " + correctNum + " was the correct number.");
                return numAttempts;
            }

            System.out.print("Type another number: ");
        }

        return -1;
    }
}

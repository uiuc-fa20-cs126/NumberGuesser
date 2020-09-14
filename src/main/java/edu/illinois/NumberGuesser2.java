package edu.illinois;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * `NumberGuesser2`.
 * @author anonymous.
 */
public class NumberGuesser2 {
    private int lo;
    private int hi;

    public NumberGuesser2(int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
    }

    public int play() {
        return play(System.in);
    }

    /**
     * Plays the game and returns the number of attempts taken to guess the correct answer.
     * @param inputStream
     * @return the number of attempts if successful, else returns -1.
     */
    public int play(InputStream inputStream) {
        Scanner input = new Scanner(inputStream);
        final int correctNum = Utils.randomInteger(lo, hi);
        int numAttempts = 0;
        System.out.print("Implementation 2\n================\nType a number: ");

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

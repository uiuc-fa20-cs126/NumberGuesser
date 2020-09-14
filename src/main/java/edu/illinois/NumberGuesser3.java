package edu.illinois;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * `NumberGuesser3`.
 * @author David Brewster.
 */
public class NumberGuesser3 {
    private int lo;
    private int hi;
    private PrintStream logger;

    public NumberGuesser3(int lo, int hi) {
        // Use System.out by default.
        this(lo, hi, System.out);
    }

    public NumberGuesser3(int lo, int hi, OutputStream outputStream) {
        this.lo = lo;
        this.hi = hi;
        this.logger = new PrintStream(outputStream);
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
        logger.print("Implementation 3\n================\nType a number: ");

        while (input.hasNext()) {
            // Check if input is valid.
            int guessedNum;
            try {
                guessedNum = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.print(input.next());
                System.out.println(" is not a number.  Try again.");
                continue;
            } finally {
               ++numAttempts;
            }

            // Process input.
            if (guessedNum > correctNum) {
                logger.println("Too high!");
            } else if (guessedNum < correctNum) {
                logger.println("Too low!");
            } else {
                // They guessed the correct number.
                logger.println("Yay! " + correctNum + " was the correct number.");
                return numAttempts;
            }

            logger.print("Type another number: ");
        }

        return -1;
    }
}
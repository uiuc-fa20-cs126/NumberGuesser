package edu.illinois;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * `NumberGuesser4`.
 * @author David Brewster.
 */
public class NumberGuesser4 {
    private int lo;
    private int hi;
    private PrintStream logger;
    private Integer correctNum;

    public NumberGuesser4(int lo, int hi) {
        // Use System.out by default.
        this(lo, hi, System.out);
    }

    public NumberGuesser4(int lo, int hi, OutputStream outputStream) {
        this.lo = lo;
        this.hi = hi;
        this.logger = new PrintStream(outputStream);
        this.correctNum = null;
    }

    /**
     * Attempts to get the guess from the input source.
     * @param input
     * @return
     */
    private Integer getGuess(Scanner input) {
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            logger.println("You didn't input a number.");
            return null;
        }
    }

    /**
     * Determines whether or not the guess was correct.
     * @param guessedNum
     * @return
     */
    private boolean isCorrectGuess(int guessedNum) {
        if (guessedNum > correctNum) {
            logger.println("Too high!");
            return false;
        } else if (guessedNum < correctNum) {
            logger.println("Too low!");
            return false;
        } else {
            // They guessed the correct number.
            logger.println("Yay! " + correctNum + " was the correct number.");
            return true;
        }
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
        correctNum = Utils.randomInteger(lo, hi);
        int numAttempts = 0;
        logger.print("Implementation 4\n================\nType a number: ");

        while (input.hasNext()) {
            // Check if input is valid.
            Integer guessedNum = getGuess(input);
            ++numAttempts;

            if (guessedNum == null) {
                System.out.print(input.next());
                System.out.println(" is not a number.  Try again.");
                continue;
            }

            if (isCorrectGuess(guessedNum)) {
                return numAttempts;
            }

            logger.print("Type another number: ");
        }

        return -1;
    }
}

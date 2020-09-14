package edu.illinois;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * `NumberGuesser4`.
 * @author anonymous.
 */
public class NumberGuesser5 {
    private int lo;
    private int hi;
    private PrintStream logger;
    private Random rng;

    public NumberGuesser5(int lo, int hi) {
        this(lo, hi, new Random());
    }

    public NumberGuesser5(int lo, int hi, Random rng) {
        // Use System.out by default.
        this(lo, hi, rng, System.out);
    }

    public NumberGuesser5(int lo, int hi, Random rng, OutputStream outputStream) {
        this.lo = lo;
        this.hi = hi;
        this.rng = rng;
        this.logger = new PrintStream(outputStream);
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
    private boolean isCorrectGuess(int guessedNum, int correctNum) {
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
        return play(Utils.randomInteger(lo, hi, rng));
    }

    public int play(int correctNum) {
        return play(correctNum, System.in);
    }

    public int play(InputStream inputStream) {
        return play(Utils.randomInteger(lo, hi, rng), inputStream);
    }

    /**
     * Plays the game and returns the number of attempts taken to guess the correct answer.
     * @param inputStream
     * @return the number of attempts if successful, else returns -1.
     */
    public int play(int correctNum, InputStream inputStream) {
        Scanner input = new Scanner(inputStream);
        int numAttempts = 0;
        logger.print("Implementation 5\n================\nType a number: ");

        while (input.hasNextInt()) {
            // Check if input is valid.
            Integer guessedNum = getGuess(input);
            ++numAttempts;

            if (guessedNum == null) {
                continue;
            }

            if (isCorrectGuess(guessedNum, correctNum)) {
                return numAttempts;
            }

            logger.print("Type another number: ");
        }

        return -1;
    }
}


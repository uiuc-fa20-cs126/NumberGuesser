package edu.illinois;

//import com.sun.xml.internal.ws.util.StringUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.*;

public class NumberGuesser5Test {
    private static final long SEED = 2020;
    private Random rng;
    ByteArrayInputStream inputStream;
    ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        rng = new Random(SEED);

        String[] guesses = { "1", "2", "3", "4", "5" };
        String input = String.join("\n", guesses) + "\n";

        inputStream = Utils.fromString(input);
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void maxNumberOfAttempts() {
        NumberGuesser5 game = new NumberGuesser5(1, 5, rng, outputStream);
        int attempts = game.play(inputStream);

        assertTrue("Number of attempts is at most 5", attempts <= 5);

        // We know for this case, the number of attempts == the correct number.
        final int correctNum = attempts;
        String output = outputStream.toString();
        Assert.assertThat(output, CoreMatchers.containsString("Yay! " + correctNum + " was the correct number"));
    }

    @Test
    public void exactNumberOfAttempts() {
        NumberGuesser5 game = new NumberGuesser5(1, 5, rng, outputStream);

        final int futureCorrectNum = Utils.randomInteger(1, 5, rng);
        rng.setSeed(SEED);

        int attempts = game.play(inputStream);

        assertEquals("Number of attempts is exactly " + futureCorrectNum, attempts, futureCorrectNum);

        String output = outputStream.toString();
        String expectedSubstring = String.join("\n", Collections.nCopies(attempts-2, "Type another number: Too low!"));
        Assert.assertThat(output, CoreMatchers.containsString(expectedSubstring));
    }
}
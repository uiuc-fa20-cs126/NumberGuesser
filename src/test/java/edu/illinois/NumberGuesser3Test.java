package edu.illinois;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class NumberGuesser3Test {
    @Test
    public void maxNumberOfAttempts() {
        String[] guesses = { "1", "2", "3", "4", "5" };
        String input = String.join("\n", guesses) + "\n";

        ByteArrayInputStream inputStream = Utils.fromString(input);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        NumberGuesser3 game = new NumberGuesser3(1, 5, outputStream);
        int attempts = game.play(inputStream);

        assertTrue("Number of attempts is at most 5", attempts <= 5);

        // We know for this case, the number of attempts == the correct number.
        int correctNum = attempts;
        String output = outputStream.toString();
        Assert.assertThat(output, CoreMatchers.containsString("Yay! " + correctNum + " was the correct number"));
    }
}
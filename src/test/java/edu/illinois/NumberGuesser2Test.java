package edu.illinois;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class NumberGuesser2Test {
    @Test
    public void maxNumberOfAttempts() {
        String[] guesses = { "1", "2", "3", "4", "5" };
        String input = String.join("\n", guesses) + "\n";
        ByteArrayInputStream inputStream = Utils.fromString(input);

        NumberGuesser2 game = new NumberGuesser2(1, 5);
        int attempts = game.play(inputStream);

        assertTrue("Number of attempts is at most 5", attempts <= 5);

        // ?? How do I test the output though ...
    }
}

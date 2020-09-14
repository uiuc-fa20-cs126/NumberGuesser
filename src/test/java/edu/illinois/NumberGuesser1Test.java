package edu.illinois;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumberGuesser1Test {
    @Test
    public void works() {
        NumberGuesser1 game = new NumberGuesser1(1, 10);
        int attempts = game.play();
        // ???

        assertEquals(attempts, /* ??? */ 3);
    }
}

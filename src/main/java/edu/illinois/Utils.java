package edu.illinois;

import java.io.ByteArrayInputStream;
import java.util.Random;

/**
 * Source: http://www.java2s.com/Code/Java/Development-Class/Generatesarandomintegerinsidetheloandhiinterval.htm
 */
public class Utils {
    public static int randomInteger(int lo, int hi) {
        return randomInteger(lo, hi, new Random());
    }

    /**
     * Generates a random integer inside the lo and hi interval.
     * @param lo
     * @param hi
     * @param rng
     * @return the generated int.
     */
    public static int randomInteger(int lo, int hi, Random rng) {
        int n = hi - lo + 1;
        int i = rng.nextInt() % n;
        if (i < 0) i = -i;
        return lo + i;
    }

    /**
     * Creates an InputStream from the inputted string.
     * @param input
     * @return the newly created InputStream.
     */
    public static ByteArrayInputStream fromString(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}

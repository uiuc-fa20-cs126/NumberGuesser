package edu.illinois;
import java.io.*;

// demo command line arguments and file reading
//        for (String s : args)
//                System.out.println(s);
//
//                System.out.println(args[0]);
//
//                try
//                {
//                File file = new File(args[0]);
//                BufferedReader br = new BufferedReader(new FileReader(file));
//                System.out.println("file content: ");
//                int r = 0;
//                while((r=br.read())!=-1)
//                {
//                System.out.print((char)r);
//                }
//                }
//                catch(Exception e)
//                {
//                e.printStackTrace();
//                }


public class Main {
    private static final int LO = 1;
    private static final int HI = 100;

    public static void main(String[] args) {
        // Version 4.
//        NumberGuesser5 game5 = new NumberGuesser5(LO, HI);
//        int attempts5 = game5.play(50); // or `game5.play(System.in)` using overloaded method.
//        System.out.println("It took you " + attempts5 + " attempts.");
//        System.out.println();

        // Version 1.
        NumberGuesser1 game1 = new NumberGuesser1(LO, HI);
        int attempts1 = game1.play();
        System.out.println("It took you " + attempts1 + " attempts.");
        System.out.println();

        // Version 2.
        NumberGuesser2 game2 = new NumberGuesser2(LO, HI);
        int attempts2 = game2.play(); // or `game2.play(System.in)` using overloaded method.
        System.out.println("It took you " + attempts2 + " attempts.");
        System.out.println();

        // Version 3.
        NumberGuesser3 game3 = new NumberGuesser3(LO, HI);
        int attempts3 = game3.play(); // or `game2.play(System.in)` using overloaded method.
        System.out.println("It took you " + attempts3 + " attempts.");
        System.out.println();

        // Version 4.
        NumberGuesser4 game4 = new NumberGuesser4(LO, HI);
        int attempts4 = game4.play(); // or `game4.play(System.in)` using overloaded method.
        System.out.println("It took you " + attempts4 + " attempts.");
        System.out.println();

        // Version 5.
        NumberGuesser5 game6 = new NumberGuesser5(LO, HI);
        int attempts6 = game6.play(50); // or `game5.play(System.in)` using overloaded method.
        System.out.println("It took you " + attempts6 + " attempts.");
    }
}

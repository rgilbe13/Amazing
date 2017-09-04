// Copyright 2003, William C. Wake. All rights reserved.

import junit.framework.TestCase;

import java.util.Random;

public class TestAmazing extends TestCase {
    public void testSeed0size15x20() {
        String expected =
                "Amazing - Copyright by Creative Computing, Morristown, NJ\n" +
                ":--:--:--:--:--:--:--:--:--:--:  :--:--:--:--:\n" +
                "I  I           I        I     I     I        I \n" +
                ":  :  :  :  :  :  :--:  :  :  :  :--:  :--:  :\n" +
                "I     I  I  I  I     I     I     I     I  I  I \n" +
                ":--:--:  :  :--:  :  :--:--:--:--:  :  :  :  :\n" +
                "I     I  I        I  I              I  I     I \n" +
                ":  :  :  :--:--:--:  :  :  :--:--:--:--:--:--:\n" +
                "I  I     I        I     I  I     I        I  I \n" +
                ":--:--:  :--:  :--:  :--:  :  :  :  :--:  :  :\n" +
                "I     I        I        I  I  I     I     I  I \n" +
                ":  :  :--:--:--:  :--:  :  :  :--:--:  :--:  :\n" +
                "I  I              I     I  I  I     I  I     I \n" +
                ":  :--:--:--:--:--:--:  :  :  :  :--:  :--:  :\n" +
                "I        I           I  I  I  I     I  I     I \n" +
                ":  :--:  :--:  :  :  :  :  :  :--:  :  :  :--:\n" +
                "I  I     I     I  I  I  I  I     I  I  I  I  I \n" +
                ":  :  :--:  :--:  :  :  :  :--:  :  :  :  :  :\n" +
                "I  I        I     I  I  I        I  I  I  I  I \n" +
                ":  :--:  :--:  :--:  :  :--:--:--:  :  :  :  :\n" +
                "I     I     I  I  I  I  I     I        I     I \n" +
                ":--:  :--:  :  :  :  :--:  :  :  :--:--:  :--:\n" +
                "I  I     I  I     I     I  I  I     I  I     I \n" +
                ":  :--:  :--:--:--:  :  :  :  :--:  :  :  :  :\n" +
                "I     I     I     I  I  I  I     I  I  I  I  I \n" +
                ":  :  :--:  :  :  :--:  :  :--:  :  :  :  :  :\n" +
                "I  I        I  I     I  I     I     I  I  I  I \n" +
                ":  :--:--:  :--:  :  :  :--:  :--:--:  :  :--:\n" +
                "I  I     I        I  I     I     I     I     I \n" +
                ":  :  :--:--:--:--:  :  :--:  :  :  :--:--:  :\n" +
                "I     I           I  I     I  I  I  I     I  I \n" +
                ":  :--:  :--:--:--:  :--:  :  :  :  :  :  :  :\n" +
                "I  I                 I     I  I  I     I  I  I \n" +
                ":  :  :--:--:--:--:--:  :--:  :--:  :--:  :  :\n" +
                "I  I  I  I           I     I     I  I     I  I \n" +
                ":  :  :  :  :--:  :  :--:  :--:  :  :  :--:  :\n" +
                "I  I  I     I     I  I  I     I     I  I     I \n" +
                ":--:  :--:--:  :  :  :  :  :  :--:--:  :--:  :\n" +
                "I     I        I  I  I  I  I  I     I        I \n" +
                ":  :--:  :--:--:  :  :  :  :  :--:  :  :--:--:\n" +
                "I        I        I     I  I        I        I \n" +
                ":--:--:--:--:--:--:--:--:  :--:--:--:--:--:--:\n";

        Amazing.random = new Random(0);
        Amazing.horizontal = 15;
        Amazing.vertical = 20;
        Amazing.isCellComplete = new boolean[Amazing.horizontal + 1][Amazing.vertical + 1];
        Amazing.doit();

        assertEquals("Should have the maze that was expected", expected, Amazing.result.toString());
    }

    public void testSeed100size4x5() {
        String expected =
                "Amazing - Copyright by Creative Computing, Morristown, NJ\n" +
                ":--:--:  :--:\n" +
                "I     I     I \n" +
                ":  :--:  :  :\n" +
                "I  I     I  I \n" +
                ":  :  :--:  :\n" +
                "I  I  I     I \n" +
                ":  :  :  :  :\n" +
                "I  I  I  I  I \n" +
                ":  :--:  :  :\n" +
                "I  I  I  I  I \n" +
                ":--:--:  :--:\n";

        Amazing.random = new Random(100);
        Amazing.horizontal = 4;
        Amazing.vertical = 5;
        Amazing.isCellComplete = new boolean[Amazing.horizontal + 1][Amazing.vertical + 1];
        Amazing.doit();
        assertEquals("Should have the maze that was expected", expected, Amazing.result.toString());

    }
}

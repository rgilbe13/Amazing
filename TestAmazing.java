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
        Amazing.doit(15, 20);

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
        Amazing.doit(4, 5);
        assertEquals("Should have the maze that was expected", expected, Amazing.result.toString());

    }
}

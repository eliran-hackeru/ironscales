package com.ironscales.utility;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Removal
{
	//remove method as requested
    public static String remove(String string)
    {
        return string.trim();
    }
    
    //test remove with positive result
    public static void removalMethodPositive(String input, String expected)
    {
    	String actual = Removal.remove(input);
    	assertEquals(expected, actual);
    }
    
    //test remove with negative result
    public static void removalMethodNegative(String input, String expected)
    {
    	String actual = Removal.remove(input);
    	assertNotEquals(expected, actual);
    }
}


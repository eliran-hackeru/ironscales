package com.ironscales.testcases;

import org.testng.annotations.Test;

import com.ironscales.utility.Removal;

public class RemovalTest
{
    @Test(priority=0)
    public void testRemoveOnlyStart()
    {
    	Removal.removalMethodPositive(" Hello world!", "Hello world!");
    }

    @Test(priority=1)
    public void testRemoveOnlyEnd()
    {
    	Removal.removalMethodPositive("Hello world! ", "Hello world!");
    }
    
	@Test(priority=2)
    public void testRemoveBothSides()
	{
		Removal.removalMethodPositive(" Hello world! ", "Hello world!");
    }

    @Test(priority=3)
    public void testRemoveOnlyEndNegative()
    {
    	Removal.removalMethodNegative(" Hello world! ", " Hello world!");
    }

    @Test(priority=4)
    public void testRemoveEmptyString()
    {
    	Removal.removalMethodPositive("", "");
    }
    
    @Test(priority=5)
    public void testRemoveMultipleSpaces()
    {
    	Removal.removalMethodPositive("   Hello   world!   ", "Hello   world!");
    }
    
    @Test(priority=6)
    public void testRemoveMultipleSpacesNegative()
    {
    	Removal.removalMethodNegative("   Hello   world    !   ", "Hello   world!");
    }

    @Test(priority=7)
    public void testRemoveTabAndNewLine()
    {
    	Removal.removalMethodPositive("  \\t\\nHello\\tworld!\\n\\t     ", "\\t\\nHello\\tworld!\\n\\t");
    }

    @Test(priority=8)
    public void testRemoveSpecialCharacters()
    {
    	Removal.removalMethodPositive("  Hello!@# world!#$%   ", "Hello!@# world!#$%");
    }

    @Test(priority=9)
    public void testRemoveOnlySpaces()
    {
    	Removal.removalMethodPositive("     ", "");
    }
}

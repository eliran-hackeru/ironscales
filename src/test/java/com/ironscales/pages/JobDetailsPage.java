package com.ironscales.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class JobDetailsPage
{
	WebDriver driver;
	
	public JobDetailsPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy (xpath = "//li[contains(text(),'year of experience')]") WebElement experience;
	
	//Validate that years of experience is bigger than 1
	public void validateYears()
	{
		String experienceText = experience.getText();
		
		String number = experienceText.replaceAll("[^0-9]", "");
		
		int years = Integer.parseInt(number);
		
		Assert.assertTrue(years > 1);
		System.out.println("Years of experience validation passed");
	}
	
	//To assert the title
	public void assertTitle()
	{
		Assert.assertEquals(driver.getTitle(), "QA Automation Engineer | Career Opportunities");
		System.out.println("Assert title passed");
	}

}

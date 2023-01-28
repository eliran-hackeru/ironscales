package com.ironscales.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CareersPage
{
	WebDriver driver;
	
	public CareersPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy (partialLinkText = "Job Openings") WebElement jobsButton;
	
	@FindBy (partialLinkText = "QA Automation Engineer") WebElement jobTitle;
	
	//Click on Job Openings
	public void checkJobOpenings()
	{
		jobsButton.click();
	}
	
	//Click on QA Automation Position
	public void checkAutomationPosition()
	{
		jobTitle.click();
	}
	
	//To assert the title
	public void assertTitle()
	{
		Assert.assertEquals(driver.getTitle(), "Careers | IRONSCALES | A Self learning Email Security Platform");
		System.out.println("Assert title passed");
	}
}

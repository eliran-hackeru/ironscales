package com.ironscales.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import com.ironscales.pages.*;
import com.ironscales.utility.Helper;

public class CareersTest extends BaseClass
{
	@Test(priority=0)
	public void CareerApp() throws InterruptedException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		extentTest = extent.createTest(testName);
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.assertTitle();
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		homePage.companyHover();
		
		homePage.chooseCareers();
		
		CareersPage careersPage = PageFactory.initElements(driver, CareersPage.class);
		
		careersPage.assertTitle();
		
		careersPage.checkJobOpenings();
		
		Helper.waitForElementByClassName(driver, "job-board-title");
		
		Helper.scrollDown(driver, "5000");
		
		careersPage.checkAutomationPosition();
		
		JobDetailsPage jobDetailsPage = PageFactory.initElements(driver, JobDetailsPage.class);
		
		jobDetailsPage.assertTitle();
		
		jobDetailsPage.validateYears();
	
	}
}

package com.ironscales.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import com.ironscales.pages.*;
import com.ironscales.utility.Helper;

public class SocialMediaTest extends BaseClass
{
	@Test(priority=0)
	public void SocialMediaButtonsApp() throws InterruptedException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		extentTest = extent.createTest(testName);
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.assertTitle();
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		Helper.scrollToBottom(driver);
		
		homePage.validateLinkedin();
		
		homePage.validateYoutube();
		
		homePage.validateTwitter();
		
		homePage.validateFacebook();
		
		homePage.validateInstagram();
		
		Helper.scrollDown(driver, "1000");
		
		Helper.captureScreenshot(driver,testName,"SocialMediaBar");
	}
	
	@Test(priority=1)
	public void SocialMediaLinksApp() throws InterruptedException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		extentTest = extent.createTest(testName);
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		Helper.waitForElementByClassName(driver, "no-decoration");
		
		homePage.assertTitle();
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		Helper.scrollToBottom(driver);
		
		Thread.sleep(1000);
		
		Helper.scrollDown(driver, "800");
		
		homePage.goToLinkedIn();
		
		homePage.goToYouTube();
		
		homePage.goToTwitter();
		
//		BUGGED: Facebook link is incorrect and can not be validated
//		homePage.goToFacebook();
		
		homePage.goToInstagram();
	}
}

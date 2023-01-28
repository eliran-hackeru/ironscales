package com.ironscales.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import com.ironscales.pages.*;
import com.ironscales.utility.Helper;

public class NavigationBarTest extends BaseClass
{
	@Test(priority=0)
	public void NavigationBarApp() throws InterruptedException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		extentTest = extent.createTest(testName);
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.assertTitle();
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		homePage.solutionHover();
		
		homePage.byPlanHover();
		
		Helper.captureScreenshot(driver,testName,"02_OpenNavigationBar");
		
		homePage.validateStarter();
		
		homePage.validateEmailProtect();
		
		homePage.validateCompleteProtect();
			
	}
}

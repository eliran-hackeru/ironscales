package com.ironscales.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy (id = "chevron-down2_layer") WebElement solution;
	
	@FindBy (id = "chevron-right3_layer") WebElement byPlan;
	
	@FindBy (partialLinkText = "Starter") WebElement starter;
	
	@FindBy (partialLinkText = "Email Protect") WebElement emailProtect;
	
	@FindBy (partialLinkText = "Complete Protect") WebElement completeProtect;
	
	@FindBy (partialLinkText = "Company") WebElement company;
	
	@FindBy (partialLinkText = "Careers") WebElement careers;
	
	@FindBy (className = "no-decoration") List<WebElement> socialMedia;
	
	//Move mouse hover
	public void mouseoverLang(WebElement webElement)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).perform();
	}
	
	//Apply mouse hover to navigation bar elements
	public void solutionHover()
	{
		mouseoverLang(solution);
	}
	
	public void byPlanHover()
	{
		mouseoverLang(byPlan);
	}
	
	public void companyHover()
	{
		mouseoverLang(company);
	}
	
	//Click on "Careers" in navigation bar
	public void chooseCareers()
	{
		careers.click();
	}
	
	//Validate 3 options in navigation bar
	public void validateStarter()
	{
		validateOption(starter, "https://ironscales.com/plans/starter", "Starter");
	}
	
	public void validateEmailProtect()
	{
		validateOption(emailProtect, "https://ironscales.com/plans/email-protect", "Email Protect");
	}
	
	public void validateCompleteProtect()
	{
		validateOption(completeProtect, "https://ironscales.com/plans/complete-protect", "Complete Protect");
	}
	
	//Assertions based on the href and the inner text attributes
	public void validateOption(WebElement webElement, String url, String name)
	{
		String href = webElement.getAttribute("href");
		Assert.assertTrue(href.contains(url));
		String text = webElement.getText();
		Assert.assertTrue(text.contains(name));
		System.out.println(name + " validation passed");
	}
	
	//Extract the value of the id attribute and validate its correctness
	public void validateId(WebElement parentElement, String string)
	{
		WebElement styleElement = parentElement.findElement(By.xpath("*"));
		WebElement versionElement = styleElement.findElement(By.xpath("*"));
		WebElement idElement = versionElement.findElement(By.xpath("*"));
		Assert.assertTrue(idElement.getAttribute("id").contains(string));
		System.out.println(string + " validation passed");
	}
	
	public void validateLinkedin()
	{
		validateId(socialMedia.get(0), "LinkedIn");
	}
	
	public void validateYoutube()
	{
		validateId(socialMedia.get(1), "YouTube");
	}
	
	public void validateTwitter()
	{
		validateId(socialMedia.get(2), "Twitter");
	}
	
	public void validateFacebook()
	{
		validateId(socialMedia.get(3), "Facebook");
	}
	
	public void validateInstagram()
	{
		validateId(socialMedia.get(4), "Instagram");
	}
	
	//Opens a link to a social media in a new tab and validate its correctness
	public void goToSocialMedia(int i, String name)
	{
		clickSocialMedia(socialMedia.get(i));
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		Assert.assertTrue(driver.getCurrentUrl().contains(name + ".com"));
		System.out.println(name + " link validation passed");
		driver.close();
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
	}
	
	public void goToLinkedIn()
	{
		goToSocialMedia(0, "linkedin");
	}
	
	public void goToYouTube()
	{
		goToSocialMedia(1, "youtube");
	}
	
	public void goToTwitter()
	{
		goToSocialMedia(2, "twitter");
	}
	
	public void goToFacebook()
	{
		goToSocialMedia(3, "facebook");
	}
	
	public void goToInstagram()
	{
		goToSocialMedia(4, "instagram");
	}
	//Click on an element using the id attribute
	public void clickSocialMedia(WebElement parentElement)
	{
		WebElement styleElement = parentElement.findElement(By.xpath("*"));
		WebElement versionElement = styleElement.findElement(By.xpath("*"));
		versionElement.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	//To assert the title
	public void assertTitle()
	{
		Assert.assertEquals(driver.getTitle(), "Email Security Platform | IRONSCALES");
		System.out.println("Assert title passed");
	}
}

package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import Resources.Base;
import pageObjects.LandingPage;


public class ValidateHomePageTexts extends Base {
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		driver = initializeDriver();
		driver.get("https://www.airbnb.com/");
		
	}
	@Test
	public void textValidation() throws IOException, InterruptedException
	{	

		
		Thread.sleep(1000);
		LandingPage landingPage = new LandingPage(driver);

		Assert.assertTrue(landingPage.getGoNear().isDisplayed());

	
	}
	@AfterTest
	public void tearDown() throws IOException
	{
		driver.close();	
	}

}

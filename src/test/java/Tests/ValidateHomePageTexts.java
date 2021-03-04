package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		visit("https://www.airbnb.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void textValidation() throws IOException, InterruptedException
	{	
		LandingPage landingPage = new LandingPage(driver);
		
		Assert.assertTrue(landingPage.getGoNear().isDisplayed());

	
	}
	@AfterTest
	public void tearDown() throws IOException
	{
		driver.close();	
	}

}

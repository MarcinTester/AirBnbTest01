package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;

public class LoginTest extends Base{
	public WebDriver driver;
	@BeforeMethod
	public void setUp() throws IOException
	{
		driver = initializeDriver();
		driver.get("https://www.airbnb.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test	
	public void loginTest() throws InterruptedException
	{
		LandingPage landingPage = new LandingPage(driver);
		Thread.sleep(1000);
		String email = "marcintest19@gmail.com";
		String password = "thisismypassword!";
		
		landingPage.getHamburgerMenu().click();
		landingPage.getLogiMenuButton().click();
		Thread.sleep(1000);
		landingPage.getByEmailButton().click();
		landingPage.getEmailTextField().sendKeys(email);
		landingPage.getPasswordTextField().sendKeys(password);
		landingPage.getlogInButton().click();
		
		Thread.sleep(1000);
		landingPage.notificationExists();
		//System.out.println(landingPage.notificationExists());
	}
	@AfterTest
	public void TearDown() throws IOException
	{
		driver.close();	
	}
	
	
	
}

package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;

public class LoginTest extends Base{
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
		String Email = "marcin129129@interia.pl";
		String Password = "testtest191!";
		landingPage.login(Email, Password);
		Thread.sleep(5000);
		landingPage.notificationExists();
		System.out.println(landingPage.notificationExists());
	}
	@AfterTest
	public void TearDown() throws IOException
	{
		driver.close();	
	}
	
	
	
}

package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		visit("https://www.airbnb.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test	
	public void loginTest() throws InterruptedException
	{
		LandingPage landingPage = new LandingPage(driver);
		String email = "test@gmail.com";
		String password = "thisismypassword!";
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("field-guide-toggle")));
		
		landingPage.getHamburgerMenu().click();
		landingPage.getLoginMenuButton().click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-testid='social-auth-button-email']")));
		landingPage.getByEmailButton().click();
		landingPage.getEmailTextField().sendKeys(email);
		landingPage.getPasswordTextField().sendKeys(password);
		landingPage.getlogInButton().click();
		landingPage.getNotification().isDisplayed();

	}
	@AfterTest
	public void TearDown() throws IOException
	{
		driver.close();	
	}
}

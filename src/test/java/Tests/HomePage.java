package Tests;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Resources.Base;
import pageObjects.LandingPage;
import pageObjects.SearchPage;

public class HomePage extends Base {
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException
	{	
		driver = initializeDriver();
		visit("https://www.airbnb.com/");
		
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String location, 
								   String checkIndayNumber, 
								   String checkOutdayNumber,
								   int adultsNumber,
								   int kidsNumber,
								   int infantsNumber) throws IOException, InterruptedException
	{	
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver,5);
		LandingPage landingPage = new LandingPage(driver);
	
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("bigsearch-query-detached-query")));
		landingPage.getSetLocation().sendKeys(location);
		
		landingPage.getCalendar().isDisplayed();
		landingPage.getCalendar().click();
		landingPage.getNextMonth().click();
	
		w.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//td[@role='button']"), 0));
		Thread.sleep(500);
		landingPage.selectCheckInDay(checkIndayNumber);
		landingPage.selectCheckOutDay(checkOutdayNumber);
		
		Assert.assertTrue(landingPage.get1Day().isDisplayed());
		Assert.assertTrue(landingPage.get3Days().isDisplayed());
		Assert.assertTrue(landingPage.get7Days().isDisplayed());
		Assert.assertTrue(landingPage.get7Days().isDisplayed());
		//to do: is selected checks
		landingPage.get1Day().click();
		landingPage.get1Day().isSelected();
		landingPage.get3Days().click();
		landingPage.get3Days().isSelected();
		landingPage.get7Days().click();
		landingPage.get7Days().isSelected();
		landingPage.getExtendDates().click();
		
		landingPage.addGuests(adultsNumber, kidsNumber, infantsNumber);
		landingPage.clickSearch();

		SearchPage searchPage = new SearchPage(driver);
		String guestNumber = String.valueOf(adultsNumber + kidsNumber);
		
		searchPage.getGuestsNo().getText();
		System.out.println(searchPage.getGuestsNo().getText());
		
		Assert.assertEquals(searchPage.getGuestsNo().getText(), guestNumber + " guests");
		Assert.assertEquals(searchPage.checkStaysTest(location), "Stays in " + location);
		
		searchPage.getMap().isDisplayed();
		
	}
	@AfterTest
	public void tearDown() throws IOException
	{
		driver.close();
	}
	@DataProvider
		public Object[][] getData()
		{
		Object[][] data= new Object[2][6];
		data[0][0] = "Karpacz";
		data[0][1] = "5";
		data[0][2] = "26";
		data[0][3] = 1;
		data[0][4] = 2;
		data[0][5] = 2;
		
		data[1][0] = "Poznań";
		data[1][1] = "19";
		data[1][2] = "21";
		data[1][3] = 3;
		data[1][4] = 2;
		data[1][5] = 1;
		
		return data;
		}
}

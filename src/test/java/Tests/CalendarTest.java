package Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;


public class CalendarTest extends Base {

	@BeforeMethod
	public void setUp() throws IOException
	{
		
		driver = initializeDriver();
		visit("https://www.airbnb.com/");
		
	}
	@Test(dataProvider="getData")
	public void calendarTest(String location,
							String checkIndayNumber,
							String checkOutdayNumber) throws InterruptedException
	{	
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver,5);
		LandingPage landingPage = new LandingPage(driver);
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("bigsearch-query-detached-query")));
		landingPage.getSetLocation().sendKeys(location);
		landingPage.getCalendar().click();
		landingPage.getNextMonth().click();
		
		Thread.sleep(500);		
		landingPage.selectCheckInDay(checkIndayNumber);
		landingPage.selectCheckOutDay(checkOutdayNumber);

		
		
		Assert.assertTrue(landingPage.get1Day().isDisplayed());
		Assert.assertTrue(landingPage.get3Days().isDisplayed());
		Assert.assertTrue(landingPage.get7Days().isDisplayed());
		Assert.assertTrue(landingPage.get7Days().isDisplayed());

		landingPage.get1Day().click();
		landingPage.get1Day().isSelected();
		System.out.println(landingPage.get1Day().isSelected());
		landingPage.get3Days().click();
		landingPage.get3Days().isSelected();
		System.out.println(landingPage.get3Days().isSelected());
		landingPage.get7Days().click();
		landingPage.get7Days().isSelected();
		System.out.println(landingPage.get7Days().isSelected());
		landingPage.getExtendDates().click();
		landingPage.getExtendDates().isSelected();
		System.out.println(landingPage.getExtendDates().isSelected());
		

	}
	@AfterTest
	public void tearDown() throws IOException
	{
		driver.close();
	}
	@DataProvider
		public Object[][] getData()
		{
		Object[][] data= new Object[1][3];
		data[0][0] = "Karpacz";
		data[0][1] = "5";
		data[0][2] = "6";
		return data;
		}
}

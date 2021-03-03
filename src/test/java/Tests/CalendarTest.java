package Tests;

import java.io.IOException;

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
		driver.get("https://www.airbnb.com/");
		
	}
	@Test(dataProvider="getData")
	public void calendarTest(String location,
							String checkIndayNumber,
							String checkOutdayNumber) throws InterruptedException
	{	
		driver.manage().window().maximize();
		Thread.sleep(500);
		LandingPage landingPage = new LandingPage(driver);
		landingPage.setLocation(location);
		landingPage.getCalendar().click();
		landingPage.getNextMonth().click();
		
		Thread.sleep(1000);		
		landingPage.selectCheckInDay(checkIndayNumber);
		Thread.sleep(1000);
		landingPage.selectCheckOutDay(checkOutdayNumber);
		Thread.sleep(500);
		
		Assert.assertTrue(landingPage.get1Day().isDisplayed());
		Assert.assertTrue(landingPage.get3Days().isDisplayed());
		Assert.assertTrue(landingPage.get7Days().isDisplayed());
		Assert.assertTrue(landingPage.get7Days().isDisplayed());

		landingPage.get1Day().click();
	//	landingPage.get1Day().isSelected();
	//	System.out.println(landingPage.get1Day().isSelected());
		landingPage.get3Days().click();
	//	landingPage.get3Days().isSelected();
	//	System.out.println(landingPage.get3Days().isSelected());
		landingPage.get7Days().click();
	//	landingPage.get7Days().isSelected();
	//	System.out.println(landingPage.get7Days().isSelected());
		landingPage.getExtendDates().click();
	//	landingPage.getExtendDates().isSelected();
	//	System.out.println(landingPage.getExtendDates().isSelected());
		

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

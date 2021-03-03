package Tests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Resources.Base;
import pageObjects.SearchPage;

public class HomesTab extends Base {
	@BeforeMethod
	public void setUp() throws IOException
	{
		
		driver = initializeDriver();
		driver.get("https://www.airbnb.com/s/karpacz/homes?tab_id=home_tab&refinement_paths%5B%5D=%2Fhomes&flexible_trip_"
					+ "dates%5B%5D=april&flexible_trip_dates%5B%5D=march&flexible_trip_lengths%5B%5D=weekend_trip&date_picker_"
					+ "type=calendar&checkin=2021-03-03&checkout=2021-03-11&source=structured_search_input_header&search_type=filter_change");
		
	}
	@Test
	public void calendarTest() throws InterruptedException
	{	
		SearchPage searchPage = new SearchPage(driver);
		searchPage.getCancellationFlexibilityButton().click();
		searchPage.getCancellationFlexibilitySwitch().click();
		Assert.assertEquals("true", searchPage.getCancellationFlexibilitySwitch().getAttribute("aria-checked"));
	}
	@AfterTest
	public void tearDown() throws IOException
	{
		
	//	driver.close();
	}

}

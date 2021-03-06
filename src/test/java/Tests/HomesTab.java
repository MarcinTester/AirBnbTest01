package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Resources.Base;
import pageObjects.SearchPage;

public class HomesTab extends Base {
	@BeforeMethod
	public void setUp() throws IOException{
		driver = initializeDriver();
		visit("https://www.airbnb.com/s/karpacz/homes?tab_id=home_tab&refinement_paths%5B%5D=%2Fhomes&flexible_trip_"
					+ "dates%5B%5D=april&flexible_trip_dates%5B%5D=march&flexible_trip_lengths%5B%5D=weekend_trip&date_picker_"
					+ "type=calendar&checkin=2021-03-03&checkout=2021-03-11&source=structured_search_input_header&search_type=filter_change");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void buttonTest() throws InterruptedException{	
		WebDriverWait w = new WebDriverWait(driver,5);
		SearchPage searchPage = new SearchPage(driver);
		
		searchPage.getCancellationFlexibilityButton().click();
		searchPage.getCancellationFlexibilitySwitch().click();
		
		Assert.assertEquals("true", searchPage.getCancellationFlexibilitySwitch().getAttribute("aria-checked"));
		
		w.until(ExpectedConditions.elementToBeClickable(searchPage.getClearButton()));	
		
		searchPage.getClearButton().click();
		
		Assert.assertFalse(searchPage.getCancellationFlexibilitySwitch().isSelected());
		
		searchPage.getTypeOfPlaceButton().click();

		searchPage.getEntirePlaceCheckBox().click();
		searchPage.getPrivateRoomCheckBox().click();
		searchPage.getHotelRoomcheckBox().click();
		searchPage.getSharedRoomcheckBox().click();
		
		searchPage.checkIfSelected();
		
		searchPage.getClearButton().click();	
		searchPage.checkIfNotSelected();
		
		searchPage.getPriceButton().click();
		searchPage.getDatesButton().click();
		
		Thread.sleep(300);
		searchPage.selectCheckInDay("10");
		searchPage.selectCheckOutDay("25");
		
		Thread.sleep(1000);

	}
	@AfterTest
	public void tearDown() throws IOException	{
		driver.close();
	}

}

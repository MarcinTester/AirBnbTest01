package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	public WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public String checkStaysTest(String location)
	 {
		String staysText = driver.findElement(By.cssSelector("h1[class='_14i3z6h']")).getText();
		return staysText;
	 }
	
	By guestsNo = By.xpath("//div[@class = '_1g5ss3l' and contains(text(),'guests')]");
	public WebElement getGuestsNo()
	{
		return driver.findElement(guestsNo);
	}
	By map = By.cssSelector("aside[aria-label=\"Map with interactive pins related to your search\"]");
	public WebElement getMap()
	{
		return driver.findElement(map);
	}
	By cancellationFlexibilityButton = By.id("menuItemButton-flexible_cancellation");
	public WebElement getCancellationFlexibilityButton()
	{
		return driver.findElement(cancellationFlexibilityButton);
	}
	By cancellationFlexibilitySwitch = By.id("filterItem-flexible_cancellation-switch-flexible_cancellation-true");
	public WebElement getCancellationFlexibilitySwitch()
	{
		return driver.findElement(cancellationFlexibilitySwitch);
	}
	By typeOfPlaceButton = By.id("menuItemButton-room_type");
	public WebElement getTypeOfPlaceButton()
	{
		return driver.findElement(typeOfPlaceButton);
	}
	By entirePlaceCheckBox = By.id("filterItem-room_type-checkbox-room_types-Entire_home_apt");
	public WebElement getEntirePlaceCheckBox()
	{
		return driver.findElement(entirePlaceCheckBox);
	}
	By privateRoomCheckBox = By.id("filterItem-room_type-checkbox-room_types-Private_room");
	public WebElement getPrivateRoomCheckBox()
	{
		return driver.findElement(privateRoomCheckBox);
	}
	By hotelRoomcheckBox = By.id("filterItem-room_type-checkbox-room_types-Hotel_room");
	public WebElement getHotelRoomcheckBox()
	{
		return driver.findElement(hotelRoomcheckBox);
	}
	By sharedRoomcheckBox = By.id("filterItem-room_type-checkbox-room_types-Shared_room");
	public WebElement getSharedRoomcheckBox()
	{
		return driver.findElement(sharedRoomcheckBox);
	}
	By clearButton = By.cssSelector("[data-testid=\"filter-panel-clear-button\"]");
	public WebElement getClearButton()
	{
		return driver.findElement(clearButton);
	}
	
}
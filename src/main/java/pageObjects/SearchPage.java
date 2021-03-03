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
}
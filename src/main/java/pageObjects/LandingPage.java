package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By search = By.xpath("//button[@data-testid='structured-search-input-search-button']");
	 
	 public LandingPage(WebDriver driver) {
		 this.driver = driver;
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	 By destination = By.id("bigsearch-query-detached-query");
	public WebElement getSetLocation()
	 {
		return driver.findElement(destination);
	 }
	public void clickSearch()
	{
		driver.findElement(search).click();
	}
	By nextButton = By.xpath("//button[@aria-label = \"Next\"]");
	By calendar = By.cssSelector("div[data-testid='structured-search-input-field-split-dates-0']");
	public WebElement getCalendar()
	{	
		return driver.findElement(calendar);
	}
	public WebElement getNextMonth()
	{
		return driver.findElement(nextButton);
	}
	public void selectCheckInDay(String checkIndayNumber)
	{	
		List<WebElement> tdButton = driver.findElements(By.xpath("//td[@role='button']"));
		for(WebElement cell:tdButton)
		  {
			if (cell.getText().equals(checkIndayNumber))
			{
				cell.click();
				break;
			}
		  }
	}
	public void selectCheckOutDay(String checkOutdayNumber)
	{	
		List<WebElement> tdButton = driver.findElements(By.xpath("//td[@role='button']"));
		for(WebElement cell:tdButton)
		  {
			if (cell.getText().equals(checkOutdayNumber))
			{
				cell.click();
				break;
			}
		  }
	}

	By hamburgerMenu = By.id("field-guide-toggle");
	public WebElement getHamburgerMenu()
	{
		return driver.findElement(hamburgerMenu);
	}
	
	By loginMenuButton = By.cssSelector("a[data-testid='cypress-headernav-login']");
	public WebElement getLoginMenuButton()
	{
		return driver.findElement(loginMenuButton);
	}
	By byEmailButton = By.cssSelector("button[data-testid='social-auth-button-email']");
	public WebElement getByEmailButton()
	{
		return driver.findElement(byEmailButton);
	}
	By emailTextField = By.id("email");
	public WebElement getEmailTextField()
	{
		return driver.findElement(emailTextField);
	}
	By emailPasswordField = By.id("password");
	public WebElement getPasswordTextField()
	{
		return driver.findElement(emailPasswordField);
	}
	By logInButton = By.cssSelector("button[data-testid='signup-login-submit-btn']");
	public WebElement getlogInButton()
	{
		return driver.findElement(logInButton);
	}

	By notification = By.cssSelector("div[aria-label='1 notification']");	
	public WebElement getNotification()
	{
		return driver.findElement(notification);
	}
	
	By guests = By.xpath("//div[contains(text(),'Guests')]");
	By addAdults = By.xpath("//button[@data-testid=\"stepper-adults-increase-button\"]");   
    By addKids = By.xpath("//button[@data-testid=\"stepper-children-increase-button\"]");
    By addInfants = By.xpath("//button[@data-testid=\"stepper-infants-increase-button\"]");
	public void addGuests(int adultsNumber, int kidsNumber, int infantsNumber )
	{
		driver.findElement(guests).click();
	    for (int i=1; i<=adultsNumber; i++)
	    {
	    	  driver.findElement(addAdults).click();
	    }
	    for (int i=1; i<=kidsNumber; i++)
	    {
	    	 driver.findElement(addKids).click();
	    }
	    for (int i=1; i<=infantsNumber; i++)
	    {
	    	driver.findElement(addInfants).click();
	    }
	}
	By extendDates = By.cssSelector("label[for=\"flexible-dates-flexible_date_search_filter_type-0\"]");
	public WebElement getExtendDates()
	{
		return driver.findElement(extendDates);
	}
	By oneDay = By.cssSelector("label[for=\"flexible-dates-flexible_date_search_filter_type-1\"]");
	public WebElement get1Day()
	{
		return driver.findElement(oneDay);
	}
	By threeDays = By.cssSelector("label[for=\'flexible-dates-flexible_date_search_filter_type-2']");
	public WebElement get3Days()
	{
		return driver.findElement(threeDays);
	}
	By sevenDays = By.cssSelector("label[for=\"flexible-dates-flexible_date_search_filter_type-3\"]");
	public WebElement get7Days()
	{
		return driver.findElement(sevenDays);
	}
	By goNear = By.cssSelector("div[role='heading']");
	public WebElement getGoNear()
	{
		return driver.findElement(goNear);
	}
}

package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	By destination = By.id("bigsearch-query-detached-query");
	By search = By.xpath("//button[@data-testid='structured-search-input-search-button']");
	 
	 public LandingPage(WebDriver driver) {
		 this.driver = driver;
		`
	}

	public void setLocation(String location)
	 {
		driver.findElement(destination).sendKeys(location);
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
	public void selectCheckInDay(String CheckIndayNumber)
	{	
		List<WebElement> datesList = driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/header"
																	+ "[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/"
																	+ "div[3]/div[4]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div"
																	+ "[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr"));
		  for(WebElement row:datesList)
		  {
			  if (row.getText().contains(CheckIndayNumber))
			  {
				  List<WebElement> rowList =  row.findElements(By.tagName("td"));
				  for(WebElement cell:rowList)
				  {
					  if (cell.getText().equals(CheckIndayNumber))
					  { 
						  cell.click();
						  break;
					  }
				  }
			  }
		
		  }
	}
	
	public void selectCheckOutDay(String CheckOutdayNumber)
	{	
		List<WebElement> datesList = driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/header"
																	+ "[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/"
																	+ "div[3]/div[4]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div"
																	+ "[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr"));
		
		for(WebElement row:datesList)
		{
			if (row.getText().contains(CheckOutdayNumber))
			{
				List<WebElement> rowList =  row.findElements(By.tagName("td"));
				for(WebElement cell:rowList)
				{
					if (cell.getText().equals(CheckOutdayNumber))
					{
						cell.click();
						break;
					}
				}
			}
			
		}
	}
	
	public void login(String Email, String Password) throws InterruptedException
	{
		driver.findElement(By.id("field-guide-toggle")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[data-testid='cypress-headernav-login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[data-testid='social-auth-button-email']")).click();
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.cssSelector("button[data-testid='signup-login-submit-btn']")).click();

	}
	By notification = By.cssSelector("div[aria-label='1 notification']")
;	public boolean notificationExists()
	{
		return driver.findElement(notification).isDisplayed();
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

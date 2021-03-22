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

public class HomePage2 extends Base {
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{	
		driver = initializeDriver();
		visit("https://www.airbnb.com/");
		Thread.sleep(1000);
		
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String location, 
								   String checkIndayNumber, 
								   String checkOutdayNumber,
								   int adultsNumber,
								   int kidsNumber,
								   int infantsNumber) throws IOException, InterruptedException
	{	
	
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

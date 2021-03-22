package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		visit("https://www.wsb.pl/wroclaw/kontakt");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void calendarTest() throws InterruptedException
	{	
		Thread.sleep(2000);
//		String text1 = driver.findElement(By.xpath("//a[@href='tel=//71376290']")).getText();
		String test1 = driver.findElement(By.cssSelector("a[href='tel=//71376290']")).getText();
	//	String text1 = driver.findElement(By.xpath("//body/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[11]/div[1]/div[1]/p[1]/a[1]")).getText();
	//	String text2 = driver.findElement(By.xpath("//a[@href='mailto:kancelaria2@wsb.wroclaw.pl']")).getText();
		String text2 = driver.findElement(By.xpath("//a[contains(text(),'kancelaria2@wsb.wroclaw.pl')]")).getText();
		
//		System.out.println(text1);
		System.out.println(text2);
//		Assert.assertEquals(text1, text2);
		
		driver.close();
	}
	@AfterTest
	public void tearDown() throws IOException
	{
		driver.close();
	}

}

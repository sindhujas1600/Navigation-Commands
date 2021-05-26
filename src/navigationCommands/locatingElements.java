package navigationCommands;

//import the required libraries

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class locatingElements {
	private WebDriver driver;
	
	@BeforeSuite
	public void getDriver() throws Exception
	{
		//setting excel file
		excel.setExcelFile();
				
		//getting input browser from excel
		String browser = excel.getCellData(1, 1);
		
		if(browser.equalsIgnoreCase("chrome"))
		{ 
			System.setProperty("webdriver.chrome.driver",excel.getCellData(3, 1)); 
			driver=new ChromeDriver(); 
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",excel.getCellData(4, 1)); 
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		else
		{
			System.out.println(excel.getCellData(5, 1));
			System.exit(0);
		}
		//getting url and opening browser
		String url = excel.getCellData(2, 1);
		driver.manage().window().maximize();
		driver.get(url);
		
		excel.setExcelFile();
		String keyword = excel.getCellData(0, 1);
		driver.findElement(By.name(excel.getCellData(6, 1))).sendKeys(keyword);;
		driver.findElement(By.name(excel.getCellData(6, 1))).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test
	public void navigateBack()        //method to naviagte back
	{
		driver.navigate().back();
	}
	
	@Test
	public void navigateForward()        //method to navigate forward
	{
		driver.navigate().forward();
	}
	
	@Test
	public void navigateRefresh()        //method to refresh the page
	{
		driver.navigate().refresh();
		//throw new SkipException("This method is skipped deliberately");
	}
	
	@AfterSuite
	public void closeBrowser()          //method to close the browser
	{
		driver.close();
	}	
}


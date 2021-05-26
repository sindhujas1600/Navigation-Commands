

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class sampleHackath {
	static String baseUrl = "https://coursera.org";
	static WebDriver driver;
	static WebElement element,language;
	
	@BeforeTest
	public void setDriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sindhuja\\workspace\\JavaExample\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=1)
	public void getUrl()
	{
		driver.get(baseUrl);
	}
	
	
	@Test(priority=2)
	public void selectCourse()
	{
		driver.findElement(By.className("react-autosuggest__input")).sendKeys("Web Development");
		driver.findElement(By.className("react-autosuggest__input")).sendKeys(Keys.ENTER);
		try
		{
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=3)
	public void preCondition()
	{
		driver.findElement(By.xpath("//div[@id='react-select-2--value']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id = 'react-select-2--option-0' ]")).click();
		
		try
		{
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@id = 'react-select-3--value']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id = 'react-select-3--option-0']")).click();
		try
		{
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=4)
	public void displayDetails()
	{
		System.out.println("Details of Course 1:-");
		//String coursedetailOne = driver.findElement(By.xpath("//ul[@class = 'ais-InfiniteHits-list']/li[1]")).getText();
		//System.out.println(coursedetailOne);
		String coursenameOne = driver.findElement(By.xpath("//ul[@class = 'ais-InfiniteHits-list']/li[1]//h2")).getText();
		System.out.println("Name of the course: "+coursenameOne);
		String courserateOne = driver.findElement(By.xpath("//ul[@class = 'ais-InfiniteHits-list']/li[1]//div[@class='screenreader-only']")).getText();
		System.out.println("Rating provided: "+courserateOne);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Details of Course 2:-");
		//String coursedetailTwo = driver.findElement(By.xpath("//ul[@class = 'ais-InfiniteHits-list']/li[2]")).getText();
		//System.out.println(coursedetailTwo);
		String coursenameTwo = driver.findElement(By.xpath("//ul[@class = 'ais-InfiniteHits-list']/li[2]//h2")).getText();
		System.out.println("Name of the course: "+coursenameTwo);
		String courserateTwo = driver.findElement(By.xpath("//ul[@class = 'ais-InfiniteHits-list']/li[2]//div[@class='screenreader-only']")).getText();
		System.out.println("Rating provided: "+courserateTwo);
	}
	
	/*
	@Test(priority=5)
	public void displayDuration()
	{
		driver.findElement(By.xpath("//ul[@class = 'ais-InfiniteHits-list']/li[1]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String courseDurationOne = driver.findElement(By.xpath("//div[@id='rendered-content']//span[@xpath = '1']")).getText();
		System.out.println("Course Duration: "+courseDurationOne);

	}
	*/
	@Test(priority=5)
	public void languageLearning()
	{
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.findElement(By.className("react-autosuggest__input")).sendKeys("Language Learning");
		driver.findElement(By.className("react-autosuggest__input")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String count = driver.findElement(By.xpath("//div[@class = 'filter-menu-and-number-of-results']")).getText();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(" ");
		System.out.println(count);
	}
	
	@Test(priority=6)
	public void getForm()
	{
		driver.navigate().back();
		driver.findElement(By.id("enterprise-link")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.linkText("For Campus")).click();
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		driver.findElement(By.linkText("Get Started")).click();
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	/*
	@Test(priority=7)
	public void fillForm()
	{
		
	}
	*/
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	public static void main(String[] args)
	{
		sampleHackath object = new sampleHackath();
		object.setDriver();
		object.getUrl();
		object.selectCourse();
		object.preCondition();
		object.displayDetails();
		//object.displayDuration();
		object.languageLearning();
		object.getForm();
		object.closeBrowser();
	}
}

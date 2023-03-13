package Testngpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testngcross {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String b)
	{
		if(b.equalsIgnoreCase("chrome"))
				{
			driver=new ChromeDriver();
				}
		else if(b.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
	}
	
	@Test
	public void test1()
	{
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("apple", Keys.ENTER);
	}


}

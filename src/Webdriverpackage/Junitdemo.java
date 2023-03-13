package Webdriverpackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Junitdemo {
	ChromeDriver driver;
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	
	@Test
	public void test1()
	{
		String exp="facebook";
		String title=driver.getTitle();
		System.out.println(title);
		if(exp.equalsIgnoreCase(title))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		driver.findElement(By.name("email")).sendKeys("riswana@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("riswana");
		driver.findElement(By.name("login")).click();
	}
	
	@After
	public void close()
	{
		driver.quit();
	}

}

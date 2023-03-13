package Testngpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testngcode {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	
	@BeforeMethod
	public void urlload()
	{
		driver.get("https://www.facebook.com");
		
	}
	
	@Test(priority=1, groups= {"regression"})
	public void test1()
	{
		String exp="facebook - log in or sign up";
		String title=driver.getTitle();
		if(exp.equals(title))
		{
			System.out.println("title pass");
		}
		else
		{
			System.out.println("fail"+" title= "+title);
		}
	}
	
	@Test(priority=3, groups= {"sanity"})
	public void test2()
	{
		driver.findElement(By.name("email")).sendKeys("riswana@gmail.com");
	}
	
	@Test(priority=2, invocationCount=2, groups= {"smoke"})
	public void test3()
	{
		driver.findElement(By.id("pass")).sendKeys("riswana");
	}
	
	@Test(priority=4, enabled=false, groups= {"sanity"})
	public void test4()
	{
		driver.findElement(By.name("login")).click();
	}
	
//	@AfterMethod()
//	public void aftermthd()
//	{
//		System.out.println("closing");
//	}
	
	@AfterTest
	public void close()
	{
		driver.quit();
	}

}

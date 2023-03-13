package Webdriverpackage;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tagnamecode {
	ChromeDriver driver;
	
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com");	
		
	}
	
	@Test
	public void test1()
	{
		List <WebElement> li=driver.findElements(By.tagName("a"));
		System.out.println("total number of list = "+li.size());
		for(WebElement element:li)
		{
			String link=element.getAttribute("href");
			String text=element.getText();
			System.out.println(link+"----"+text);
		}
	}
	
	@After
	public void close()
	{
		driver.quit();
	}

}

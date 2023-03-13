package Webdriverpackage;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	ChromeDriver driver;
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
	}
	
	@Test
	public void test1()
	{
		String s;
		s=driver.getTitle();
		System.out.println("title= "+s);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("mobiles",Keys.ENTER);
	driver.findElement(By.xpath("//*[@id='nav-xshop']/a[5]")).click();
	driver.findElement(By.xpath("//*[@id='nav-cart-count-container']")).click();
	driver.findElement(By.xpath("//*[@class='nav-line-1-container']/span[1]")).click();
	driver.findElement(By.name("email")).sendKeys("abc@gmailo.com",Keys.ENTER);
	driver.navigate().back();
	driver.navigate().back();
	driver.findElement(By.xpath("//*[@id='nav-hamburger-menu']/i[1]")).click();
	}
	
	@After
	public void close()
	{
		driver.quit();
	}

}

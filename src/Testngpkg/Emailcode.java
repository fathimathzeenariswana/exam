package Testngpkg;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Emailcode {
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/popup.php");
	}
	
	@Test
	public void test1()
	{
		String parent=driver.getWindowHandle();
		String parenttitle=driver.getTitle();
		System.out.println("parent= "+parenttitle);
		driver.findElement(By.xpath("/html/body/p/a")).click();
		Set<String> s=driver.getWindowHandles();
		for(String handle:s)
		{
			if(!handle.equalsIgnoreCase(parent))
			{
				
				//System.out.println(handle);
				driver.switchTo().window(handle);
				driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("abc2gmail.com");
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input")).click();
				driver.close();
				driver.switchTo().window(parent);
			}
		}
	}

}

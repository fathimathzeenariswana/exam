package Webdriverpackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rediffcode {
	ChromeDriver driver;
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		
	}
	
	@Test
	public void test1()
	{
		WebElement radio = driver.findElement(By.xpath("//*[@value='m']"));
		boolean state=radio.isSelected();
		if(state==true)
		{
			System.out.println("m radio button selected");
		}
		else if(state==false)
		{
			System.out.println("m radio button not selected");
		}
		
		WebElement radio2 = driver.findElement(By.xpath("//*[@value='f']"));
		boolean state2=radio2.isSelected();
		if(state2==true)
		{
			System.out.println("f radio button selected");
		}
		else if(state2==false)
		{
			System.out.println("f radio button not selected");
		}
	}
	
	@After
	public void close()
	{
		driver.quit();
	}

}

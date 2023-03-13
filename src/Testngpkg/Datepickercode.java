package Testngpkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Datepickercode {
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://www.expedia.com");
		driver.manage().window().maximize();
		}
	
	@Test
	public void test1()
	{
		driver.findElement(By.xpath("//*[@id=\"wizardMainRegionV2\"]/div/div/div/div/ul/li[2]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"d1-btn\"]")).click();
		
		while(true)
		{
				WebElement month=driver.findElement(By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/h2"));
				
				String month1=month.getText();
				if(month1.equalsIgnoreCase("march 2023"))
				{
					System.out.println(month1);
					break;
				}
				else
				{
					driver.findElement(By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/button[2]")).click();
				}
		
		}
		
		List <WebElement> li=driver.findElements(By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr/td/button"));
		for(WebElement date:li)
		{
			String date1=date.getAttribute("data-day");
			//System.out.println(date1);
			if(date1.equals("16"))
			{
				date.click();
				System.out.println(date1);
				System.out.println("date selected");
			}
		}
	}

}

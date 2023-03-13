package Webdriverpackage;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Alertcode {
ChromeDriver driver;

@Before
public void setup()
{
	driver=new ChromeDriver();
	driver.get("file:///C:/Users/sumoo/Desktop/code.html");
}

@Test
public void test1()
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileHandler.copy(src, new File("E://error.png"));
	} 
	catch (IOException e) {
		e.printStackTrace();
	}
	
	WebElement button=driver.findElement(By.xpath("//input[@value='Submit']"));
	File sr=button.getScreenshotAs(OutputType.FILE);
	try {
		FileHandler.copy(sr, new File("./screenshot/error.png"));
	} 
	catch (IOException e) {
		e.printStackTrace();
	}
	
	
	driver.findElement(By.xpath("//input[@type='button']")).click();
	Alert a=driver.switchTo().alert();
	String text=a.getText();
	
	if (text.equalsIgnoreCase("hello! i am an alert box"))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
	a.accept();
	//a.dismiss();
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("riswana");
	driver.findElement(By.xpath("//input[@name='secondname']")).sendKeys("seena");
	driver.findElement(By.xpath("//input[@value='Submit']")).click();
	
}
//@After
//public void close()
//{
//	driver.quit();
//}
}

package TestPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PagePOM.ForgtPaswdPage;

public class ForgtPswdTest {
	
	WebDriver driver;
	String baseurl="https://www.facebook.com";
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	
	@BeforeMethod
	public void url()
	{
		driver.get(baseurl);
	}
	
	@Test
	public void run()
	{
		ForgtPaswdPage ob=new ForgtPaswdPage(driver);
		ob.frgtpswd();
		ob.mob("ashna@gmail.com");
	}

}

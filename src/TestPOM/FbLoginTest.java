package TestPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PagePOM.FbLoginPage;

public class FbLoginTest {
	
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
FbLoginPage ob=new FbLoginPage(driver);
ob.values("abc@gmail.com", "Abc1#");
ob.login();

}
}

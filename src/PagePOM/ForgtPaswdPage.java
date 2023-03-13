package PagePOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgtPaswdPage {
	
	WebDriver driver;
	
	By pswd=By.xpath("//*[contains(text(),'Forgotten password')]");
	By mobile=By.xpath("//*[@id=\"identify_email\"]");
	
	public ForgtPaswdPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void frgtpswd()
	{
		driver.findElement(pswd).click();
	}
	
	public void mob(String mob)
	{
		driver.findElement(mobile).sendKeys(mob);
	}

}

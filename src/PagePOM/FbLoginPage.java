package PagePOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FbLoginPage {
	
	WebDriver driver;
	
	By login=By.id("email");
	By pass=By.id("pass");
	By button=By.name("login");
	
	public FbLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void values(String email, String password)
	{
		driver.findElement(login).sendKeys(email);
		driver.findElement(pass).sendKeys(password);
	}
	
	public void login()
	{
		driver.findElement(button).click();
	}

}

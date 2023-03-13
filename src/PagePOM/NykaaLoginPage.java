package PagePOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NykaaLoginPage {
	
WebDriver driver;
	
	By logo=By.xpath("//a[@title='logo']");
	By login=By.xpath("//*[@id=\"header_id\"]/div[2]/div/div[2]/div[1]/div/button");
	By mob=By.xpath("//*[@id=\"header_id\"]/div[2]/div/div[2]/div[1]/div[2]/div[3]/button[1]");
	By proceed=By.xpath("//*[@id=\"submitVerification\"]");
	By num=By.xpath("//input[@name='emailMobile']");
	
	public NykaaLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void values(String mobile)
	{
		driver.findElement(logo).click();
		driver.findElement(login).click();
		driver.findElement(mob).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(num).sendKeys(mobile);
		driver.findElement(proceed).click();
	}

}

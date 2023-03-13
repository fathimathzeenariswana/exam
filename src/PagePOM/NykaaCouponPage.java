package PagePOM;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NykaaCouponPage {
	
	WebDriver driver;
	
	By bag=By.xpath("//button[@type='button']");
	By arrow=By.xpath("//*[contains(text(),'Login / Register')]");
	By field=By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/form/div/div[1]/div/input");
	By apply=By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/form/div/div[1]/div/a");
	By search=By.xpath("//*[@id=\"headerMenu\"]/div[2]/div[1]/div/form/input");
	By items=By.xpath("//*[@id=\"product-list-wrap\"]/div[1]/div/div[1]");
	By add=By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div/div[1]/div[5]/div[1]/div/button/span");
	
	public NykaaCouponPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void adding(String item)
	{
		driver.findElement(search).sendKeys(item, Keys.ENTER);
		
		String parent=driver.getWindowHandle();
		String parenttitle=driver.getTitle();
		System.out.println("parent= "+parenttitle);
		driver.findElement(items).click();
		Set<String> s=driver.getWindowHandles();
		for(String handle:s)
		{
			if(!handle.equalsIgnoreCase(parent))
			{
				
				driver.switchTo().window(handle);
				driver.findElement(add).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
				System.out.println("item added to cart");
				//driver.close();
				//driver.switchTo().window(parent);
			}
		}
	
	}

	
	public void values(String code)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(bag).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.findElement(arrow).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(field).sendKeys(code);
		driver.findElement(apply).click();
		System.out.println("coupon applied");
	}

}

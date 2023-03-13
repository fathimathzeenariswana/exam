package PagePOM;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NykaaSearchPage {
	
	WebDriver driver;
	
	By search=By.xpath("//*[@id=\"headerMenu\"]/div[2]/div[1]/div/form/input");
	By items=By.xpath("//*[@id=\"product-list-wrap\"]/div[1]/div/div[1]");
	By add=By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div/div[1]/div[5]/div[1]/div/button/span");
	
	public NykaaSearchPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void values(String item)
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
				System.out.println("item added to bag");
			}
		}
	
	}

}

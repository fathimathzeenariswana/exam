package PagePOM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NykaaPinPage {
	
	WebDriver driver;
	
	By point=By.xpath("//div[@id='my-menu']/ul/li[2]/a");
	By click=By.xpath("//*[@id=\"my-menu\"]/ul/li[2]/ul/li/div/div[1]/div/ul[2]/li[1]/a");
	By p=By.xpath("//*[@id=\"product-list-wrap\"]/div[1]/div");
	By field=By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div/div[1]/div[6]/div[2]/div/div[2]/span/input");
	By c=By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div/div[1]/div[6]/div[2]/div/div[2]/button");
	
	public NykaaPinPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void checkpin() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement hover=driver.findElement(point);
		Actions act=new Actions(driver);
		act.moveToElement(hover);
		act.perform();
		
		String parent=driver.getWindowHandle();
		String parenttitle=driver.getTitle();
		System.out.println("parent= "+parenttitle);
		driver.findElement(click).click();
		Set<String> s=driver.getWindowHandles();
		for(String handle:s)
		{
			if(!handle.equalsIgnoreCase(parent))
			{
				
				driver.switchTo().window(handle);
				driver.findElement(p).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				//driver.close();
				//driver.switchTo().window(parent);
			}
		
		}
		
		String parent2=driver.getWindowHandle();
		String parenttitle2=driver.getTitle();
		System.out.println("parent2= "+parenttitle2);
		Set<String> s2=driver.getWindowHandles();
		for(String handler:s2)
		{
			if(!handler.equalsIgnoreCase(parent2)&&!handler.equalsIgnoreCase(parent))
			{
				
				driver.switchTo().window(handler);
				System.out.println("switched");
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			}
		}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				FileInputStream f=new FileInputStream("C:\\Users\\sumoo\\Documents\\nyka.xlsx");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				XSSFWorkbook wb=new XSSFWorkbook(f);
				XSSFSheet sh=wb.getSheet("Sheet1");
				int rowcount=sh.getLastRowNum();
				for(int i=1;i<=rowcount;i++)
				{
double pin = sh.getRow(i).getCell(0).getNumericCellValue();
					System.out.println("pincode= "+pin);
					//String.valueOf(pin);
					driver.findElement(field).sendKeys(String.valueOf(pin));
					driver.findElement(c).click();
				}
			}
	
}

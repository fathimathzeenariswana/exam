package Testngpkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Redifftestng {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	
	@BeforeMethod
	public void url()
	{
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");	
		
	}
	
	@Test
	public void test1()
	{
		WebElement i = driver.findElement(By.xpath("//*[@title='Rediff.com']"));
	    Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);
		if (p) {
			    System.out.println("Logo present");
			    System.out.println();
			   } 
		else {
			    System.out.println("Logo not present");
			    System.out.println();
			 }
		
		WebElement e=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[1]/td"));
		String text=e.getText();
		if(text.equalsIgnoreCase("create a rediffmail account"))
		{
			System.out.println("create account text is present");
			System.out.println("text= "+ text);
			System.out.println();
		}
		else
		{
			System.out.println("create account text is not present");
			System.out.println("text= "+text);
			System.out.println();
		}
		
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")).sendKeys("fathimath zeena riswana");
		
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys("riswana1234");
		
		
		String exp="check available";
		String t=driver.findElement(By.xpath("//div[@id='wrapper']/table[2]/tbody/tr[7]/td[3]/input[2]")).getAttribute("value");
		if(t.equalsIgnoreCase(exp))
		{
			System.out.println("text correct");
			System.out.println();
		}
		else
		{
			System.out.println("text incorrect   " +"text= "+t);
			System.out.println();
		}
		
		driver.findElement(By.id("newpasswd")).sendKeys("Riswana1#");
		
		driver.findElement(By.id("newpasswd1")).sendKeys("Riswana1#");
		
		driver.findElement(By.xpath("//*[@id=\"div_altemail\"]/table/tbody/tr[1]/td[3]/input")).sendKeys("riswanaseena@gmail.com");
		
		WebElement c=driver.findElement(By.xpath("//*[@type='checkbox']"));
		Boolean b=c.isSelected();
		if (b)
		{
			System.out.println("checkbox is selected");
			System.out.println();
		}
		else
		{
			System.out.println("checkbox is not selected");
			System.out.println();
		}
		
		driver.findElement(By.id("mobno")).sendKeys("3547689890");

			WebElement d = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]"));
			Select s = new Select(d);
			s.selectByValue("11");
			
			WebElement d1 = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]"));
			Select s1 = new Select(d1);
			s1.selectByValue("06");
			
			WebElement d2 = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]"));
			Select s2 = new Select(d2);
			s2.selectByValue("1998");

			WebElement radio=driver.findElement(By.xpath("//input[@value='f']"));
			radio.click();
			
			WebElement country = driver.findElement(By.id("country"));
			Select sc = new Select(country);
			sc.selectByValue("99");
			
			WebElement city = driver.findElement(By.xpath("//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select"));
			Select scity = new Select(city);
			scity.selectByValue("Goa");
			
			WebElement drop=driver.findElement(By.id("country"));
			Select droplist=new Select(drop);
			List <WebElement> options=droplist.getOptions();
			int num=options.size();
			if(num==50)
			{
				System.out.println("count of country dropdown is 50");
				System.out.println();
			}
			else
			{
				System.out.println("count of country dropdown is not 50");
				System.out.println("count of country= "+num);
				System.out.println();
			}
			
			WebElement create=driver.findElement(By.id("Register"));
			Boolean bc=create.isDisplayed();
			if (bc)
			{
				System.out.println("Create account button is displayed");
				System.out.println();
			}
			else
			{
				System.out.println("Create account button is not displayed");
				System.out.println();
			}
	}
			
	@AfterTest
	public void close()
	{
		driver.quit();
	}
		}

	

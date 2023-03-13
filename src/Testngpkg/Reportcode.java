package Testngpkg;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reportcode {
	WebDriver driver;
	String baseurl="https://www.facebook.com";
	ExtentHtmlReporter reporter;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	public void setup()
	{
		reporter=new ExtentHtmlReporter("./Report/MyReport1.html");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Functional Test");
		reporter.config().setTheme(Theme.STANDARD);
		report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Host Name", "Local Host");
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Tester Name", "Riswana");
		report.setSystemInfo("Browser Name", "Chrome");
		driver=new ChromeDriver();
	}
	
	@BeforeMethod
	public void url()
	{
		driver.get(baseurl);
	}
	
	@Test
	public void FBTitleVerify()
	{
		test=report.createTest("FB Title Verify");
		String exp="Facebook – log in or sign up";
		String title=driver.getTitle();
		Assert.assertEquals(exp, title);
		
	}
	
	@Test
	public void FBLoginButton()
	{
		test=report.createTest("FB Login Button");
		String button=driver.findElement(By.xpath("//*[@name='login']")).getText();
		Assert.assertEquals(button, "sign in");
	}
	
	@AfterMethod
	public void close(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
		    test.log(Status.FAIL, "Test case failed is "+result.getName());
		    test.log(Status.FAIL, "Test case failed due to "+result.getThrowable());
		    String screenshotpath=Reportcode.screenshotMethod(driver,result.getName());
		    test.addScreenCaptureFromPath(screenshotpath);
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test case skipped is "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test case passed is "+result.getName());
		}
	}
	
	@AfterTest
	public void teardown()
	{
		report.flush();
	}
	
	public static String screenshotMethod(WebDriver driver,String screenshotname) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination="./screenshot/"+screenshotname+".png";
		FileHandler.copy(src, new File(destination));
		return destination;
	}

}


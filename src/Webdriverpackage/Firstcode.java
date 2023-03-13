package Webdriverpackage;

import org.openqa.selenium.chrome.ChromeDriver;

public class Firstcode {

	public static void main(String[] args) {
	ChromeDriver ob=new ChromeDriver();	
	ob.get("https://www.google.com");
	String title=ob.getTitle();
	String exp="google";
	if(title.equalsIgnoreCase(exp))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");	

	}
	String s=ob.getPageSource();
	if(s.contains("I'm Feeling Lucky"))
	{
		System.out.println("text present");
	}
	else
	{
		System.out.println("Text not present");
	}
	

}
}
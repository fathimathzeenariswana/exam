package TestPOM;

import org.testng.annotations.Test;

import PagePOM.NykaaSearchPage;

public class NykaaSearchTest extends NykaaTest{

	@Test
	public void test1()
	{
		NykaaSearchPage ob=new NykaaSearchPage(driver);
		ob.values("sanitizer");
	}
	
}

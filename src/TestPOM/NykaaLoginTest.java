package TestPOM;

import org.testng.annotations.Test;

import PagePOM.NykaaLoginPage;

public class NykaaLoginTest extends NykaaTest{
	
	@Test
	public void test1()
	{
		NykaaLoginPage ob=new NykaaLoginPage(driver);
		ob.values("9264788467");
	}

}

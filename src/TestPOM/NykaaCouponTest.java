package TestPOM;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PagePOM.NykaaCouponPage;
	
public class NykaaCouponTest extends NykaaTest{
	
	@Parameters("search")
	@Test
	public void test1(String s)
	{
		NykaaCouponPage ob=new NykaaCouponPage(driver);
		ob.adding(s);
		ob.values("dhgjhk");
	}
}
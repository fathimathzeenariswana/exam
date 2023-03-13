package TestPOM;

import java.io.IOException;

import org.testng.annotations.Test;

import PagePOM.NykaaPinPage;

public class NykaaPinTest extends NykaaTest{

	@Test
	public void test1() throws IOException
	{
		NykaaPinPage ob=new NykaaPinPage(driver);
		ob.checkpin();
	}
}

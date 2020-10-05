package com.qa.blaze.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.blaze.Pages.Homepage;
import com.qa.blaze.Pages.ReservePage;
import com.qa.blaze.Pages.TestBase;
import com.qa.blaze.Pages.TravelPage;
import com.qa.blaze.Util.TestUtil;

public class TravelPageTest extends TestBase {
	TravelPage travelpage;
	ReservePage reservepage;
	TestUtil testUtil;
	String sheetName = "Sheet1";
	Homepage homepage;
	
	public TravelPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		travelpage= new TravelPage();
		testUtil= new TestUtil();
		reservepage= new ReservePage();
		homepage = new Homepage();
	}
	
	@DataProvider
	public Object[][] getflightRoute(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=1)
	public  void destinationlink() {
		travelpage.vacation();
	}
	
	@Test(priority=2)
	public void homepagelink() {
		homepage=travelpage.home();
		
	}
	
	
	@Test(priority=3, dataProvider="getflightRoute")
	public void findflightTest(String Departure, String Destination) throws Exception {
		reservepage=travelpage.findflight(Departure, Destination);
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
	

}

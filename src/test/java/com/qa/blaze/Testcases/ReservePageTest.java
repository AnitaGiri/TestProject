package com.qa.blaze.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.blaze.Pages.ReservePage;
import com.qa.blaze.Pages.TestBase;
import com.qa.blaze.Pages.TravelPage;
import com.qa.blaze.Util.TestUtil;

public class ReservePageTest extends TestBase{
	
	TravelPage travelpage;
	ReservePage reservepage;
	TestUtil testUtil;
	String sheetName = "Sheet1";
	
	public ReservePageTest()
	{
		super();
	
	}
	@DataProvider
	public Object[][] getflightRoute(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@BeforeMethod
	public void setup() {
		initialization();
		travelpage= new TravelPage();
		reservepage= new ReservePage();	
		
	}
	
	
	@Test(dataProvider="getflightRoute")
	public void Choseflight(String Departure,String Destination)
	{
		reservepage=travelpage.findflight(Departure, Destination);
		reservepage.choseflight();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
	

}

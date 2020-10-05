package com.qa.blaze.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.blaze.Pages.ConfirmationPage;
import com.qa.blaze.Pages.Purchase;
import com.qa.blaze.Pages.ReservePage;
import com.qa.blaze.Pages.TestBase;
import com.qa.blaze.Pages.TravelPage;
import com.qa.blaze.Util.TestUtil;

public class PurchasePageTest extends TestBase{
	TravelPage travelpage;
	ReservePage reservepage;
	TestUtil testUtil;
	Purchase purchasepage;
	ConfirmationPage confirmationpage;
	String sheetName = "Sheet2";

	
	
	
	public PurchasePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		travelpage= new TravelPage();
		testUtil= new TestUtil();
		reservepage= new ReservePage();
		purchasepage= new Purchase();
		reservepage = travelpage.findflight(prop.getProperty("Departure"), prop.getProperty("Destination"));
		
	}
	
	@DataProvider
public Object[][] getpurchase(){
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
}
	
	
	@Test(priority=1,dataProvider="getpurchase")

	public  void flightpurchase(String Name,String Address,String City,String State,String ZipCode,
			String CardType,String CreditCardNumber,String Month,String Year,String NameonCard ) throws Exception {
		reservepage.choseflight();
		purchasepage.purchaseflight(Name,Address,City,State,ZipCode,CardType,CreditCardNumber,
				Month,Year,NameonCard);
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	

}

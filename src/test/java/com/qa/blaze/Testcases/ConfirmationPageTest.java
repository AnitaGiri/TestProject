package com.qa.blaze.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.blaze.Pages.ConfirmationPage;
import com.qa.blaze.Pages.Homepage;
import com.qa.blaze.Pages.Purchase;
import com.qa.blaze.Pages.ReservePage;
import com.qa.blaze.Pages.TestBase;
import com.qa.blaze.Pages.TravelPage;

public class ConfirmationPageTest extends TestBase {
	TravelPage travelpage;
	ReservePage reservepage;
	Purchase purchasepage;
	ConfirmationPage confirmationpage;
	Homepage homepagee;
	

	public ConfirmationPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		travelpage= new TravelPage();
		reservepage= new ReservePage();
		purchasepage= new Purchase();
		confirmationpage= new ConfirmationPage();
		homepagee= new Homepage();
		reservepage = travelpage.findflight(prop.getProperty("Departure"), prop.getProperty("Destination"));
	}
	
	@Test(priority=1)
	public void homepage() throws Exception
	{
	   homepagee=confirmationpage.homepage();
	  driver.wait(3000);
	}
	
	/*@Test(priority=0)
	public void travelpagee() throws Exception{
		travelpage=confirmationpage.travel();
		Thread.sleep(3000);
	}*/
	
/* synchronized (driver)
	{
	    driver.wait();
	}*/
		
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	

}

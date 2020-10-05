package com.qa.blaze.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservePage extends TestBase {
	
	@FindBy(xpath ="/html/body/div[2]/table/tbody/tr[1]/td[1]/input")
	WebElement choseflightCTA;
	

	public ReservePage() {
		PageFactory.initElements(driver, this);
	}
	
	public Purchase choseflight()
	{
		choseflightCTA.click();
		return new Purchase();
		
	}
	
	

}

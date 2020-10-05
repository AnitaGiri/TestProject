package com.qa.blaze.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Purchase extends TestBase{
	@FindBy(name="inputName")
			WebElement name;
	
	@FindBy(name="address")
	WebElement addrss;
	@FindBy(name="city")
	WebElement cty;
	@FindBy(name="state")
	WebElement stat;
	@FindBy(name="zipCode")
	WebElement zipcodde;
	@FindBy(name="cardType")
	WebElement cardtype;
	@FindBy(name="creditCardNumber")
	WebElement cardnumber;
	@FindBy(name="creditCardMonth")
	WebElement month;
	@FindBy(name="creditCardYear")
	WebElement yeear;
	@FindBy(name="nameOnCard")
	WebElement namecard;
	
	
@FindBy(name="rememberMe")
WebElement check;
@FindBy(xpath="/html/body/div[2]/form/div[11]/div/input")
	WebElement purchasCTA;
	
	
	
	public Purchase() {
		PageFactory.initElements(driver, this);
	}
	
	public ConfirmationPage purchaseflight(String fname,String adds,String city,String state,
			String zipcodee,String cardtypee,String carddnumber,String months,String year, String nameofcard)
	
	{
		name.sendKeys(fname);
		addrss.sendKeys(adds);
		cty.sendKeys(city);
		stat.sendKeys(state);
		zipcodde.sendKeys(zipcodee);
		cardtype.sendKeys(cardtypee);
		cardnumber.sendKeys(carddnumber);
		month.sendKeys(months);
		yeear.sendKeys(year);
		namecard.sendKeys(nameofcard);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		check.click();
		
		if(check.isSelected())
			System.out.println("checked box is checked");
		else
			System.out.println("checkbox is not checked");
	  
		purchasCTA.click();
		
		return new ConfirmationPage();
	}

}

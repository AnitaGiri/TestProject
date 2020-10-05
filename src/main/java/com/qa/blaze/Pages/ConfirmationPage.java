package com.qa.blaze.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends TestBase{
	@FindBy(linkText="home")
	WebElement hompage;
	@FindBy(linkText="Travel The World")
	WebElement travelpagee;



public ConfirmationPage()
{
	PageFactory.initElements(driver, this);
}

public TravelPage travel()
{
	
	travelpagee.click();
	return new TravelPage();
}
public Homepage homepage()
{
	hompage.click();
	return new Homepage();
}
}
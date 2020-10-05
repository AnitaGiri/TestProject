package com.qa.blaze.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TravelPage extends TestBase {
	//page factory OR
	@FindBy(linkText="home")
	WebElement Homelink;
	
	@FindBy(linkText="destination of the week! The Beach!")
	WebElement vacationlink;
	
	@FindBy(xpath="/html/body/div[3]/form/div/input")
	WebElement flightCTA;
	
	//initializations of Page objects
	public TravelPage() {
		PageFactory.initElements(driver, this);
	}
//Actions
	public ReservePage findflight(String fromPort, String toPort) {
		Select mySelect =new Select(driver.findElement(By.name("fromPort")));
		mySelect.selectByVisibleText(fromPort);
		Select mySelect1= new Select(driver.findElement(By.name("toPort")));
		mySelect1.selectByVisibleText(toPort);
		flightCTA.click();
		return new ReservePage();

}
	
	public void vacation()
	{
		vacationlink.click();
	}
	
	public Homepage home() {
		Homelink.click();
		return new Homepage();
	}
}

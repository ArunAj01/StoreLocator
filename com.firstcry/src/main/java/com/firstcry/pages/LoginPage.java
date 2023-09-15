package com.firstcry.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="lemail")
	private WebElement emailbox;
	
	@FindBy(xpath="//div[contains(@class,'btn-login-continue')]")
	private WebElement continuebtn;
	
	@FindBy(id="verfiedbtn")
	private WebElement submitbtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailId() {
		emailbox.sendKeys("arunprasaanth2020@gmail.com");
	}

	public void clickContinueBtn() {
		continuebtn.click();
	}
	
	public void clickSubmitBtn() {
		submitbtn.click();
	}
}

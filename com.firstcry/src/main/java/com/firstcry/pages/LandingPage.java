package com.firstcry.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	Actions actions;
	private WebDriverWait wait;
	
	//login
	@FindBy(xpath="//span[contains(@class,'poplogin_main poplogin R12_61')]")
	private WebElement loginbtn;
	
	@FindBy(xpath="(//span[contains(@class,'anch')])[2]")
	private WebElement storesandpreschools;
	
	@FindBy(linkText="Find Stores")
	private WebElement clickfindstores;
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions=new Actions(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	}
	

	public void ClickLogin() {
		wait.until(ExpectedConditions.visibilityOf(loginbtn));
		loginbtn.click();
	}
	
	public void StoresAndPreschools() {
		wait.until(ExpectedConditions.visibilityOf(storesandpreschools));
		actions.moveToElement(storesandpreschools).build().perform();
	}
	
	public void clickFindStores() {
		wait.until(ExpectedConditions.visibilityOf(storesandpreschools));
		clickfindstores.click();
	}

}

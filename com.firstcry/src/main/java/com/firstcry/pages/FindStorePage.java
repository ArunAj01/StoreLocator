package com.firstcry.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class FindStorePage {

	@FindBy(id="storetype")
	private WebElement clickfirstcry;
	
	@FindBy(xpath="(//select[contains(@class,'sel_lst')])[2]")
	private WebElement clickTamilnadu;
	
	@FindBy(xpath="(//select[contains(@class,'sel_lst')])[3]")
	private WebElement clickChennaiMedavakkam;
	
	@FindBy(xpath="//input[contains(@class,'btn')]")
	private WebElement searchbtn;
	
	@FindBy(xpath="//h1[contains(@id,'newheading')]")
	private WebElement verifytext;
	
	public FindStorePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	public void selectFirstcry(String storetype) {
		Select select=new Select(clickfirstcry);
		select.selectByVisibleText(storetype);
	}
	
	public void selectTamilnadu(String state) {
		Select select=new Select(clickTamilnadu);
		select.selectByVisibleText(state);
	}
	
	public void selectChennaiMedavakkam(String city) {
		Select select=new Select(clickChennaiMedavakkam);
		select.selectByVisibleText(city);
	}
	
	public void clickSearchBtn() {
		searchbtn.click();
	}
	
	public String VerifyText() {
		String text=verifytext.getText();
		return text;
	}
}

package com.firstcry.testscripts;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.firstcry.pages.FindStorePage;
import com.firstcry.pages.LandingPage;
import com.firstcry.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ReadExcel;

public class FindStoreSteps {
	
	WebDriver driver;
	LandingPage landingPage;
	FindStorePage findStorePage;
	
	
@Given("A user is on landing page")
public void a_user_is_on_landing_page() {
	driver=new ChromeDriver();
	  driver.get("https://www.firstcry.com/");
	  driver.manage().window().maximize();
   
}


@When("he click on Login page and enter the details")
public void he_click_on_login_page_and_enter_the_details() throws InterruptedException {
	
	landingPage=new LandingPage(driver);
landingPage.ClickLogin();
	
	LoginPage loginPage=new LoginPage(driver);
	loginPage.enterEmailId();
	loginPage.clickContinueBtn();
	Thread.sleep(25000);
	loginPage.clickSubmitBtn();
   
}

@When("he hover over the stores & Preschools")
public void he_hover_over_the_stores_preschools() {
   landingPage=new LandingPage(driver);
   landingPage.StoresAndPreschools();

}

@When("he click on Find stores")
public void he_click_on_find_stores() {
	   landingPage.clickFindStores();
}

@When("he switch focus to new tab")
public void he_switch_focus_to_new_tab() {
 
	ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
	driver.switchTo().window(tabs.get(1));
}


@When("he select the store Type,state and city and click search button")
public void he_select_the_store_type_state_and_city_and_click_search_button() throws IOException {
	
	String[][] data=ReadExcel.getData("Resources//LocationData.xlsx", "Sheet1");
	
	for(int i=1;i<=2 ;i++) {
		  String storetype=data[i][0];
		  String state=data[i][1];
		  String city=data[i][2];
	
	findStorePage=new FindStorePage(driver);
	findStorePage.selectFirstcry(storetype);
	findStorePage.selectTamilnadu(state);
	findStorePage.selectChennaiMedavakkam(city); 
	findStorePage.clickSearchBtn();
	
	}
	
}


@Then("he must able to see the Search store result")
public void he_must_able_to_see_the_search_store_result() {
	
	String expectedText="Firstcry Store in Chennai Medavakkam";
	String actualText=findStorePage.VerifyText();
	Assert.assertEquals(actualText, expectedText);

}

}

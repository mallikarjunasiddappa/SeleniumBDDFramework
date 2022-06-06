package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	
	//picoContainer is user for dependency injection, this is provided by cucumber
	//Single responsibility principle
	//Loosely coupled
	
	TestContextSetup testContextSetup; 
	OfferPage offerPage;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
		offerPage = testContextSetup.pageObjectManager.getOfferPage();
		
		offerPage.clickOnTopDeal();
		Thread.sleep(2000);
		testContextSetup.genericUtils.switchToNewWindow();
		
	   
		offerPage.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName = offerPage.getProductName();
	   
	}
	
	@And("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
	   
	   Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}
	
	/*public void switchToWindow() {
		   Set<String> s1= testContextSetup.driver.getWindowHandles();
		   Iterator<String> i1 = s1.iterator();
		   String parentWindow = i1.next();
		   String childWindow = i1.next();
		   testContextSetup.driver.switchTo().window(childWindow);
	}*/


}

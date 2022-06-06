package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	public LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("user is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
		
	}

	@When("^user searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		landingPage.searchItem(shortName);
	    Thread.sleep(2000);
	    testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
	    System.out.println(landingPageProductName+"is extracted from home page");
	}
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		
	}

}

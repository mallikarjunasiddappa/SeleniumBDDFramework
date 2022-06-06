package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OfferPage {

	public WebDriver driver;
	public OfferPage(WebDriver driver) {
		this.driver=driver;
	}

	private By search = By.xpath("//*[@type='search']");
	private By topDealsLink = By.linkText("Top Deals");
	private By productName = By.xpath("(//tbody//tr//td)[1]");
	
	
	
	/*Action methods*/
	public void searchItem(String shortName) {
	driver.findElement(search).sendKeys(shortName);
	}
	
	
	
	/*Action methods*/
	public void clickOnTopDeal() {
	driver.findElement(topDealsLink).click();
	}
	
	public String getSearchText() {
		String ItemName = driver.findElement(search).getText();
		return ItemName;
		}
	public String getProductName() {
		String productsName = driver.findElement(productName).getText();
		return productsName;
	}

}

package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import testRunner.runner;

public class steps extends runner {

	String url = "https://www.autotrader.com/";
		
	@Given("I launch AutoTrade in Chrome Browser")
	public void navigateToAutoTrader() throws InterruptedException {		
		System.out.println("-----------TC01-----------");
		driver.get(url);
	}

	@When("I verify home page is displayed")
	public void verifyHomePage() {
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Url is " + actualUrl);
		Assert.assertEquals(actualUrl, url);
		System.out.println("AutoTrader Launched");
	}

	@Then("I verify the following details")
	public void verifyDetails(DataTable testData) {
		List<String> elements = testData.asList(String.class);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//button[contains(.,'" + elements.get(0) + "')]")).isDisplayed();
		driver.findElement(By.xpath(".//button[contains(.,'" + elements.get(1) + "')]")).isDisplayed();
		driver.findElement(By.xpath(".//a[contains(.,'" + elements.get(2) + "')]")).isDisplayed();
		driver.findElement(By.xpath(".//button[contains(.,'" + elements.get(3) + "')]")).isDisplayed();
		driver.findElement(By.xpath(".//select[@name='makeCode']")).isDisplayed();
		String selectedMake = new Select(driver.findElement(By.xpath(".//select[@name='makeCode']")))
				.getFirstSelectedOption().getText();
		System.out.println("Selected Make is " + selectedMake);
		driver.findElement(By.xpath(".//select[@name='ModelCode']")).isDisplayed();
		String selectedModal = new Select(driver.findElement(By.xpath(".//select[@name='ModelCode']")))
				.getFirstSelectedOption().getText();
		Assert.assertEquals(selectedModal, elements.get(5));
		System.out.println("Selected Modal is " + selectedModal);
		System.out.println("Elements are verified");

		//
		WebElement advSearch = driver.findElement(By.xpath(".//a[contains(.,'Advanced Search')]"));
		advSearch.click();
		System.out.println("Search is clicked");
		// shows the Autotrader error page
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// ZipCode
		// WebElement zip=driver.findElement(By.xpath(".//form//input[@name='zip']"));

	}

	@Given("I select Advanced Search from home page")
	public void navigateToAdvancedSearchPage() {
		System.out.println("--------TC02----------");

		// Using new tab to load the url
		// ((JavascriptExecutor)driver).executeScript("window.open()");
		// ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		// driver.switchTo().window(tabs.get(1));

		driver.get("https://www.autotrader.com/cars-for-sale/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Current Url " + driver.getCurrentUrl());

	}

	@When("I enter the following details")
	public void formInputAndSearch(DataTable testData) {
		Map<String, String> data = testData.asMap(String.class, String.class);
		System.out.println("Entering the following details");
		System.out.println("ZipCode: " + data.get("ZipCode"));
		System.out.println("Condition: " + data.get("Condition"));
		System.out.println("Style: " + data.get("Style"));
		System.out.println("From Year: " + data.get("From Year"));
		System.out.println("To Year: " + data.get("To Year"));
		System.out.println("Make: " + data.get("Make"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// ZipCode
		WebElement zip = driver.findElement(By.xpath(".//form//input[@name='zip']"));
		zip.isDisplayed();
		zip.clear();
		zip.sendKeys(data.get("ZipCode"));

		// Condition
		driver.findElement(By.xpath(".//div[@class='input-label' and contains(.,'" + data.get("Condition") + "')]"))
				.click();

		// Style
		driver.findElement(By.xpath(".//div[@class='input-label' and contains(.,'" + data.get("Style") + "')]"))
				.click();

		/* Commented out as the browser not displaying the dropdown options while running the script
		 * //From Year
		 * driver.findElement(By.xpath(".//select[@name='startYear']")).isDisplayed();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); Select
		 * fromYr = new
		 * Select(driver.findElement(By.xpath(".//select[@name='startYear']")));
		 * WebElement first_value=fromYr.getFirstSelectedOption(); String
		 * value=first_value.getText(); System.out.println(value);
		 * fromYr.selectByVisibleText(data.get("From Year"));
		 * 
		 * //To Year
		 * driver.findElement(By.xpath(".//select[@name='startYear']")).isDisplayed();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); Select toYr
		 * = new Select(driver.findElement(By.xpath(".//select[@name='startYear']")));
		 * WebElement first_toValue=toYr.getFirstSelectedOption(); String
		 * toValue=first_toValue.getText(); System.out.println(toValue);
		 * fromYr.selectByVisibleText(data.get("To Year"));
		 */

		// Make
		driver.findElement(By.xpath(".//select[@name='makeFilter0']")).isDisplayed();
		Select make = new Select(driver.findElement(By.xpath(".//select[@name='makeFilter0']")));
		make.selectByVisibleText(data.get("Make"));

		System.out.println("Details entered in the form");

	}

	@Then("I click Search button")
	public void clickSearch() {
		// Search
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement search = driver.findElement(By.xpath(".//button[@type='submit']"));
		search.isDisplayed();
		search.click();
		// Actions action = new Actions(driver);
		// action.moveToElement(search).click().perform();
		System.out.println("Search button is clicked");

	}

	@Given("I am in the Search Results page")
	public void advSearchResults() {

		driver.get(
				"https://www.autotrader.com/cars-for-sale/searchresults.xhtml?city=Alpharetta&searchRadius=50&state=GA&zip=30004&vehicleStyleCodes=CONVERT&listingTypes=CERTIFIED&startYear=2017&endYear=2020&makeCodeList=BMW");
		System.out.println("Current Url is "+ driver.getCurrentUrl());
	}

	@Then("I verify only BMW cars are in the results")
	public void verifyBMWcars() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Finding the list from the featured listing
		List<WebElement> alphaList = driver.findElements(By.xpath(".//div[@data-cmp='inventoryAlphaListing']/div//h2"));
		List<String> alphaBmwList = new ArrayList<String>();
		//Going through the div text in the list and adding to the alphBmwList if the text contains the string 'BMW'
		for (int i = 0; i < alphaList.size(); i++) {
			WebElement element = alphaList.get(i);
			String innerHtml = element.getAttribute("innerHTML");
			if (innerHtml.contains("BMW")) {
				alphaBmwList.add(innerHtml);
			}
		}
		int alphaListingSize = alphaList.size();
		int alphaBmwContainedSize = alphaBmwList.size();
		System.out.println("alphaListingSize:" + alphaListingSize);
		System.out.println("alphaBmwContainedSize:" + alphaBmwContainedSize);
		//if alphaListingSize and alphaBmwContainedSize are the same then the featured list is pass.
		Assert.assertEquals(alphaListingSize, alphaBmwContainedSize);
		System.out.println("Featured Dealer displayed only BMW cars");

		//Finding the list from the other dealers
		List<WebElement> centerListingList = driver.findElements(By.xpath(
				".//div[@data-qaid='cntnr-listings-tier-listings']/div[starts-with(@data-cmp,'inventory')]//h2"));
		List<String> centerBmwList = new ArrayList<String>();
		for (int i = 0; i < centerListingList.size(); i++) {
			WebElement element = centerListingList.get(i);
			String innerHtml = element.getAttribute("innerHTML");
			if (innerHtml.contains("BMW")) {
				centerBmwList.add(innerHtml);
			}
		}
		
		int cntrListingSize = centerListingList.size();
		int centerBmwContainedSize = centerBmwList.size();
		System.out.println("cntrListingSize:" + cntrListingSize);
		System.out.println("bmwContainedSize:" + centerBmwContainedSize);
		//Checking other dealers list contains only BMW cars
		Assert.assertEquals(cntrListingSize, centerBmwContainedSize);
		System.out.println("Verified only BMW cars are displayed in the Advanced Search results page");
	}

	@Then("Log the total number of listings in the page")
	public void countBMW() {

		driver.findElement(By.xpath(".//div[@data-cmp='inventoryAlphaListing']/div")).isDisplayed();
		int alphaList = driver.findElements(By.xpath(".//div[@data-cmp='inventoryAlphaListing']/div")).size();
		driver.findElement(By.xpath(".//div[@data-qaid='cntnr-listings-tier-listings']/div")).isDisplayed();
		int searchResult = driver
				.findElements(By.xpath(
						".//div[@data-qaid='cntnr-listings-tier-listings']/div[starts-with(@data-cmp,'inventory')]"))
				.size();
		int result = alphaList + searchResult;
		System.out.println("Total Number of BMW Listings including Featured Dealer: " + result);
		
	}

}

package stepDefinitions;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AdvSearch;
import pages.HomePage;
import pages.Results;
import utilities.Browser;
import utilities.ExtentReport;
import utilities.SelUtility;

public class steps  {

	String url = "https://www.autotrader.com/";
	WebDriver driver=Browser.driver;
	HomePage home;
	AdvSearch advSearch;
	Results results;
	ExtentTest test=ExtentReport.test;
	ExtentReports extent= ExtentReport.extent;
	
	@Given("I launch AutoTrade in Chrome Browser")
	public void navigateToAutoTrader(){		
		test= extent.createTest("Test Case 1 - Verify elements on HomePage");	
		test.log(Status.INFO, "Test Case 1");
		System.out.println("-----------TC01-----------");		
		driver.get(url);		
	}

	@When("I verify home page is displayed")
	public void verifyHomePage() {
		SelUtility.implicitWait(5);
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Current Url is " + actualUrl);
		test.log(Status.INFO, "Current Url is "+actualUrl);
		Assert.assertEquals(actualUrl, url);
		System.out.println("AutoTrader Launched");
		test.log(Status.INFO, "AutoTrader Launched");
	}

	@Then("I verify the following details")
	public void verifyDetails(DataTable testData) {	
		
		 
		System.out.println("Verifying the following");
		 List<String> elements = testData.asList(String.class);
		 
		 for(int i=0;i<elements.size();i++) {
			 System.out.println(elements.get(i));
		 }
		
         home=new HomePage(driver);
         home.browseMakeDisplayed();
         Assert.assertEquals(elements.get(0), home.getbrowseMakeTitle());
         home.browseModelDisplayed();
         Assert.assertEquals(elements.get(1), home.getbrowseModelTitle());
         home.advSearchDisplayed();
         Assert.assertEquals(elements.get(2), home.getadvSearchTitle());
         home.searchDisplayed();
         Assert.assertEquals(elements.get(3), home.getsearchTitle());
         home.makeDisplayed();
         Assert.assertEquals(elements.get(4), home.getmakeValue());
         home.modelDisplayed();
         Assert.assertEquals(elements.get(5), home.getmodelValue());
         
         System.out.println("Elements are verified");
         test.log(Status.INFO, "Elements are verified");
         
         home.advSearchClick();
 		 System.out.println("Search is clicked");
		 test.log(Status.INFO, "Search is clicked");
		 test.log(Status.PASS, "Home page details verified");
		/*
		 * //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 * driver.findElement(By.xpath(".//button[contains(.,'" + elements.get(0) +
		 * "')]")).isDisplayed(); driver.findElement(By.xpath(".//button[contains(.,'" +
		 * elements.get(1) + "')]")).isDisplayed();
		 * driver.findElement(By.xpath(".//a[contains(.,'" + elements.get(2) +
		 * "')]")).isDisplayed(); driver.findElement(By.xpath(".//button[contains(.,'" +
		 * elements.get(3) + "')]")).isDisplayed();
		 * driver.findElement(By.xpath(".//select[@name='makeCode']")).isDisplayed();
		 * String selectedMake = new
		 * Select(driver.findElement(By.xpath(".//select[@name='makeCode']")))
		 * .getFirstSelectedOption().getText(); System.out.println("Selected Make is " +
		 * selectedMake);
		 * driver.findElement(By.xpath(".//select[@name='ModelCode']")).isDisplayed();
		 * String selectedModal = new
		 * Select(driver.findElement(By.xpath(".//select[@name='ModelCode']")))
		 * .getFirstSelectedOption().getText(); Assert.assertEquals(selectedModal,
		 * elements.get(5)); System.out.println("Selected Modal is " + selectedModal);
		 * 
		 * 
		 * WebElement advSearch =
		 * driver.findElement(By.xpath(".//a[contains(.,'Advanced Search')]"));
		 * advSearch.click();
		 * 
		 * // shows the Autotrader error page
		 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // ZipCode
		 * WebElement zip=driver.findElement(By.xpath(".//form//input[@name='zip']"));
		 */

	}

	@Given("I select Advanced Search from home page")
	public void navigateToAdvancedSearchPage() {
		System.out.println("--------TC02----------");
		test= extent.createTest("Test Case 2 - Advanced Search for BMW");
		test.log(Status.INFO, "Test Case 2");
		driver.get("https://www.autotrader.com/cars-for-sale/");
		SelUtility.implicitWait(5);
		System.out.println("Current Url " + driver.getCurrentUrl());
		
		/*
		 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 * 
		 * // Using new tab to load the url //
		 * ((JavascriptExecutor)driver).executeScript("window.open()"); //
		 * ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 * // driver.switchTo().window(tabs.get(1));
		 */
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
		test.log(Status.INFO, "Entering the following details");
		test.log(Status.INFO, "ZipCode: " + data.get("ZipCode"));
		test.log(Status.INFO, "Condition: " + data.get("Condition"));
		test.log(Status.INFO, "Style: " + data.get("Style"));
		test.log(Status.INFO, "From Year: " + data.get("From Year"));
		test.log(Status.INFO, "To Year: " + data.get("To Year"));
		test.log(Status.INFO, "Make: " + data.get("Make"));
		
		advSearch= new AdvSearch(driver);
		advSearch.zipCodeDisplayed();
		advSearch.setzipCode(data.get("ZipCode"));
		advSearch.condCertDisplayed();
		Assert.assertEquals(advSearch.getCondition(), data.get("Condition"));
		advSearch.setCondition();
		advSearch.styConvDisplayed();
		Assert.assertEquals(advSearch.getStyle(),data.get("Style"));
		advSearch.setStyle();
		
		//advSearch.frmYrDisplayed();
		//advSearch.selectFrmYr(data.get("From Year"));
		//advSearch.toYrDisplayed();
		//advSearch.selectToYr(data.get("To Year"));
		
		advSearch.makeDisplayed();
		advSearch.selectMake(data.get("Make"));
		System.out.println("Details entered in the form");
		
		/*
		 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // ZipCode
		 * WebElement zip = driver.findElement(By.xpath(".//form//input[@name='zip']"));
		 * zip.isDisplayed(); zip.clear(); zip.sendKeys(data.get("ZipCode")); //
		 * Condition
		 * driver.findElement(By.xpath(".//div[@class='input-label' and contains(.,'" +
		 * data.get("Condition") + "')]")) .click(); // Style
		 * driver.findElement(By.xpath(".//div[@class='input-label' and contains(.,'" +
		 * data.get("Style") + "')]")) .click();
		 * 
		 * // Commented out as the browser not displaying the dropdown options while
		 * running the script //From Year
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
		 * 
		 * // Make
		 * driver.findElement(By.xpath(".//select[@name='makeFilter0']")).isDisplayed();
		 * Select make = new
		 * Select(driver.findElement(By.xpath(".//select[@name='makeFilter0']")));
		 * make.selectByVisibleText(data.get("Make"));
		 * 
		 * System.out.println("Details entered in the form");
		 */

	}

	@Then("I click Search button")
	public void clickSearch() {
			
		advSearch.submitDisplayed();
		advSearch.submit();
		System.out.println("Search button is clicked");
		test.log(Status.INFO, "Search button is clicked");
		test.log(Status.PASS, "Advanced Search for BMW successfull");
		
		/*
		 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); WebElement
		 * search = driver.findElement(By.xpath(".//button[@type='submit']"));
		 * search.isDisplayed(); search.click(); Actions action = new Actions(driver);
		 * action.moveToElement(search).click().perform();
		 * System.out.println("Search button is clicked");
		 */

	}

	@Given("I am in the Search Results page")
	public void advSearchResults() {
		System.out.println("--------------TC03-------------");
		test= extent.createTest("Test Case 3 - Verify search results");
		test.log(Status.INFO, "Test Case 3");
		 SelUtility.implicitWait(5);
		driver.get(
				"https://www.autotrader.com/cars-for-sale/searchresults.xhtml?city=Alpharetta&searchRadius=50&state=GA&zip=30004&vehicleStyleCodes=CONVERT&listingTypes=CERTIFIED&startYear=2017&endYear=2020&makeCodeList=BMW");
		System.out.println("Current Url is "+ driver.getCurrentUrl());
		
		
	}

	@Then("^I verify only \"([^\"]*)\" cars are in the results$")//@Then("I verify only BMW cars are in the results")
	public void verifyBMWcars(String text) {
       		
        results= new Results(driver);
        results.featureResultDisplayed();
        results.centreResultDisplayed();
        System.out.println("Search Results are displayed");
        
        results.verifyResultsShowSpecficCars(text);
        System.out.println("Verified only BMW cars are displayed in the Advanced Search results page");
        test.log(Status.INFO, "Verified only BMW cars are displayed in the Advanced Search results page");
        
		/*
		 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 * 
		 * //Finding the list from the featured listing List<WebElement> alphaList =
		 * driver.findElements(By.xpath(
		 * ".//div[@data-cmp='inventoryAlphaListing']/div//h2")); List<String>
		 * alphaBmwList = new ArrayList<String>(); //Going through the div text in the
		 * list and adding to the alphBmwList if the text contains the string 'BMW' for
		 * (int i = 0; i < alphaList.size(); i++) { WebElement element =
		 * alphaList.get(i); String innerHtml = element.getAttribute("innerHTML"); if
		 * (innerHtml.contains("BMW")) { alphaBmwList.add(innerHtml); } } int
		 * alphaListingSize = alphaList.size(); int alphaBmwContainedSize =
		 * alphaBmwList.size(); System.out.println("alphaListingSize:" +
		 * alphaListingSize); System.out.println("alphaBmwContainedSize:" +
		 * alphaBmwContainedSize); //if alphaListingSize and alphaBmwContainedSize are
		 * the same then the featured list is pass.
		 * Assert.assertEquals(alphaListingSize, alphaBmwContainedSize);
		 * System.out.println("Featured Dealer displayed only BMW cars");
		 * 
		 * //Finding the list from the other dealers List<WebElement> centerListingList
		 * = driver.findElements(By.xpath(
		 * ".//div[@data-qaid='cntnr-listings-tier-listings']/div[starts-with(@data-cmp,'inventory')]//h2"
		 * )); List<String> centerBmwList = new ArrayList<String>(); for (int i = 0; i <
		 * centerListingList.size(); i++) { WebElement element =
		 * centerListingList.get(i); String innerHtml =
		 * element.getAttribute("innerHTML"); if (innerHtml.contains("BMW")) {
		 * centerBmwList.add(innerHtml); } }
		 * 
		 * int cntrListingSize = centerListingList.size(); int centerBmwContainedSize =
		 * centerBmwList.size(); System.out.println("cntrListingSize:" +
		 * cntrListingSize); System.out.println("bmwContainedSize:" +
		 * centerBmwContainedSize); //Checking other dealers list contains only BMW cars
		 * Assert.assertEquals(cntrListingSize, centerBmwContainedSize); System.out.
		 * println("Verified only BMW cars are displayed in the Advanced Search results page"
		 * );
		 */
	}

	@Then("Log the total number of listings in the page")
	public void countBMW() {
        
		int count=results.featureResultCount()+results.centerResultCount();
		System.out.println("Total Number of BMW Listings(including Featured Dealer): " + count);
		test.log(Status.INFO, "Total Number of BMW Listings(including Featured Dealer): " + count);
		test.log(Status.PASS, " Search Results verified scuccessfully");
		
		/*
		 * driver.findElement(By.xpath(".//div[@data-cmp='inventoryAlphaListing']/div"))
		 * .isDisplayed(); int alphaList =
		 * driver.findElements(By.xpath(".//div[@data-cmp='inventoryAlphaListing']/div")
		 * ).size(); driver.findElement(By.xpath(
		 * ".//div[@data-qaid='cntnr-listings-tier-listings']/div")).isDisplayed(); int
		 * searchResult = driver .findElements(By.xpath(
		 * ".//div[@data-qaid='cntnr-listings-tier-listings']/div[starts-with(@data-cmp,'inventory')]"
		 * )) .size(); int result = alphaList + searchResult;
		 * System.out.println("Total Number of BMW Listings including Featured Dealer: "
		 * + result);
		 */
		
	}

}

package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Results {
    
	public Results(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	 @FindBy(xpath=".//div[@data-cmp='inventoryAlphaListing']/div")
	 private WebElement featureResult;
	 @FindBy(xpath=".//div[@data-qaid='cntnr-listings-tier-listings']/div")
	 private WebElement centreResult;
	 @FindAll(@FindBy(xpath=".//div[@data-cmp='inventoryAlphaListing']/div//h2"))
	 private List<WebElement> featureResult_list;
	 @FindAll(@FindBy(xpath=".//div[@data-qaid='cntnr-listings-tier-listings']/div[starts-with(@data-cmp,'inventory')]//h2"))
	 private List<WebElement> centreResult_list;
	 
	 public void featureResultDisplayed() {
		 featureResult.isDisplayed();
	 }
	 
	 public void centreResultDisplayed() {
		 centreResult.isDisplayed();
	 }
	 
	 public int featureResultCount() {
		return featureResult_list.size();
	 }
	 public int centerResultCount() {
		 return centreResult_list.size();
	 }
	 public void verifyResultsShowSpecficCars(String text) {
			// Verifying FeaturedDealerList
			List<String> featureSpCarList = new ArrayList<String>();
			for (int i = 0; i < featureResultCount(); i++) {
				WebElement element = featureResult_list.get(i);
				String innerHtml = element.getAttribute("innerHTML");
				if (innerHtml.contains(text)) {
					featureSpCarList.add(innerHtml);
				}
			}			
			int featureSpCarSize = featureSpCarList.size();
			System.out.println("featureListingSize:" + featureResultCount());
			System.out.println("featureSpCarSize:" + featureSpCarSize);
			Assert.assertEquals(featureResultCount(), featureSpCarSize);
			
		    System.out.println("Featured Dealer displayed only "+ text +"cars");

			//Verifying the list from the other dealers			
			List<String> centerSpCarList = new ArrayList<String>();
			for (int i = 0; i < centerResultCount(); i++) {
				WebElement element = centreResult_list.get(i);
				String innerHtml = element.getAttribute("innerHTML");
				if (innerHtml.contains(text)) {
					centerSpCarList.add(innerHtml);
				}
			}			
			int centerSpCarSize = centerSpCarList.size();
			System.out.println("cntrListingSize:" + centerResultCount());
			System.out.println("centreSpCarSize:" + centerSpCarSize);
			Assert.assertEquals(centerResultCount(), centerSpCarSize);
			
			System.out.println("Other Dealers displayed only "+ text +"cars");
	 }
	
	
}

package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SelUtility;

public class HomePage {
  
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath="//button[@title='Browse by Make']")
	 private WebElement browseMake;
	 @FindBy(xpath="//button[@title='Browse by Style']")
	 private WebElement browseStyle;
	 @FindBy(linkText="Advanced Search")
	 private WebElement advSearch;
	 @FindBy(id="search")
	 private WebElement search;
	 @FindBy(xpath=".//select[@name='makeCode']")
	 private WebElement make;
	 @FindBy(xpath=".//select[@name='ModelCode']")
	 private WebElement model;
	 
	 public void browseMakeDisplayed() {
		 browseMake.isDisplayed();
	 }
	 
	 public String getbrowseMakeTitle() {
		return browseMake.getAttribute("innerHTML");
	 }
	 public void browseModelDisplayed() {
		 browseStyle.isDisplayed();
	 }
	 public String getbrowseModelTitle() {
			return browseStyle.getAttribute("innerHTML");
		 }
	 
	 public void advSearchDisplayed() {
		 advSearch.isDisplayed();
	 }
	 public void advSearchClick() {
		 advSearch.click();
		 //SelUtility.clickJs(advSearch);
	 }
	 public String getadvSearchTitle() {
			return advSearch.getAttribute("innerHTML");
		 }
	 
	 public void searchDisplayed() {
		 search.isDisplayed();
	 }
	 public String getsearchTitle() {
		 return search.getAttribute("innerHTML");
	 }
	 public void makeDisplayed() {
		 make.isDisplayed();
	 }
	 public String getmakeValue() {
		 return SelUtility.dropdownFirstOptionSelect(make);			 
    }
	 
	 public void modelDisplayed() {
		 model.isDisplayed();
	 }
	  
	 public String getmodelValue() {
		 return SelUtility.dropdownFirstOptionSelect(model);	 
	}
	
}
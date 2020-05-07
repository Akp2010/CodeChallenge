package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SelUtility;


public class AdvSearch {
	
	public AdvSearch(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	 @FindBy(xpath="//form//input[@name='zip']")
	 private WebElement zipCode;
	 @FindBy(xpath=".//div[@class='input-label' and contains(.,'Certified')]")
	 private WebElement condCert;
	 @FindBy(xpath=".//div[@class='input-label' and contains(.,'Convertible')]")
	 private WebElement styConv;
	 @FindBy(xpath=".//select[@name='startYear']")
	 private WebElement frmYr;
	 @FindBy(xpath=".//select[@name='endYear']")
	 private WebElement toYr;
	 @FindBy(xpath=".//select[@name='makeFilter0']")
	 private WebElement make;
	 @FindBy(xpath=".//button[@type='submit']")
	 private WebElement submit;
     
	 public void zipCodeDisplayed() {
		 zipCode.isDisplayed();
	 }
	 
	 public void condCertDisplayed() {
		 condCert.isDisplayed();
	 }
	 
	 public void styConvDisplayed() {
		styConv.isDisplayed();
	 }
	 
	 public void frmYrDisplayed() {
		 frmYr.isDisplayed();
	 }
	 
	 public void toYrDisplayed() {
		toYr.isDisplayed();
	 }
	 
	 public void makeDisplayed() {
		 make.isDisplayed();
	 }
	 
	 public void submitDisplayed() {
		 submit.isDisplayed();
	 }
	 
	 public void setzipCode(String keys) {
		 SelUtility.typeText(zipCode, keys);
	 }
	 
	 public void setCondition() {		 
			 SelUtility.checkboxSelect(condCert);		 
	 }
	 public String getCondition() {		 
		 return condCert.getAttribute("innerHTML");	 
     }
	 public void setStyle() {		 
			 SelUtility.checkboxSelect(styConv);		 
	 }
	 public String getStyle() {		 
		 return styConv.getAttribute("innerHTML");	 
     }
	 
	 public void selectFrmYr(String visibleText) {
		 SelUtility.dropdownOptionSelect(frmYr,visibleText);
	 }
	 
	 public void selectToYr(String visibleText) {
		 SelUtility.dropdownOptionSelect(toYr,visibleText);
	 }
	 public void selectMake(String visibleText) {
		 SelUtility.dropdownOptionSelect(make,visibleText);
	 }
	 
	 public void submit(){
		 submit.click();
		//SelUtility.clickJs(submit);
	 }
}

package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelUtility {

	public static void typeText(WebElement element, String keys) {		
		element.click();
		element.clear();
		element.sendKeys(keys);
	}
	
	public static void checkboxSelect(WebElement element) {		
		element.click();
		
	}
	
	public static void dropdownOptionSelect(WebElement element, String keys) {		
		Select sel = new Select(element);
		sel.selectByVisibleText(keys);
	}
	
	public static String dropdownFirstOptionSelect(WebElement element) {		
		Select sel = new Select(element);
		return sel.getFirstSelectedOption().getAttribute("innerHTML");
	}
	
	public static boolean implicitWait(long time) {
		try {
		Browser.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public static boolean explicitWait(WebElement element,long time) {
		WebDriverWait wait = new WebDriverWait(Browser.driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
		
	}
	
	public static void clickJs(WebElement element) {
		 JavascriptExecutor executor = (JavascriptExecutor)Browser.driver;
		 executor.executeScript("arguments[0].click();", element);
	}
}

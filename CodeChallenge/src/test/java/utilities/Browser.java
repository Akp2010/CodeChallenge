package utilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class Browser {

	 public static WebDriver driver;
	 
	 public static void initiateBrowser() {
		 System.setProperty("webdriver.chrome.driver", 
		    		"src/test/java/resources/chromedriver.exe");   
		    ChromeOptions options = new ChromeOptions();    
		    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);   
		    options.setPageLoadStrategy(PageLoadStrategy.NONE);
		    driver = new ChromeDriver(options);
		    driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
		    System.out.println("Driver Initialized");	       
	 }
	 
	 public static void closeBrowser() {
	        driver.close();
	        driver.quit();
	 }
}

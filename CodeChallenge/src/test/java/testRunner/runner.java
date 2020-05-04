package testRunner;



import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},     
        tags= {"@Sanity1"},
        monochrome=true
        )

public class runner extends AbstractTestNGCucumberTests{
	public static WebDriver driver;
	
	
	@BeforeSuite
	public void setUp() {
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
	 
          
	@AfterTest
    public void writeExtentReport() {
        Reporter.loadXMLConfig("src/test/java/resources/extent-config.xml");
    }
	
	@AfterSuite
	public void tearDown() {	

		System.out.println("Driver Closed");
		driver.close();
	    driver.quit();
	}

}

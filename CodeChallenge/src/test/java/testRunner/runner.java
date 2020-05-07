package testRunner;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.Browser;
import utilities.ExtentReport;


@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        //plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},     
        tags= {"@Sanity1","~@Sanity2","~@Sanity3"},
        monochrome=true
        )

public class runner extends AbstractTestNGCucumberTests{
		
	
	@BeforeSuite
	public void setUp() {
		Browser.initiateBrowser();
		ExtentReport.extentReportSetUp();
		
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "src/test/java/resources/chromedriver.exe"); ChromeOptions options = new
		 * ChromeOptions(); options.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		 * options.setPageLoadStrategy(PageLoadStrategy.NONE); driver = new
		 * ChromeDriver(options); driver.manage().window().maximize();
		 * driver.manage().deleteAllCookies(); System.out.println("Driver Initialized");
		 */
		          
	}     
	 
		
	@AfterSuite
	public void tearDown() {	

		Browser.closeBrowser();
		ExtentReport.endReport();
		/*
		 * System.out.println("Driver Closed"); driver.close(); driver.quit();
		 */
	}

}

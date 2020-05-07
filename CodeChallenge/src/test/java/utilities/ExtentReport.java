package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	WebDriver driver= Browser.driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
		
	public static void extentReportSetUp() {
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/ExtentReport.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("AutoTrader Sanity Tests");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent.setSystemInfo("Application", "AutoTrader");
		extent.setSystemInfo("User", "Aswathy");
	}
	
	public static void endReport() {
		extent.flush();
	}
	
	}

package testscript;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.Browsersetup;

public class Baseclass extends Browsersetup {
	public static ExtentTest testcase;
	public static ExtentReports extentreport;
	public static ExtentSparkReporter report;

	@BeforeSuite
	public void reportSetup() {
	
		extentreport = new ExtentReports();
		report = new ExtentSparkReporter("C:\\Users\\Admin\\Desktop\\POS\\reports.html");
		extentreport.attachReporter(report);
	}
	
	
	@BeforeTest
	public void setup() {
		setProperties();
		
		Browsersetup.StartBrowser();
	}
//	@AfterTest
//	public void tearDown() {
//		Browsersetup.quitbrowser(driver);
//	}
	@AfterTest
	public void reportgeneration() {
		extentreport.flush();
	}
}

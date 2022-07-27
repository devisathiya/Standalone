package utilities;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsersetup extends SetUp {

	public static WebDriver StartBrowser() {
		try {
			String browserName= prop.getProperty("browser");
			String appURL = prop.getProperty("url");
			if (browserName.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}

			else if (browserName.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions opt = new ChromeOptions();
				opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking","enable-automation"));
				driver = new ChromeDriver(opt);
				
			}

			else if (browserName.equalsIgnoreCase("IE")) {

				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			} else if (browserName.equalsIgnoreCase("Edge")) {

				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("Safari")) {

				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
			}
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(appURL);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return driver;

	}
	
	public static void quitbrowser(WebDriver driver) {
		driver.quit();
	}
	
}

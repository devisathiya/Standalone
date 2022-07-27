package pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.SetUp;

public class Loginpage extends SetUp {

	@FindBy(id = "userName")
	public static WebElement userid;

	@FindBy(id = "password")
	public static WebElement pwd;

	@FindBy(id = "submit")
	public static WebElement login;

	@FindBy(xpath = "/html/body/p-dynamicdialog/div/div")
	public static WebElement sessionpopup;

	@FindBy(xpath ="//div[@class ='p-dialog-footer']/button")
	public static List<WebElement> confirmbutton;
	
	@FindBy(xpath ="//div[@class ='p-dialog-header ng-tns-c36-8 ng-star-inserted']")
	public static WebElement confirmheader;
	
	@FindBy(xpath = "/html/body/p-dynamicdialog/div/div/div[2]/app-confirmation-popup/p")
	public static WebElement confirmmessage;
	
	@FindBy(xpath="//div[@class='p-dialog-footer']/button[2]")
	public static WebElement sessionyes;

	@FindBy(xpath="//div[@class='p-dialog-footer']/button[1]")
	public static WebElement sessionno;

	@FindBy(xpath = "//div[@class='ng-trigger ng-trigger-animation ng-tns-c36-5 startofday p-dialog p-dynamic-dialog p-component ng-star-inserted']")
	public static WebElement startdaypopup;

	@FindBy(xpath = "//div[@class='p-column-title value']/input")
	public static WebElement enteramount;
	
	@FindBy(xpath="//div[@class='p-column-title value']/input")
	public static WebElement cashvalue;

	@FindBy(xpath="//div[@class='footer ltr']/button")
	public static WebElement startdayokbutton;

	@FindBy(xpath="//div[contains(@class, 'endofday p-dialog p-dynamic-dialog')]")
	public static WebElement endofthedayheader;

	@FindBy(xpath="//div[@class='p-column-title value']/input")
	public static WebElement endofthedayamount;

	@FindBy(xpath="//div[@class='buttonContainer']/button")
	public static WebElement endofokbtn;

	@FindBy(xpath="//div[@class='logoBackground']")
	public static WebElement homepageloadcheck;
	
	@FindBy(xpath = "/html/body/p-dynamicdialog/div/div/div[2]/app-lookup/div/app-start-day/div[2]/button")
	public static WebElement okbutton;
	
	@FindBy(xpath = "/html/body/p-dynamicdialog/div/div")
	public static WebElement errorpopup;
	
	@FindBy(xpath = "/html/body/p-dynamicdialog/div/div/div[1]")
	public static WebElement errorheader;
	
	@FindBy(xpath = "//div[@class='p-dialog-content message']")
	public static WebElement errormesaage;
	
	
	public static void logintoPOS() {
		userid.sendKeys(prop.getProperty("username"));
		pwd.sendKeys(prop.getProperty("password"));
		login.click();
	}


}



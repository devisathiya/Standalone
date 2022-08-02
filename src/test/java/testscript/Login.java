
package testscript;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import pagefactory.Loginpage;

public class Login extends Baseclass {
	
	public static String parentwindow;
	public static final String Confirmheader = "Confirmation";
	public static final String Errorheader = "Error Message";
	public static final String Confirmmessage ="An Existing session is still in open state, Do you want to continue with the open session?";
	public static final String Errorcontent = "User-id or password entered is incorrect";
	
	
	@Test
	public void browseropen() {
		testcase = extentreport.createTest("Verify POS Title");
		String title = driver.getTitle();
		parentwindow = driver.getWindowHandle();
		if (title.equals("Pos")) {
			System.out.println("POS login page present");
			testcase.log(Status.PASS, "POS Login Page Successfully Open");
		} else {
			System.out.println("POS login page not present");
			testcase.log(Status.FAIL, " POS Login Page Not Open");

		}
	}
	
	@Test
	public void validlogin() throws IOException {
	
		testcase = extentreport.createTest("Valid Login TestCase");
		PageFactory.initElements(driver, Loginpage.class);
		Loginpage.logintoPOS();
		testcase.log(Status.PASS, " Login Successful");
	}
	@Test(enabled=false)
	public void validloginsession() throws IOException {
 		testcase = extentreport.createTest("Login Session TestCase");
 	 PageFactory.initElements(driver, Loginpage.class);
 	 String sess="Start Of Day,Invoice,Float Out,Float In";
 	String popup=jdbcTemplate.queryForObject("select top (1) NOTE from POS_BOX_OPERATION where USER_ID=26 order by BOX_OPERATION_ID desc", String.class); 
 		 if (sess.contains(popup)) {
			System.out.println("Login Session pop up present");
			testcase.log(Status.PASS, " Login Session pop up present");
			System.out.println(prop.getProperty("sessionprob"));
			if (prop.getProperty("sessionprob").equalsIgnoreCase("no")) {
				Loginpage.sessionno.click();
				System.out.println("Start of the day pop up present");
				testcase.log(Status.PASS, " Start of the day pop up present");
				endoftheday();
				validlogin();
				startoftheday();
			} else {
				Loginpage.sessionyes.click();
				System.out.println("Existing Session was open");
				testcase.log(Status.PASS, " Existing Session was open");
				if (Loginpage.homepageloadcheck.isEnabled()) {
					System.out.println("Homepage loaded using Existing Session");
					testcase.log(Status.PASS, " Homepage using Existing Session");
				}

			}
		}

	else {
			startoftheday();
			System.out.println("Start of the day functionality completed without login session");
		}
	
} 

	public void startoftheday() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (Loginpage.cashvalue.isEnabled()) {

			System.out.println("The cash value " + prop.getProperty("cashamnt"));
			Loginpage.cashvalue.sendKeys(prop.getProperty("cashamnt"));
			Loginpage.startdayokbutton.click();
			if (Loginpage.homepageloadcheck.isEnabled()) {
				System.out.println("Homepage loaded after start of the day pop up entry");
				testcase.log(Status.PASS, " Homepage loaded after start of the day pop up entry");
			}

		} else {
			System.out.println(
					"Homepage loaded without start of the day pop up entry because no existing session present");
			testcase.log(Status.PASS,
					" Homepage loaded without start of the day pop up entry because no existing session present");
		}

	}

	public static void endoftheday() {
		if (Loginpage.endofthedayheader.isEnabled()) {
			System.out.println("End of the day pop up entry is present");
			testcase.log(Status.PASS, " End of the day pop up entry is present");
			Loginpage.endofthedayamount.sendKeys(prop.getProperty("endofamount"));
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].style.background='white'", Loginpage.endofokbtn);
			//LoginPage.endofokbtn.click();
			//WebElement loginBtn = driver.findElement(By.id("login"));      
			String javascript = "arguments[0].click()";      
			JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;        
			jsExecutor.executeScript(javascript, Loginpage.endofokbtn); 
			
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.switchTo().window(parentwindow);
			try {
				System.out.println(parentwindow);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			/*
			 * WebDriverWait wait= new WebDriverWait(driver,40);
			 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(parentwindow));
			 */

	
		}

	}
}
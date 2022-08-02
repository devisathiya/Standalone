package pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Common_objects {

	@FindBy(xpath="//div[@class='topbarMenu']/img[@id='topMenu']")
	public static WebElement sidemenuclick;
	
	@FindBy(xpath="//div[contains(@class, 'userMenu p-panelmenu p-component')]"
			+ "/div[not(contains(@class,'p-hidden ng-star-inserted'))]/div/a")

	public static List<WebElement> sidemenuoptios;
	
	@FindBy(xpath="//div[contains(@class, 'userMenu p-panelmenu p-component')]/div[not(contains(@class,'p-hidden ng-star-inserted'))]"
			+ "/div[2]/div/p-panelmenusub/ul/li")
	public static List<WebElement> sidesubmenuoptios;
	
	@FindBy(xpath="//div[@class='submit']/button")
	public static WebElement addbtn;
	
	@FindBy(xpath="//div[@class='searchCont inputClass ltrUI ng-star-inserted']/div/input")
	public static WebElement searchvalue;
	
	@FindBy(xpath="//div[@class='searchCont inputClass ltrUI ng-star-inserted']/div/span")
	public static WebElement searchicon;
	
	
	@FindBy(xpath="//div[contains(@class,'errorMessage ')]/div[1]/div/button")
	public static WebElement msgclosebtn;
	
	@FindBy(xpath="//div[contains(@class,'errorMessage ')]/div[2]")
	public static WebElement msgdetails;
	
	@FindBy(xpath="//div[contains(@class,'session p-dialog p-dynamic-dialog p-component ng-star-inserted')]/div[2]/app-confirmation-popup/p")
	public static WebElement deletepopupmsg;
	
	@FindBy(xpath="//div[2]/app-confirmation-popup/div/button[2]")
	public static WebElement deletebtn;
	
	
	public static void search(String code) {
		Common_objects.searchvalue.clear();
		Common_objects.searchvalue.sendKeys(code);
		Common_objects.searchicon.click();
	}
	
}



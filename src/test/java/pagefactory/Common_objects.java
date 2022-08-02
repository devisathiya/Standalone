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

	
}



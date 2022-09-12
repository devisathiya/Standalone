package pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AreaManagementObjects {

	@FindBy(xpath="//div[contains(@class,'itemList p-dialog p-dynamic-dialog')]/div[2]/app-add-area-management/div/h4")
	public static WebElement areaaddheader;
	
	@FindBy(xpath="//div[contains(@class, 'basicContainer')]/div[2]/div/span/input")
	public static WebElement areadescE;
	
	@FindBy(xpath="//div[contains(@class, 'basicContainer')]/div[3]/div/span/input")
	public static WebElement areadescA;
	
	@FindBy(xpath="//div[contains(@class, 'container-top editAreaHeader')]/div[@class='button-container']/div/button")
	public static WebElement areaupdatebtn;
	
	@FindBy(xpath="//div/app-details-info/div/div/h5")
	public static WebElement terminaltab;
	
	@FindBy(xpath="//div/app-details-info/div/p-table/div/div/table/tbody/tr/td[2]")
	public static WebElement terminalname;
	
	@FindBy(xpath="//div/table/tbody/tr/td[4]/span[@class='ng-star-inserted']/img[@src='assets/icons/AreaEdit.svg']")
	public static WebElement designareaicon;
	
	@FindBy(xpath="//div[contains(@class, 'title-container')]/h4")
	public static WebElement designareaheader;
	
	@FindBy(xpath="//div[contains(@class,'grid tableManagement table_otr')]/div/div")
	public static WebElement designerearightclick;
	
	@FindBy(xpath="//div[contains(@class,'grid tableManagement table_otr')]/div/p-contextmenu/div/p-contextmenusub/ul/li")
	public static WebElement designareamenulist;
	
	
	
	public static void areaaddedit(String descE, String descA) {
		AreaManagementObjects.areadescE.sendKeys(descE);
		AreaManagementObjects.areadescE.sendKeys(descA);
		/*
		 * if(AreaManagementObjects.terminaltab.getText().
		 * equalsIgnoreCase("Terminal List")) {
		 * 
		 * }
		 */
		AreaManagementObjects.areaupdatebtn.click();

	}
}

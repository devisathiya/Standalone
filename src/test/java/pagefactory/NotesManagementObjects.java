package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotesManagementObjects {

	@FindBy(xpath = "//div[contains(@class,'itemList p-dialog p-dynamic-dialog')]/div[2]/app-addoredit-notes/div/h4")
	public static WebElement notesheader;
	
	@FindBy(xpath = "//div[contains(@class,'itemList p-dialog p-dynamic-dialog')]/div[2]/app-addoredit-sub-card/div/h4")
	public static WebElement subcardheader;
	
	@FindBy(xpath = "//div/table/tbody/tr/td[5]/span[@class='ng-star-inserted']/img[@src='assets/icons/edit.svg']")
	public static WebElement editicon;
	
	@FindBy(xpath = "//div/table/tbody/tr/td[5]/span[@class='ng-star-inserted']/img[@src='assets/icons/delete.svg']")
	public static WebElement deleteicon;
	
	@FindBy(xpath = "//div[contains(@class, 'formContainer')]/p-togglebutton/div")
	public static WebElement togglebtn;
	
	
}

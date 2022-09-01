package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testscript.Baseclass;

public class Itemmanagement_objects extends Baseclass{

	@FindBy(xpath="//div[contains(@class,'itemList p-dialog p-dynamic-dialog')]/div[2]/app-addoredit-item-class/div/h4")
	public static WebElement header;
	
	@FindBy(xpath="//div[contains(@class,'itemList p-dialog p-dynamic-dialog')]/div[2]/app-addoredit-item-family/div/h4")
	public static WebElement familyheader;
	
	@FindBy(xpath="//div[@class='formContainer']/input[1]")
	public static WebElement classcode;
	
	@FindBy(xpath="//div[@class='formContainer']/input[2]")
	public static WebElement classdescE;
	
	@FindBy(xpath="//div[@class='formContainer']/input[3]")
	public static WebElement classdescA;
			
	@FindBy(xpath="//div[@class='button-Container']/button")
	public static WebElement classsavebtn;
	
	
	@FindBy(xpath="//div/table/tbody/tr/td[1]")
	public static WebElement codecheck;
	
	@FindBy(xpath="//div/table/tbody/tr/td[4]/span[@class='ng-star-inserted']/img[@src='assets/icons/edit.svg']")
	public static WebElement editicon;
	
	@FindBy(xpath="//div/table/tbody/tr/td[4]/span[@class='ng-star-inserted']/img[@src='assets/icons/delete.svg']")
	public static WebElement deleteicon;
	
	
	@FindBy(xpath="//div[contains(@class,'itemList mainMenu p-dialog p-dynamic-dialog p-component')]/div/span")
	public static WebElement addheader;
	
	@FindBy(xpath="//div[contains(@class,'itemList subMenu p-dialog p-dynamic-dialog p-component')]/div/span")
	public static WebElement submenuaddheader;
	
	@FindBy(xpath="//div/span/input[@name='mainMenuCode']")
	public static WebElement menucode;
	
	@FindBy(xpath="//div/span/input[@name='mainMenuName']")
	public static WebElement menuName;
	
	@FindBy(xpath="//div/span/input[@name='mainMenuNameA']")
	public static WebElement menuNameA;
	
	@FindBy(xpath="//div/span/input[@id='subMenuCode']")
	public static WebElement submenucode;
	
	@FindBy(xpath="//div/span/input[@id='subMenuName']")
	public static WebElement submenuName;
	
	@FindBy(xpath="//div/span/input[@id='subMenuNameA']")
	public static WebElement submenuNameA;

	@FindBy(xpath="//form/div/button[@id='save-id']")
	public static WebElement savebtn;
	
	@FindBy(xpath="//div/table/tbody/tr/td[5]/span[@class='ng-star-inserted']/img[@src='assets/icons/edit.svg']")
	public static WebElement editbtn;
	
	@FindBy(xpath="//div/table/tbody/tr/td[5]/span[@class='ng-star-inserted']/img[@src='assets/icons/delete.svg']")
	public static WebElement deletebtn;
	
	@FindBy(xpath="//form/div/button[@id='update-id']")
	public static WebElement updatebtn;
	
	
	public static void itemaddedit(String code, String descE, String descA){
		Itemmanagement_objects.classcode.sendKeys(code);
		Itemmanagement_objects.classdescE.sendKeys(descE);
		Itemmanagement_objects.classdescA.sendKeys(descA);
		Itemmanagement_objects.classsavebtn.click();
		
	}
	
	public static void menuaddedit(String code, String descE, String descA){
		Itemmanagement_objects.menucode.sendKeys(code);
		Itemmanagement_objects.menuName.sendKeys(descE);
		Itemmanagement_objects.menuNameA.sendKeys(descA);
		Itemmanagement_objects.savebtn.click();
		
	}
	
	public static void submenuaddedit(String code, String descE, String descA){
		Itemmanagement_objects.submenucode.sendKeys(code);
		Itemmanagement_objects.submenuName.sendKeys(descE);
		Itemmanagement_objects.submenuNameA.sendKeys(descA);
		Itemmanagement_objects.savebtn.click();
		
	}

	public static void itemaddedit( String descE, String descA){
		Itemmanagement_objects.classdescE.sendKeys(descE);
		Itemmanagement_objects.classdescA.sendKeys(descA);
		Itemmanagement_objects.classsavebtn.click();
		
	}
	
	public static void menuedit( String descE, String descA){
		Itemmanagement_objects.menuName.sendKeys(descE);
		Itemmanagement_objects.menuNameA.sendKeys(descA);
		Itemmanagement_objects.updatebtn.click();
		
	}
	
	public static void submenuedit( String descE, String descA){
		Itemmanagement_objects.submenuName.sendKeys(descE);
		Itemmanagement_objects.submenuNameA.sendKeys(descA);
		Itemmanagement_objects.updatebtn.click();
		
	}
	
	
}

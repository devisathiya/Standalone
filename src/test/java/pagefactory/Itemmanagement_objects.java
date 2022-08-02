package pagefactory;

import java.util.concurrent.TimeUnit;

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
	
	
	
	
	public static void itemaddedit(String code, String descE, String descA){
		Itemmanagement_objects.classcode.sendKeys(code);
		Itemmanagement_objects.classdescE.sendKeys(descE);
		Itemmanagement_objects.classdescA.sendKeys(descA);
		Itemmanagement_objects.classsavebtn.click();
		
	}

	public static void itemaddedit( String descE, String descA){
		Itemmanagement_objects.classdescE.sendKeys(descE);
		Itemmanagement_objects.classdescA.sendKeys(descA);
		Itemmanagement_objects.classsavebtn.click();
		
	}
	
	
	
	
}

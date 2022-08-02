package testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.Common_objects;
import pagefactory.Itemmanagement_objects;

public class Itemfamily extends Baseclass{

	 String menuname="Item Details";
	 String submenuname="Item Family";
	 String code="0102";
	 String descE="Automationfamilytest";
	 String descA="test";
	
	@Test(priority=0)
 
	public void itemfamilyscript() {
		PageFactory.initElements(driver, Itemmanagement_objects.class);
		Common_class.testobjects(menuname,submenuname);
	System.out.println("Item family selected through common script");

	Common_objects.addbtn.click();
	
	if(Itemmanagement_objects.familyheader.getText().equalsIgnoreCase("Item Family Details")) {
		System.out.println("Item Family details creation popup present");
		
		Itemmanagement_objects.itemaddedit(code, descE, descA);
		System.out.println(code+" "+Common_objects.msgdetails.getText());
		Common_objects.msgclosebtn.click();
		
	}
	else {
		System.out.println("Item Family details creation popup may not present or header name is changed");
	}
	
 }
	
	@Test(priority=1)
	public void itemFamilyedit() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		PageFactory.initElements(driver, Common_objects.class);
		Common_objects.search(code);
		if(Itemmanagement_objects.codecheck.getText().equalsIgnoreCase(code)) {
			Itemmanagement_objects.editicon.click();
			Itemmanagement_objects.itemaddedit("Automationtest2", "test");
			System.out.println(code+" "+Common_objects.msgdetails.getText());
			Common_objects.msgclosebtn.click();
			
			
		}
		
	}
	
	@Test(priority=2)
	public void itemFamilydelete() {
		Common_objects.search(code);
		PageFactory.initElements(driver, Common_objects.class);
		if(Itemmanagement_objects.codecheck.getText().equalsIgnoreCase(code)) {
			Itemmanagement_objects.deleteicon.click();
			if(Common_objects.deletepopupmsg.isDisplayed()) {
				System.out.println(Common_objects.deletepopupmsg.getText());
				Common_objects.deletebtn.click();
				
				
			}
			
			System.out.println(code+" "+Common_objects.msgdetails.getText());
			Common_objects.msgclosebtn.click();
		}
		
	}
	
	
}

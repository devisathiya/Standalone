package testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.Common_objects;
import pagefactory.Itemmanagement_objects;

public class Itemclass extends Baseclass {
	 String menuname="Item Details";
	 String submenuname="Item Class";
	 String code="0102";
	 String descE="Automationtest2";
	 String descA="test";
	
	@Test(priority=0)
 
	public void itemclassscript() {
		PageFactory.initElements(driver, Itemmanagement_objects.class);
		Common_class.testobjects(menuname,submenuname);
	System.out.println("Item class selected through common script");

	Common_objects.addbtn.click();
	if(Itemmanagement_objects.header.getText().equalsIgnoreCase("Item Class Details")) {
		System.out.println("Item class details creation popup present");
		
		Itemmanagement_objects.itemaddedit(code, descE, descA);	
		
		System.out.println(code+" "+Common_objects.msgdetails.getText());
		Common_objects.msgclosebtn.click();
		
		
		
	}
	else {
		System.out.println("Item class details creation popup may not present or header name is changed");
	}
	
 }
	
	@Test(dependsOnMethods="itemclassscript")
	public void itemclassedit() {
		
		PageFactory.initElements(driver, Common_objects.class);
		Common_objects.search(code);
		if(Itemmanagement_objects.codecheck.getText().equalsIgnoreCase(code)) {
			Itemmanagement_objects.editicon.click();
			Itemmanagement_objects.itemaddedit("Automationtest2", "test");
			System.out.println(code+" "+Common_objects.msgdetails.getText());
			Common_objects.msgclosebtn.click();
			
			
		}
		
	}
	
	@Test(dependsOnMethods="itemclassedit")
	public void itemclassdelete() {
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
	


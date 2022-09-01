package testscript;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.Common_objects;
import pagefactory.Itemmanagement_objects;

public class Mainmenu extends Baseclass {
	 String menuname="Menu Details";
	 String submenuname="Main Menu";
	 String code="1114";
	 String nameE="Automation1";
	 String nameA="test";
	
	@Test(priority=0)

	public void mainmenuadd() {
		PageFactory.initElements(driver, Itemmanagement_objects.class);
		Common_class.testobjects(menuname,submenuname);
		System.out.println("Main Menu  selected through common script");
		Common_objects.addbtn.click();
		
		if(Itemmanagement_objects.addheader.getText().equalsIgnoreCase("Add Main Menu")) {
			System.out.println("Menu Details creation popup present");
			Itemmanagement_objects.menuaddedit(code, nameE, nameA);	
			System.out.println(code+" "+Common_objects.msgdetails.getText());
			Common_objects.msgclosebtn.click();
		}
		else {
			System.out.println("Main Menu creation popup may not present or header name is changed");
		}

}
	
	@Test(dependsOnMethods="mainmenuadd")
	public void mainmenuedit() {
		
		PageFactory.initElements(driver, Common_objects.class);
		Common_objects.search(code);
		if(Itemmanagement_objects.codecheck.getText().equalsIgnoreCase(code)) {
			Itemmanagement_objects.editbtn.click();
			Itemmanagement_objects.menuedit("update", "test");
			System.out.println(code+" "+Common_objects.msgdetails.getText());
			Common_objects.msgclosebtn.click();
		}
		
	}
	
	@Test(dependsOnMethods="mainmenuedit")
	public void mainmenudelete() {
		Common_objects.search(code);
		PageFactory.initElements(driver, Common_objects.class);
		if(Itemmanagement_objects.codecheck.getText().equalsIgnoreCase(code)) {
			Itemmanagement_objects.deletebtn.click();
			if(Common_objects.deletepopupmsg.isDisplayed()) {
				System.out.println(Common_objects.deletepopupmsg.getText());
				Common_objects.deletebtn.click();
			}
			System.out.println(code+" "+Common_objects.msgdetails.getText());
			Common_objects.msgclosebtn.click();
		}
		
	} 

}

package testscript;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import pagefactory.Commonobjects;

import pagefactory.Itemmanagementobjects;

public class Mainmenu extends Baseclass {
	 String menuname="Menu Details";
	 String submenuname="Main Menu";
	 String code="1114";
	 String nameE="Automation1";
	 String nameA="test";
	
	@Test(priority=0)

	public void mainmenuadd() {
		PageFactory.initElements(driver, Itemmanagementobjects.class);
		Commonclass.testobjects(menuname,submenuname);
		System.out.println("Main Menu  selected through common script");
		Commonobjects.addbtn.click();
		
		if(Itemmanagementobjects.addheader.getText().equalsIgnoreCase("Add Main Menu")) {
			System.out.println("Menu Details creation popup present");
			Itemmanagementobjects.itemaddedit(code, nameE, nameA);	
			System.out.println(code+" "+Commonobjects.msgdetails.getText());
			Commonobjects.msgclosebtn.click();
		}
		else {
			System.out.println("Main Menu creation popup may not present or header name is changed");
		}

}
	
	@Test(dependsOnMethods="mainmenuadd")
	public void mainmenuedit() {
		
		PageFactory.initElements(driver, Commonobjects.class);
		Commonobjects.search(code);
		if(Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
			Itemmanagementobjects.editbtn.click();
			Itemmanagementobjects.itemaddedit("update", "test");
			System.out.println(code+" "+Commonobjects.msgdetails.getText());
			Commonobjects.msgclosebtn.click();
		}
		
	}
	
	@Test(dependsOnMethods="mainmenuedit")
	public void mainmenudelete() {
		Commonobjects.search(code);
		PageFactory.initElements(driver, Commonobjects.class);
		if(Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
			Itemmanagementobjects.deletebtn.click();
			if(Commonobjects.deletepopupmsg.isDisplayed()) {
				System.out.println(Commonobjects.deletepopupmsg.getText());
				Commonobjects.deletebtn.click();
			}
			System.out.println(code+" "+Commonobjects.msgdetails.getText());
			Commonobjects.msgclosebtn.click();
		}
		
	} 

}

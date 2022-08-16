package testscript;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.Commonobjects;
import pagefactory.Itemmanagementobjects;

public class Units extends Baseclass {
	String menuname="Item Details";
	 String submenuname="Units";
	 String code="000007";
	 String unitchainnameE="autotest";
	 String unitchainnameA="autotestA";
	 String descriptionE="descautotest";
	 String descriptionA="descautotestA";
	 
	 @Test(priority=0)
	public void unitaddscript() {
		
		PageFactory.initElements(driver, Itemmanagementobjects.class);
		Commonclass.testobjects(menuname,submenuname);
	System.out.println("Item class selected through common script");
	Commonobjects.addbtn.click();
	if(Itemmanagementobjects.unitheader.getText().equalsIgnoreCase("Unit Details")) {
       System.out.println("Unit details creation popup present");	
		Itemmanagementobjects.itemaddedit(code, unitchainnameE, unitchainnameA, descriptionE, descriptionA);
		System.out.println(code+" "+Commonobjects.msgdetails.getText());
		Commonobjects.msgclosebtn.click();
	}
	else {
		System.out.println("Unit details creation popup may not present or header name is changed");
	}
	
	}
	
	

	@Test(priority=1)
	public void unitedit() {
		
		PageFactory.initElements(driver, Commonobjects.class);
		Commonobjects.search(code);
		if(Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
			Itemmanagementobjects.editicon.click();
			Itemmanagementobjects.itemaddedit("autotest","autotestA","Automationtest2", "test");
			System.out.println(code+" "+Commonobjects.msgdetails.getText());
			Commonobjects.msgclosebtn.click();
			
			
		}
		
	}
	
	@Test(priority=2)
	public void unitdelete() {
		Commonobjects.search(code);
		PageFactory.initElements(driver, Commonobjects.class);
		if(Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
			Itemmanagementobjects.deleteicon.click();
			if(Commonobjects.deletepopupmsg.isDisplayed()) {
				System.out.println(Commonobjects.deletepopupmsg.getText());
				Commonobjects.deletebtn.click();

			}
			
			System.out.println(code+" "+Commonobjects.msgdetails.getText());
			Commonobjects.msgclosebtn.click();
		}
		
	}
	
	
}

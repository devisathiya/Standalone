package testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.Common_objects;
import pagefactory.ItemMaskCodeObjects;
import pagefactory.Itemmanagement_objects;

public class Itemmaskcode extends Baseclass {
	String menuname = "Item Details";
	String submenuname = "Item Code Mask";
	String code = "000045";
	String namee = "test";
	String namea = "test";
	String fixedform = "a";
	String varleght = "2";
	
@Test
	public void itemmaskcodeadd() {
		PageFactory.initElements(driver, Itemmanagement_objects.class);
		PageFactory.initElements(driver, ItemMaskCodeObjects.class);
		Common_class.testobjects(menuname, submenuname);
		Common_objects.addbtn.click();
		ItemMaskCodeObjects.maskcodeadd(code, namee, namea, fixedform, varleght);
		ItemMaskCodeObjects.Addbtn.click();
		
	}
@Test
	public void itemmaskcodeupdate() {
		PageFactory.initElements(driver, Itemmanagement_objects.class);
		PageFactory.initElements(driver, ItemMaskCodeObjects.class);
		PageFactory.initElements(driver, Common_objects.class);
		Common_class.testobjects(menuname, submenuname);
		Common_objects.search(code);
		if(Itemmanagement_objects.codecheck.getText().equalsIgnoreCase(code)) {
			ItemMaskCodeObjects.editbtn.click();
			ItemMaskCodeObjects.maskcodeadd(code, "Testingproject", "Updatetest", fixedform, varleght);
			System.out.println(code+" "+Common_objects.msgdetails.getText());
			Common_objects.msgclosebtn.click();	
		}
	}
@Test
	public void itemmaskcodedelete() {
		
		PageFactory.initElements(driver, ItemMaskCodeObjects.class);
		PageFactory.initElements(driver, Common_objects.class);
		Common_class.testobjects(menuname, submenuname);
		Common_objects.search(code);
		if(Itemmanagement_objects.codecheck.getText().equalsIgnoreCase(code)) {
			ItemMaskCodeObjects.deletebtn.click();
			if(Common_objects.deletepopupmsg.isDisplayed()) {
				System.out.println(Common_objects.deletepopupmsg.getText());
				Common_objects.deletebtn.click();			
			}
			System.out.println(code+" "+Common_objects.msgdetails.getText());
			Common_objects.msgclosebtn.click();
		}
	}

	
	
}
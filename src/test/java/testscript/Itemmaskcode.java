
package testscript;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.Commonobjects;
import pagefactory.ItemMaskCodeObjects;
import pagefactory.Itemmanagementobjects;

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
		PageFactory.initElements(driver, Itemmanagementobjects.class);
		PageFactory.initElements(driver, ItemMaskCodeObjects.class);
		Commonclass.testobjects(menuname, submenuname);
		Commonobjects.addbtn.click();
		ItemMaskCodeObjects.maskcodeadd(code, namee, namea, fixedform, varleght);
		ItemMaskCodeObjects.Addbtn.click();
		
	}
@Test
	public void itemmaskcodeupdate() {
		PageFactory.initElements(driver, Itemmanagementobjects.class);
		PageFactory.initElements(driver, ItemMaskCodeObjects.class);
		PageFactory.initElements(driver, Commonobjects.class);
		Commonclass.testobjects(menuname, submenuname);
		Commonobjects.search(code);
		if(Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
			ItemMaskCodeObjects.editbtn.click();
			ItemMaskCodeObjects.maskcodeadd(code, "Testingproject", "Updatetest", fixedform, varleght);
			System.out.println(code+" "+Commonobjects.msgdetails.getText());
			Commonobjects.msgclosebtn.click();	
		}
	}
@Test
	public void itemmaskcodedelete() {
		
		PageFactory.initElements(driver, ItemMaskCodeObjects.class);
		PageFactory.initElements(driver, Commonobjects.class);
		Commonclass.testobjects(menuname, submenuname);
		Commonobjects.search(code);
		if(Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
			ItemMaskCodeObjects.deletebtn.click();
			if(Commonobjects.deletepopupmsg.isDisplayed()) {
				System.out.println(Commonobjects.deletepopupmsg.getText());
				Commonobjects.deletebtn.click();			
			}
			System.out.println(code+" "+Commonobjects.msgdetails.getText());
			Commonobjects.msgclosebtn.click();
		}
	}


}
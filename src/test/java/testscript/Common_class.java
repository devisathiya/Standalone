package testscript;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.Common_objects;

public class Common_class extends Baseclass {
	
	
	public static void testobjects(String menuname,String submenuname) {

	PageFactory.initElements(driver, Common_objects.class);
	Common_objects.sidemenuclick.click();
	System.out.println("Sidemenu is clicked");
	for(WebElement menus:Common_objects.sidemenuoptios) {
		System.out.println(menus.getText());
		
		if(menus.getText().equalsIgnoreCase(menuname)) {
			menus.click();
			
			for(WebElement submenus:Common_objects.sidesubmenuoptios) {
			System.out.println(submenus.getText());
			if(submenus.getText().equalsIgnoreCase(submenuname)) {
				submenus.click();
				System.out.println(submenuname+" Option is selected");
				break;
			}
			
			}
		break;	
		}
	}
	
	
	}
	
}

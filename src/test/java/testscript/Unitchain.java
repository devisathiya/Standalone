package testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pagefactory.Commonobjects;
import pagefactory.Itemmanagementobjects;

public class Unitchain extends Baseclass {
	String menuname = "Item Details";
	String submenuname = "Unit Chain";
	String code = "000007";
	String descriptionE = "descautotest";
	String descriptionA = "descautotestA";
	String fromunitval = "000001";
	String tounitval = "000005";
	String transvalue = "3";

	@Test(priority = 0)
	public void unitchainadd() {
		PageFactory.initElements(driver, Itemmanagementobjects.class);
		Commonclass.testobjects(menuname, submenuname);
		System.out.println("Item class selected through common script");
		Itemmanagementobjects.addbtn1.click();
		if (Itemmanagementobjects.unitchainheader.getText().equalsIgnoreCase("Unit Chain Details")) {
			System.out.println("Unit details creation popup present");
			Itemmanagementobjects.fromunit(fromunitval);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Itemmanagementobjects.tounit(tounitval);
			Itemmanagementobjects.itemaddedit1(code, descriptionE, descriptionA, transvalue);
			System.out.println(code + " " + Commonobjects.msgdetails.getText());
			Commonobjects.msgclosebtn.click();
		} else {
			System.out.println("Unit details creation popup may not present or header name is changed");
		}
	}

	@Test(priority = 1)
	public void unitchainedit() {
		PageFactory.initElements(driver, Commonobjects.class);
		Commonobjects.search(code);
		if (Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
			Itemmanagementobjects.chainediticon.click();
			Itemmanagementobjects.fromunit(fromunitval);
			Itemmanagementobjects.tounit(tounitval);
			Itemmanagementobjects.itemaddedit1("descautotestedit", "descautotestedit", "2");
			System.out.println(code + " " + Commonobjects.msgdetails.getText());
			Commonobjects.msgclosebtn.click();
		}
	}

	@Test(priority = 2)
	public void unitchaindelete() {
		Commonobjects.search(code);
		PageFactory.initElements(driver, Commonobjects.class);
		if (Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
			Itemmanagementobjects.chaindeleteicon.click();
			if (Commonobjects.deletepopupmsg.isDisplayed()) {
				System.out.println(Commonobjects.deletepopupmsg.getText());
				Commonobjects.deletebtn.click();
			}

			System.out.println(code + " " + Commonobjects.msgdetails.getText());
			Commonobjects.msgclosebtn.click();
		}

	}
}
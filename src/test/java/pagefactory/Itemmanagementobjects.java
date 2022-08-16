package pagefactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testscript.Baseclass;

public class Itemmanagementobjects extends Baseclass {

	// ------------------------item class and family, units common
	// objects-------------------------
	@FindBy(xpath = "//div[contains(@class,'itemList p-dialog p-dynamic-dialog')]/div[2]/app-addoredit-item-class/div/h4")
	public static WebElement header;

	@FindBy(xpath = "//div[contains(@class,'itemList p-dialog p-dynamic-dialog')]/div[2]/app-addoredit-item-family/div/h4")
	public static WebElement familyheader;

	@FindBy(xpath = "//div[@class='formContainer']/span[1]/input")
	public static WebElement classcode;

	@FindBy(xpath = "//div[@class='formContainer']/span[2]/input")
	public static WebElement classdescE;

	@FindBy(xpath = "//div[@class='formContainer']/span[3]/input")
	public static WebElement classdescA;

	@FindBy(xpath = "//div[contains(@class,'button-Container')]/button")
	public static WebElement classsavebtn;

	@FindBy(xpath = "//div/table/tbody/tr/td[1]")
	public static WebElement codecheck;

	@FindBy(xpath = "//div/table/tbody/tr/td[4]/span[@class='ng-star-inserted']/img[@src='assets/icons/edit.svg']")
	public static WebElement editicon;

	@FindBy(xpath = "//div/table/tbody/tr/td[4]/span[@class='ng-star-inserted']/img[@src='assets/icons/delete.svg']")
	public static WebElement deleteicon;

	// ------------------------Units and Unit chain common
	// objects-------------------------

	@FindBy(xpath = "//div[contains(@class,'itemList ')]/div[2]/addoredit-unit/div/h5")
	public static WebElement unitheader;

	@FindBy(xpath = "//div[@class='formContainer']/span[4]/input")
	public static WebElement descriptionE;

	@FindBy(xpath = "//div[@class='formContainer']/span[5]/input")
	public static WebElement descriptionA;

	@FindBy(xpath = "//div[contains(@class,'p-dropdown-panel p-component')]/div[contains(@class,'p-dropdown-items-wrapper ')]/ul/p-dropdownitem/li")
	public static List<WebElement> unitselection;

	// div[contains(@class,'p-dropdown-items-wrapper ')]/ul/p-dropdownitem/li

	@FindBy(xpath = "//div[contains(@class, ' button-container')]/div/button")
	public static WebElement addbtn1;

	@FindBy(xpath = "//div[contains(@class,'itemList ')]/div[2]/app-addoredit-unitchain/div/h4")
	public static WebElement unitchainheader;

	@FindBy(xpath = "//div[contains(@class,'formContainer')]/p-dropdown[1]/div")
	public static WebElement fromunit;

	@FindBy(xpath = "//div[contains(@class,'formContainer')]/p-dropdown[@formcontrolname='ToUnitCode']/div")
	public static WebElement tounit;

	@FindBy(xpath = "//div/table/tbody/tr/td[6]/span[@class='ng-star-inserted']/img[@src='assets/icons/edit.svg']")
	public static WebElement chainediticon;

	@FindBy(xpath = "//div/table/tbody/tr/td[6]/span[@class='ng-star-inserted']/img[@src='assets/icons/delete.svg']")
	public static WebElement chaindeleteicon;

	public static void itemaddedit(String code, String descE, String descA) {
		Itemmanagementobjects.classcode.sendKeys(code);
		Itemmanagementobjects.classdescE.sendKeys(descE);
		Itemmanagementobjects.classdescA.sendKeys(descA);
		Itemmanagementobjects.classsavebtn.click();

	}

	public static void itemaddedit(String descE, String descA) {
		Itemmanagementobjects.classdescE.sendKeys(descE);
		Itemmanagementobjects.classdescA.sendKeys(descA);
		Itemmanagementobjects.classsavebtn.click();

	}

	public static void itemaddedit(String code, String unitchainnameE, String unitchainnameA, String descriptionE,
			String descriptionA) {
		Itemmanagementobjects.classcode.sendKeys(code);
		Itemmanagementobjects.classdescE.sendKeys(unitchainnameE);
		Itemmanagementobjects.classdescA.sendKeys(unitchainnameA);
		Itemmanagementobjects.descriptionE.sendKeys(descriptionE);
		Itemmanagementobjects.descriptionA.sendKeys(descriptionA);
		Itemmanagementobjects.classsavebtn.click();

	}

	public static void itemaddedit(String unitchainnameE, String unitchainnameA, String descriptionE,
			String descriptionA) {
		Itemmanagementobjects.classdescE.sendKeys(unitchainnameE);
		Itemmanagementobjects.classdescA.sendKeys(unitchainnameA);
		Itemmanagementobjects.descriptionE.sendKeys(descriptionE);
		Itemmanagementobjects.descriptionA.sendKeys(descriptionA);
		Itemmanagementobjects.classsavebtn.click();

	}

	public static void itemaddedit1(String code, String descriptionE, String descriptionA, String transvalue) {
		Itemmanagementobjects.classcode.sendKeys(code);
		Itemmanagementobjects.classdescE.sendKeys(descriptionE);
		Itemmanagementobjects.classdescA.sendKeys(descriptionA);
		Itemmanagementobjects.descriptionE.sendKeys(transvalue);
		Itemmanagementobjects.classsavebtn.click();

	}

	public static void itemaddedit1(String descriptionE, String descriptionA, String transvalue) {
		Itemmanagementobjects.classdescE.sendKeys(descriptionE);
		Itemmanagementobjects.classdescA.sendKeys(descriptionA);
		Itemmanagementobjects.descriptionE.sendKeys(transvalue);
		Itemmanagementobjects.classsavebtn.click();

	}

	public static void fromunit(String fromunitval) {
		Itemmanagementobjects.fromunit.click();
		for (WebElement listval : Itemmanagementobjects.unitselection) {
			System.out.println(listval.getText());
			if (listval.getText().equalsIgnoreCase(fromunitval)) {
				listval.click();
				break;
			}
		}
	}

	public static void tounit(String tounitval) {
		Itemmanagementobjects.tounit.click();
		for (WebElement listval : Itemmanagementobjects.unitselection) {
			System.out.println(listval.getText());
			if (listval.getText().equalsIgnoreCase(tounitval)) {
				listval.click();
				break;
			}
		}
	}

}

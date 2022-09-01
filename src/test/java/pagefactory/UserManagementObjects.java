package pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserManagementObjects {
	//------------------------------------------User Role Objects--------------------------

	@FindBy(xpath = "//div[contains(@class, 'p-dialog-content ng-tns')]/app-addoredit-user-role/div/h4[1]")
	public static WebElement userroleheader;
	
	@FindBy(xpath = "//div[contains(@class,'groupContainer')]/p-togglebutton[1]/div/span[2]")
	public static WebElement txntoggle;
	
	@FindBy(xpath = "//div[@class='groupContainer']/span[1]/input")
	public static WebElement groupcode;
	
	@FindBy(xpath = "//div[@class='groupContainer']/span[2]/input")
	public static WebElement groupdescA; 
	
	@FindBy(xpath = "//div[contains(@class,'addEditContainer userRole ltrUI')]/p-table/div/div/table/tbody/tr/td[1]")
	public static WebElement permissions;
	
	@FindBy(xpath = "//div[contains(@class,'addEditContainer userRole ltrUI')]/p-table/div/div/table/tbody/tr/td[3]")
	public static WebElement permissionsselect;
	
	@FindBy(xpath = "//div[@class='p-tabview-panels']/p-tabpanel[1]/div/p-table/div/div/table/tbody/tr/td[4]/span[@class='ng-star-inserted']/img[@src='assets/icons/edit.svg']")
	public static WebElement editicon;
	
	@FindBy(xpath = "//div[@class='p-tabview-panels']/p-tabpanel[1]/div/p-table/div/div/table/tbody/tr/td[4]/span[@class='ng-star-inserted']/img[@src='assets/icons/delete.svg']")
	public static WebElement deleteicon;
//------------------------------------------User Objects--------------------------	
	@FindBy(xpath = "//div[contains(@class, 'p-dialog-content ng-tns')]/app-addoredit-user/div/h4[1]")
	public static WebElement userheader;
	
	@FindBy(xpath = "//div[contains(@class,'userContainer')]/div/div/input")
	public static WebElement orderusercheckbox;
	
	@FindBy(xpath = "//div[contains(@class,'formContainer')]/span[1]/input")
	public static WebElement username;
	
	@FindBy(xpath = "//div[contains(@class,'formContainer')]/span[2]/input")
	public static WebElement password;
	
	@FindBy(xpath = "//div[contains(@class,'formContainer')]/span[3]/input")
	public static WebElement confirmpassword;
	
	@FindBy(xpath = "//div[contains(@class,'formContainer')]/p-dropdown[1]")
	public static WebElement employeeclick;
	
	@FindBy(xpath = "//div[contains(@class,'p-dropdown-items-wrapper')]/ul/p-dropdownitem/li")
	public static List<WebElement> employeedropdown;
	
	@FindBy(xpath = "//div[contains(@class,'formContainer')]/p-dropdown[2]")
	public static WebElement groupclick;
	
	@FindBy(xpath = "//div[@class='p-tabview-panels']/p-tabpanel[1]/div/p-table/div/div/table/tbody/tr/td[7]/span[@class='ng-star-inserted']/img[@src='assets/icons/edit.svg']")
	public static WebElement useredit;
	
	@FindBy(xpath = "//div[@class='p-tabview-panels']/p-tabpanel[1]/div/p-table/div/div/table/tbody/tr/td[7]/span[@class='ng-star-inserted']/img[@src='assets/icons/delete.svg']")
	public static WebElement userdelete;
	
	@FindBy(xpath = "//div/table/tbody/tr/td[2]")
	public static WebElement usercheck;
	
	public static void permissions(String permissionid) {
		String[] strids=permissionid.split(",");

		for(int i=0;i<strids.length;i++) {
			if(permissions.getText().contains(permissionid))
		UserManagementObjects.permissionsselect.click();
	}}
	
	public static void useraddedit(String code, String descE) {
		UserManagementObjects.groupcode.sendKeys(code);
		UserManagementObjects.groupdescA.sendKeys(descE);
		Itemmanagementobjects.classsavebtn.click();
	}
	public static void useraddedit(String descE) {
		UserManagementObjects.groupdescA.sendKeys(descE);
		Itemmanagementobjects.classsavebtn.click();
	}
	public static void useredit(String password,String confirmpassword) {
		UserManagementObjects.password.sendKeys(password);
		UserManagementObjects.confirmpassword.sendKeys(confirmpassword);
		Itemmanagementobjects.classsavebtn.click();
	}
	

	public static void useraddedit(String username, String password,String confirmpassword) {
		UserManagementObjects.username.sendKeys(username);
		UserManagementObjects.password.sendKeys(password);
		UserManagementObjects.confirmpassword.sendKeys(confirmpassword);
		Itemmanagementobjects.classsavebtn.click();
	}
	
	public static void employeeselect(String employee) {
		UserManagementObjects.employeeclick.click();
		for(WebElement emplist:UserManagementObjects.employeedropdown) {
			if(emplist.getText().equalsIgnoreCase(employee)) {
				emplist.click();
			}
		}
		
	}
	public static void usergroupselect(String usergroup) {
		UserManagementObjects.groupclick.click();
		for(WebElement emplist:UserManagementObjects.employeedropdown) {
			if(emplist.getText().equalsIgnoreCase(usergroup)) {
				emplist.click();
			}
		}
		
	}
	
}

package testscript;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pagefactory.Commonobjects;
import pagefactory.Itemmanagementobjects;
import pagefactory.UserManagementObjects;

public class User extends Baseclass {
	String menuname = "User Details";
	String submenuname = "User";
	@Test
public void userscript() throws IOException {
	PageFactory.initElements(driver, UserManagementObjects.class);
	PageFactory.initElements(driver, Itemmanagementobjects.class);
	testcase = extentreport.createTest("User Script Result");
	Commonclass.testobjects(menuname, submenuname);
	Commonclass.excelcommonread("user");
	int rowcount=Commonclass.sheet.getLastRowNum()-Commonclass.sheet.getFirstRowNum();
	for(int i=1;i<=rowcount;i++) {
		HSSFRow rowNo = Commonclass.sheet.getRow(i);
		  HSSFCell cellValue = rowNo.getCell(5);
		  String valueOfCell = cellValue.getStringCellValue();
		  HSSFCell value=rowNo.getCell(3);
		  String runValue = value.getStringCellValue();
		  if(runValue.equalsIgnoreCase("Y")) {
			  List<String> codedata=jdbcTemplate.queryForList("select USER_NAME from POS_USER", String.class);
			  DataFormatter dataFormatter = new DataFormatter();
				String username=Commonclass.sheet.getRow(i).getCell(0).getStringCellValue();
				String employee=Commonclass.sheet.getRow(i).getCell(1).getStringCellValue();
				String usergroup=Commonclass.sheet.getRow(i).getCell(2).getStringCellValue();
				String password=dataFormatter.formatCellValue(Commonclass.sheet.getRow(i).getCell(6));
				String confirmpassword=dataFormatter.formatCellValue(Commonclass.sheet.getRow(i).getCell(7));
				String isorderuser=Commonclass.sheet.getRow(i).getCell(8).getStringCellValue();
				if(valueOfCell.equalsIgnoreCase("add")) {
					if(codedata.contains(username)) {
						System.out.println(username+"code is already present");
						HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
						  cell.setCellValue("code is already present");
					}
					else {
					Commonobjects.addbtn.click();
					System.out.println(UserManagementObjects.userheader.getText());
	if(UserManagementObjects.userheader.getText().equalsIgnoreCase("User Details")) {
		System.out.println("User creation popup present");
		UserManagementObjects.employeeselect(employee);
		if(isorderuser.equalsIgnoreCase("Y")) {
			UserManagementObjects.orderusercheckbox.click();
		}
		UserManagementObjects.usergroupselect(usergroup);
		UserManagementObjects.employeeselect(employee);
		UserManagementObjects.useraddedit(username, password,confirmpassword);
		  System.out.println(username + " " + Commonobjects.msgdetails.getText());
		  Commonobjects.msgclosebtn.click();
		  HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
		  cell.setCellValue("Add:PASS");
		  testcase.log(Status.PASS, "Given details are created in User" +username+ " the details are");
		  
		  }else {
				System.out.println(" User details creation popup may not present or header name is changed");
				testcase.log(Status.FAIL, "Given details are not created in  User. Due to some Error");
		}
		}
					} else if(valueOfCell.equalsIgnoreCase("update")) {
						Commonobjects.search(username);
						if (UserManagementObjects.usercheck.getText().equalsIgnoreCase(username)) {
							UserManagementObjects.useredit.click();
							//UserManagementObjects.usergroupselect(usergroup);
							UserManagementObjects.useredit(password,confirmpassword);
							System.out.println(username + " " + Commonobjects.msgdetails.getText());
							Commonobjects.msgclosebtn.click();
							HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
							  cell.setCellValue("Update:PASS");
							 testcase.log(Status.PASS, "Given details are updated in User" +username);
						}	
						else {
							System.out.println(username + " does not present in screen to Edit the details");
							testcase.log(Status.FAIL, username + " does not present in screen to Edit the details");
						}
					}
					else if(valueOfCell.equalsIgnoreCase("delete")) {
						Commonobjects.search(username);
						if (UserManagementObjects.usercheck.getText().equalsIgnoreCase(username)) {
							UserManagementObjects.userdelete.click();
							if (Commonobjects.deletepopupmsg.isDisplayed()) {
								System.out.println(Commonobjects.deletepopupmsg.getText());
								Commonobjects.deletebtn.click();
								HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
								  cell.setCellValue("Delete:PASS");
								  testcase.log(Status.PASS, "Given details are delete in User Role and the deleted code is " +username);
							}
							System.out.println(username + " " + Commonobjects.msgdetails.getText());
							Commonobjects.msgclosebtn.click();
						}
						else {
							System.out.println(username + " does not present in screen to Delete the details");
							testcase.log(Status.FAIL, username + " does not present in screen to Delete the details");
						}
					}
}
		  Commonclass.excelcommonwrite();
}
}
	
}

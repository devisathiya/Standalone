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
import pagefactory.NotesManagementObjects;
import pagefactory.UserManagementObjects;

public class Userrole extends Baseclass{
	String menuname = "User Details";
	String submenuname = "User Role";
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void userrolescript() throws IOException {
		PageFactory.initElements(driver, UserManagementObjects.class);
		PageFactory.initElements(driver, Itemmanagementobjects.class);
		testcase = extentreport.createTest("UserRole Script Result");
		Commonclass.testobjects(menuname, submenuname);
		Commonclass.excelcommonread("userrole");
		int rowcount=Commonclass.sheet.getLastRowNum()-Commonclass.sheet.getFirstRowNum();
		for(int i=1;i<=rowcount;i++) {
			HSSFRow rowNo = Commonclass.sheet.getRow(i);
			  HSSFCell cellValue = rowNo.getCell(5);
			  String valueOfCell = cellValue.getStringCellValue();
			  HSSFCell value=rowNo.getCell(3);
			  String runValue = value.getStringCellValue();
			  if(runValue.equalsIgnoreCase("Y")) {
				  List<Integer> codedata=jdbcTemplate.queryForList("select GROUP_ID from POS_USER_GROUP", Integer.class);
				  DataFormatter dataFormatter = new DataFormatter();
					String txntogglebtn=Commonclass.sheet.getRow(i).getCell(0).getStringCellValue();
					String code=dataFormatter.formatCellValue(Commonclass.sheet.getRow(i).getCell(1));
					String descE=Commonclass.sheet.getRow(i).getCell(2).getStringCellValue();
					String permissionid=dataFormatter.formatCellValue(Commonclass.sheet.getRow(i).getCell(6));
					if(valueOfCell.equalsIgnoreCase("add")) {
						if(codedata.contains(code)) {
							System.out.println(code+"code is already present");
							HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
							  cell.setCellValue("code is already present");
						}
						else {
						Commonobjects.addbtn.click();
						System.out.println(UserManagementObjects.userroleheader.getText());
		if(UserManagementObjects.userroleheader.getText().equalsIgnoreCase("Group Details")) {
			System.out.println("UserRole creation popup present");
			if(txntogglebtn.equalsIgnoreCase("txn")) {
				UserManagementObjects.txntoggle.click();
			}
		UserManagementObjects.permissions(permissionid);
			UserManagementObjects.useraddedit(code, descE);
			  System.out.println(code + " " + Commonobjects.msgdetails.getText());
			  Commonobjects.msgclosebtn.click();
			  HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
			  cell.setCellValue("Add:PASS");
			  testcase.log(Status.PASS, "Given details are created in User Role" +code+ " the details are"+descE);
			  
			  }else {
					System.out.println(" User Role details creation popup may not present or header name is changed");
					testcase.log(Status.FAIL, "Given details are not created in  User Role. Due to some Error");
			}
			}
						} else if(valueOfCell.equalsIgnoreCase("update")) {
							Commonobjects.search(code);
							if (Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
								UserManagementObjects.editicon.click();
								UserManagementObjects.useraddedit(descE);
								System.out.println(code + " " + Commonobjects.msgdetails.getText());
								Commonobjects.msgclosebtn.click();
								HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
								  cell.setCellValue("Update:PASS");
								 testcase.log(Status.PASS, "Given details are updated in User Role" +code+ " the details are"+descE);
							}	
							else {
								System.out.println(code + " does not present in screen to Edit the details");
								testcase.log(Status.FAIL, code + " does not present in screen to Edit the details");
							}
						}
						else if(valueOfCell.equalsIgnoreCase("delete")) {
							Commonobjects.search(code);
							if (Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
								UserManagementObjects.deleteicon.click();
								if (Commonobjects.deletepopupmsg.isDisplayed()) {
									System.out.println(Commonobjects.deletepopupmsg.getText());
									Commonobjects.deletebtn.click();
									HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
									  cell.setCellValue("Delete:PASS");
									  testcase.log(Status.PASS, "Given details are delete in User Role and the deleted code is " +code);
								}
								System.out.println(code + " " + Commonobjects.msgdetails.getText());
								Commonobjects.msgclosebtn.click();
							}
							else {
								System.out.println(code + " does not present in screen to Delete the details");
								testcase.log(Status.FAIL, code + " does not present in screen to Delete the details");
							}
						}
	}
			  Commonclass.excelcommonwrite();
}
	}
}

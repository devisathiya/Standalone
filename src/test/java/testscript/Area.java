package testscript;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pagefactory.AreaManagementObjects;
import pagefactory.Commonobjects;
import pagefactory.Itemmanagementobjects;


public class Area extends Baseclass{
	static String menuname = "Table Area Details";
	static String submenuname = "Area";
	@Test
	public static void areascript() throws IOException {
		PageFactory.initElements(driver, Itemmanagementobjects.class);
		PageFactory.initElements(driver, AreaManagementObjects.class);
		testcase = extentreport.createTest("Area Script Result");
		Commonclass.testobjects(menuname, submenuname);
		Commonclass.excelcommonread("area");
		int rowcount=Commonclass.sheet.getLastRowNum()-Commonclass.sheet.getFirstRowNum();
		for(int i=1;i<=rowcount; i++) {
			HSSFRow rowNo = Commonclass.sheet.getRow(i);
			 HSSFCell cellValue = rowNo.getCell(5);
			 String valueOfCell = cellValue.getStringCellValue();
			 HSSFCell value=rowNo.getCell(3);
			  String runValue = value.getStringCellValue();
			  if(runValue.equalsIgnoreCase("Y")) {
				  List<Integer> codedata=jdbcTemplate.queryForList("select AreaCode from POS_Area", Integer.class);
				  DataFormatter dataFormatter = new DataFormatter();
					String code=dataFormatter.formatCellValue(Commonclass.sheet.getRow(i).getCell(0));
					String descE=Commonclass.sheet.getRow(i).getCell(1).getStringCellValue();
					String descA=Commonclass.sheet.getRow(i).getCell(2).getStringCellValue();
					if(valueOfCell.equalsIgnoreCase("add")) {
						if(codedata.contains(code)) {
							System.out.println("code is already present");
							HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
							  cell.setCellValue("code is already present");
						}
						else {
							Commonobjects.addbtn.click();
							if (AreaManagementObjects.areaaddheader.getText().equalsIgnoreCase("Area")) {
								System.out.println("Area details creation popup present");
								  Itemmanagementobjects.itemaddedit(code, descE, descA);
								  System.out.println(code + " " + Commonobjects.msgdetails.getText());
								  Commonobjects.msgclosebtn.click();
								  HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
								  cell.setCellValue("Add:PASS");
								  testcase.log(Status.PASS, "Given details are created in Area" +code+ " the details are"+descE+ " ,"+descA);
								  
								  }else {
										System.out.println("Area details creation popup may not present or header name is changed");
										testcase.log(Status.FAIL, "Given details are not created in Area. Due to some Error");
								}
								}
						}
					else if(valueOfCell.equalsIgnoreCase("update")){
						Commonobjects.search(code);
						if (Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
							Itemmanagementobjects.editicon.click();
							AreaManagementObjects.areaaddedit("descE", "descA");
							System.out.println(code + " " + Commonobjects.msgdetails.getText());
							Commonobjects.msgclosebtn.click();
							HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
							  cell.setCellValue("Update:PASS");
							 testcase.log(Status.PASS, "Given details are updated in Area" +code+ " the details are"+descE+ " ,"+descA);
						}	
						else {
							System.out.println(code + " does not present in screen to Edit the details");
							testcase.log(Status.FAIL, code + " does not present in screen to Edit the details");
						}
					}
					else if(valueOfCell.equalsIgnoreCase("delete")) {
						Commonobjects.search(code);
						if (Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
							Itemmanagementobjects.deleteicon.click();
							if (Commonobjects.deletepopupmsg.isDisplayed()) {
								System.out.println(Commonobjects.deletepopupmsg.getText());
								Commonobjects.deletebtn.click();
								HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
								  cell.setCellValue("Delete:PASS");
								  testcase.log(Status.PASS, "Given details are delete in Area and the deleted code is " +code);
							}
							System.out.println(code + " " + Commonobjects.msgdetails.getText());
							Commonobjects.msgclosebtn.click();
						}
						else {
							System.out.println(code + " does not present in screen to Delete the details");
							testcase.log(Status.FAIL, code + " does not present in screen to Delete the details");
						}
					}	
					else if(valueOfCell.equalsIgnoreCase("designarea")) {
						Commonobjects.search(code);	
						if (Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
							AreaManagementObjects.designareaicon.click();
							if(AreaManagementObjects.designareaheader.getText().contains("Design Area :")) {
								System.out.println("Design Area screen present");	
								/*
								 * for(WebElement designmenus:AreaManagementObjects.designareamenulist) {
								 *  }
								 */
								
								System.out.println(AreaManagementObjects.designareamenulist.getText());
								
							}
							
							}
					}
					
			  }
			  Commonclass.excelcommonwrite();
			  }
			
		}	
}

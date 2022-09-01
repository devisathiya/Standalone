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

public class Subcards extends Baseclass {

	String menuname = "Company Details";
	String submenuname = "Sub Card";
	@Test
	public void SubcardsScript() throws IOException {
		testcase = extentreport.createTest("Subcards Script Result");
		PageFactory.initElements(driver, NotesManagementObjects.class);
		PageFactory.initElements(driver, Itemmanagementobjects.class);
		Commonclass.testobjects(menuname, submenuname);
		Commonclass.excelcommonread("subcard");
		int rowcount=Commonclass.sheet.getLastRowNum()-Commonclass.sheet.getFirstRowNum();
		for(int i=1;i<=rowcount;i++) {
			HSSFRow rowNo = Commonclass.sheet.getRow(i);
			  HSSFCell cellValue = rowNo.getCell(5);
			  String valueOfCell = cellValue.getStringCellValue();
			  HSSFCell value=rowNo.getCell(3);
			  String runValue = value.getStringCellValue();
			  if(runValue.equalsIgnoreCase("Y")) {
				  List<String> codedata=jdbcTemplate.queryForList("select SubCardCode from POS_SubCards", String.class);
				  DataFormatter dataFormatter = new DataFormatter();
					String code=dataFormatter.formatCellValue(Commonclass.sheet.getRow(i).getCell(0));
					String descE=Commonclass.sheet.getRow(i).getCell(1).getStringCellValue();
					String descA=Commonclass.sheet.getRow(i).getCell(2).getStringCellValue();
					if(valueOfCell.equalsIgnoreCase("add")) {
						if(codedata.contains(code)) {
							System.out.println(code+"code is already present");
							HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
							  cell.setCellValue(code+"code is already present");
						}
						else {
						Commonobjects.addbtn.click();
		if (NotesManagementObjects.subcardheader.getText().equalsIgnoreCase("Sub Card")) {
			System.out.println("Sub Card details creation popup present");
			  Itemmanagementobjects.itemaddedit(code, descE, descA);
			  System.out.println(code + " " + Commonobjects.msgdetails.getText());
			  Commonobjects.msgclosebtn.click();
			  HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
			  cell.setCellValue("Add:PASS");
			  testcase.log(Status.PASS, "Given details are created in NoSub Cardtes" +code+ " the details are"+descE+ " ,"+descA);
			  
			  }else {
					System.out.println("Sub Card details creation popup may not present or header name is changed");
					testcase.log(Status.FAIL, "Given details are not created in Sub Card. Due to some Error");
			}
			}}
				else if(valueOfCell.equalsIgnoreCase("update")){
					
						Commonobjects.search(code);
						if (Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
							NotesManagementObjects.editicon.click();
							Itemmanagementobjects.itemaddedit("descE", "descA");
							System.out.println(code + " " + Commonobjects.msgdetails.getText());
							Commonobjects.msgclosebtn.click();
							HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
							  cell.setCellValue("Update:PASS");
							 testcase.log(Status.PASS, "Given details are updated in Sub Card" +code+ " the details are"+descE+ " ,"+descA);
						}	
						else {
							System.out.println(code + " does not present in screen to Edit the details");
							testcase.log(Status.FAIL, code + " does not present in screen to Edit the details");
						}
						
					}
					else if(valueOfCell.equalsIgnoreCase("delete")) {
						Commonobjects.search(code);
						if (Itemmanagementobjects.codecheck.getText().equalsIgnoreCase(code)) {
							NotesManagementObjects.deleteicon.click();
							if (Commonobjects.deletepopupmsg.isDisplayed()) {
								System.out.println(Commonobjects.deletepopupmsg.getText());
								Commonobjects.deletebtn.click();
								HSSFCell cell = Commonclass.sheet.getRow(i).createCell(4);
								  cell.setCellValue("Delete:PASS");
								  testcase.log(Status.PASS, "Given details are delete in Sub Card and the deleted code is " +code);
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

package testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.Commonobjects;

public class Commonclass extends Baseclass {
	public static HSSFWorkbook Workbook;
	public static HSSFSheet sheet;
	
//*********************Excel read And write common code*********************************
	public static void excelcommonread(String sheetname) throws IOException {
		File file=new File(prop.getProperty("Excel"));
		FileInputStream inputStream = new FileInputStream(file);
		Workbook = new HSSFWorkbook(inputStream);
		sheet=Workbook.getSheet(sheetname);	
	}
	
	public static void excelcommonwrite() throws IOException {
		
		File outputfile=new File(prop.getProperty("Excel"));
		FileOutputStream outputstream=new FileOutputStream(outputfile);
		Workbook.write(outputstream);
	}
	

//*********************Side-Menus selection common code*********************************
	public static void testobjects(String menuname,String submenuname) {

	PageFactory.initElements(driver, Commonobjects.class);
	Commonobjects.sidemenuclick.click();
	System.out.println("Sidemenu is clicked");
	for(WebElement menus:Commonobjects.sidemenuoptios) {
		System.out.println(menus.getText());
		
		if(menus.getText().equalsIgnoreCase(menuname)) {
			menus.click();
			
			for(WebElement submenus:Commonobjects.sidesubmenuoptios) {
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

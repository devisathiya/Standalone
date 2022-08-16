package testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.Commonobjects;
import pagefactory.Loginpage;

public class Exceltest extends Baseclass {

	@Test
	public void excelLogin() throws IOException {
		Commonclass.excelcommonread("credentials");
		PageFactory.initElements(driver, Loginpage.class);
		PageFactory.initElements(driver, Commonobjects.class);
		
		/*
		 * List<Map<String, Object>> rows = jdbcTemplate.
		 * queryForList("select ItemClassCode, ItemClassDescE from POS_ItemClass");
		 * 
		 * HashMap<String, Object> rows1 = (HashMap<String, Object>) jdbcTemplate.
		 * queryForMap("select ItemClassCode, ItemClassDescE from POS_ItemClass");
		 * System.out.println(rows);
		 */
		
		int rowCount = Commonclass.sheet.getLastRowNum() - Commonclass.sheet.getFirstRowNum();
		for (int i = 1; i <= rowCount; i++) {
			HSSFRow rowNo = Commonclass.sheet.getRow(i);
			HSSFCell cellValue = rowNo.getCell(2);
			String valueOfCell = cellValue.getStringCellValue();
			if (valueOfCell.equalsIgnoreCase("Y")) {
				String username = Commonclass.sheet.getRow(i).getCell(0).getStringCellValue();
				DataFormatter dataFormatter = new DataFormatter();
				String Password = dataFormatter.formatCellValue(Commonclass.sheet.getRow(i).getCell(1));
				String datacheck = jdbcTemplate.queryForObject("select USER_PASSWORD from pos_user where user_name=?",
						new Object[] { username }, String.class);
				if (datacheck.equalsIgnoreCase(Password)) {
					System.out.println("Valid data");
					System.out.println(username);
					Loginpage.userid.sendKeys(username);
					System.out.println(Password);
					Loginpage.pwd.sendKeys(Password);
					Loginpage.login.click();
					WebElement home = driver.findElement(By.xpath("//div[@class='headerLable']/h4"));
					if (home.getText().equalsIgnoreCase("Company Details")) {
						HSSFCell cell = Commonclass.sheet.getRow(i).createCell(3);
						cell.setCellValue("PASS:Valid data");
						WebElement logoff = driver.findElement(By.xpath("//div[@class='userdiv']"));
						logoff.click();
						WebElement signoff = driver.findElement(
								By.xpath("//div[contains(@class,'p-overlaypanel p-component ng-star-inserted')]/div"));
						signoff.click();
					}
				} else {
					 System.out.println("FAIL:In-Valid data"); 

					HSSFCell cell = Commonclass.sheet.getRow(i).createCell(3);
					cell.setCellValue("In-Valid data");
				}

			}
			Commonclass.excelcommonwrite();
		}
	}

}

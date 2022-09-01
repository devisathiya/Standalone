
package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ItemMaskCodeObjects {
	
	
	@FindBy(xpath="//*[@id='maskCode']")
	public static WebElement maskcode;

	@FindBy(xpath="//*[@id='name']")
	public static WebElement namee;
	
	@FindBy(xpath="//*[@id='namea']")
	public static WebElement namea;
	
	@FindBy(xpath="//div/button[@class='okButton nextButton primaryBtnColor popup btnMargin']")
	public static WebElement nextbtn;
	
	@FindBy(xpath="//p-radiobutton[@inputid='fixed']")
	public static WebElement fixedradiobtn;
	
	@FindBy(xpath="//p-radiobutton[@inputid='variable']")
	public static WebElement varlengthradiobtn;
	
	@FindBy(xpath="//*[@id='fixedForm']")
	public static WebElement fixedform;
	
	@FindBy(xpath="//*[@id='varLength']")
	public static WebElement variablelegth;
	
	
	@FindBy(xpath="//div/button[@class='okButton primaryBtnColor popup btnMargin']")
	public static WebElement Addbtn;
	
	@FindBy(xpath="//div[@class='desc-sub-container']/div/button")
	public static WebElement Savebtn;
	
	@FindBy(xpath="//table[@id='pr_id_10-table']/tbody/tr/td[5]/span/img[1]")
	public static WebElement editbtn;

	@FindBy(xpath="//table[@id='pr_id_10-table']/tbody/tr/td[5]/span/img[2]")
	public static WebElement deletebtn;

	public static void maskcodeadd(String maskcode, String nameE, String nameA, String fixed, String varleght){
		ItemMaskCodeObjects.maskcode.sendKeys(maskcode);
		ItemMaskCodeObjects.namee.sendKeys(nameE);
		ItemMaskCodeObjects.namea.sendKeys(nameA);
		ItemMaskCodeObjects.nextbtn.click();
		ItemMaskCodeObjects.variablelegth.sendKeys(varleght);
		ItemMaskCodeObjects.fixedradiobtn.click();
		ItemMaskCodeObjects.fixedform.sendKeys(fixed);
		ItemMaskCodeObjects.Savebtn.click();
	}


	
	
}


package flowMethods;

import model.LoginPage;

import org.openqa.selenium.WebDriver;

import utility.ExcelUtility;
import baseScript.DriverScript;

public class ValidateLogin{
	WebDriver driver;
	DriverScript d=new DriverScript(driver);
	LoginPage objLogin=new LoginPage(driver);
	ExcelUtility e=new ExcelUtility();
		
	
	public void PositiveValidateLogin() throws Exception
	{
		/*System.out.println("testcase started");
		ExcelUtility.setExcelFile("D:\\workspace\\SeleniumProject1\\src\\testData\\Login.xlsx");
		*/
		String stUserName = ExcelUtility.getCellData(1, 0, "Login");
		System.out.println(stUserName);
	d.LaunchBrowser();
	objLogin.setUserName("admin@phptravels.com");
	objLogin.strPassword("demoadmin");
	objLogin.clickLoginButton();
	d.closeBrowser();
		
		
	}
	public void NegativeValidateLogin() throws Exception
	{	d.LaunchBrowser();
	objLogin.setUserName("invalidAdmin@phptravels.com");
	objLogin.strPassword("demoadmin");
	objLogin.clickLoginButton();
	d.closeBrowser();
		
	}

}

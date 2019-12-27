package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ReadProperties;
import baseScript.DriverScript;

public class LoginPage extends DriverScript {
	public static By username=By.name("email");
	public static By password=By.name("password");
	

public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void setUserName(String strUsername)
	{
		WebElement element=driver.findElement(username);
		element.sendKeys(strUsername);
		
		System.out.println("username field is visible and data entered as "+strUsername);
	
	}
	
	public void strPassword(String strPassword)
	{
		WebElement element=driver.findElement(password);
		element.sendKeys(strPassword);
		
		System.out.println("password field is visible and data entered as "+strPassword);
	
	}
	
	public void clickLoginButton() throws Exception
	{
		String s=ReadProperties.getPropertyValueConfigFile("LoginPage.LoginButton");
		String s1[]=s.split("~");
		String locatorValue=s1[0];
		String locatorType=s1[1];
		String str="By."+locatorType+"("+locatorValue+"))";
		WebElement element=driver.findElement(By.xpath(s1[1]));
		element.click();
		
		System.out.println("login button clicked");
	
	}
	
	

}

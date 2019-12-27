package baseScript;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utility.ReadProperties;

public class DriverScript {

	String browser="Chrome";
	public static WebDriver driver;

	public  DriverScript(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void LaunchBrowser() throws Exception
	{
		String browser=ReadProperties.getPropertyValueConfigFile("Browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		//setup chrome driver 
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\browsercode_latges\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
		//setup ie browser
		System.setProperty("webdriver.ie.driver", "D:\\Softwares\\Selenium\\driverBrowsers\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		}
		else{
		
		//setup firefox browser
		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\Selenium\\driverBrowsers\\geckodriver.exe");
		driver=new FirefoxDriver();
		}
		
				
		//open the browser and enter url
		driver.navigate().to(ReadProperties.getPropertyValueConfigFile("url"));
		driver.manage().window().maximize();	
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	public void closeBrowser()
	{
		driver.quit();
	}
	
}


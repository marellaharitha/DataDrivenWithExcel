package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	
	public static String getPropertyValueConfigFile(String key) throws Exception
	{
		BufferedReader objReader = new BufferedReader(new FileReader("D:\\workspace\\SeleniumProject1\\src\\Config.properties"));
		Properties p=new Properties();
		p.load(objReader);
		
		String data=p.getProperty(key);
		
		return data;
	}
	public static String getPropertyValueORFile(String key) throws Exception
	{
		BufferedReader objReader = new BufferedReader(new FileReader("D:\\workspace\\SeleniumProject1\\src\\ObjectRepository.properties"));
		Properties p=new Properties();
		p.load(objReader);
		
		String data=p.getProperty(key);
		
		return data;
	}
}

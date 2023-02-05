package a_NeoStoxPOMClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Reporter {

	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		//1. create an object of properties file
		Properties prop=new Properties();
		//2. create object of fileInputStream
		FileInputStream myFile=new FileInputStream("C:\\Users\\MY PC\\eclipse-workspace\\My1stSeleniumProject\\MyProperty.properties");
		//3. load file
		prop.load(myFile);
		//4.read data from file
		String value = prop.getProperty(key);
		Reporter.log("Data read from property file is "+value, true);
		return value;
		
	}

	private static void log(String string, boolean b) {
		// TODO Auto-generated method stub
		
	}
}

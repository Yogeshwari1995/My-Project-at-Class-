package a_NeostoxTestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import a_NeoStoxPOMClasses.Utility;



public class Base 
{
	protected static WebDriver driver;
	
	public void launchBrowser() throws IOException
	{
		 System.setProperty("webdriver.chrome.driver", "F:\\Automation\\SeleniumJars\\chromedriver.exe");
		 driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(Utility.readDataFromPropertyFile("url"));
		 Utility.implicitWait(driver, 1000);
         Reporter.log("Browser has been launched", true);
	}

}

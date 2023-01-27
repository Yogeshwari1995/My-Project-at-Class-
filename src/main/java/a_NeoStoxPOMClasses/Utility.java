package a_NeoStoxPOMClasses;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
	
	//wait
	//scrollIntoView
	//screenshot
	//excelSheetDataReading
	//read data from property file
	
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
	
	public static void implicitWait(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
		
		Reporter.log("Applied impicit wait of "+time, true);
		//comment
	}
	public static void scrollingToElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("Scrolled to element on page "+element.getText());
	}
	public static String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException 
	{
		File myFile = new File("F:\\Automation\\workbook.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet4");
		String value = mySheet.getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("Reading data from excel row "+row+" and cell "+cell , true);
		Reporter.log("The entered element is "+value, true);
		return value;
	}
	public static void takeScreenshot(WebDriver driver, String fileName) throws IOException
	{
		File sorce = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("F:\\Automation\\ScreenShots\\"+fileName+".png");
		FileHandler.copy(sorce, dest);
		Reporter.log("Took Screnshot ", true);
		Reporter.log("Screnshot took and stored at "+dest, true);
	}
}

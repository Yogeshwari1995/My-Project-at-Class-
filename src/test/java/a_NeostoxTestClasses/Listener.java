package a_NeostoxTestClasses;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import a_NeoStoxPOMClasses.Utility;


public class Listener extends Base implements ITestListener
{
	
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("The TC "+result.getName()+" is failed, please try again", true);
	    try 
	    {
			Utility.takeScreenshot(driver, result.getName());
		} 
	    catch (IOException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	}
	
	
	
	

}

package a_NeostoxTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.j2objc.annotations.Property;

import a_NeoStoxPOMClasses.NeostoxDashboardPage;
import a_NeoStoxPOMClasses.NeostoxHomePage;
import a_NeoStoxPOMClasses.NeostoxPasswordPage;
import a_NeoStoxPOMClasses.NeostoxSignInPage;
import a_NeoStoxPOMClasses.Utility;



public class ValidateTCwithPropertyFile extends Base {
	
	NeostoxDashboardPage dash;
	NeostoxHomePage home;
	NeostoxPasswordPage pwd;
	NeostoxSignInPage signIn;
	String s="TCID-1111";
	
  @BeforeClass
  public void launchNeostoxApp() throws IOException 
  {
	  launchBrowser();
	  home=new NeostoxHomePage(driver);
	  dash=new NeostoxDashboardPage(driver);
	  signIn=new NeostoxSignInPage(driver);
	  pwd=new NeostoxPasswordPage(driver);
	  
	  
  }
  
  @BeforeMethod
  public void signInToNeostox() throws EncryptedDocumentException, IOException, InterruptedException
  {
	  home.clikOnSinInButton();
	  Utility.implicitWait(driver, 1000);
	  signIn.enterMobileNumber(Utility.readDataFromPropertyFile("mobileNo"));
	  signIn.clickOnSignInButton();
	  Utility.implicitWait(driver, 1000);
	  pwd.enterPassword(Utility.readDataFromPropertyFile("password"));
	  Thread.sleep(1000);
	  pwd.clickOnSubmitButton();
	  Utility.implicitWait(driver, 500);
	  dash.handlePopUp(driver);
	  Thread.sleep(500);
	  
  }
  
  @Test
  public void validateUserNameFromNeostox() throws EncryptedDocumentException, IOException 
  {
	  Assert.assertEquals(dash.getUserText(), Utility.readDataFromPropertyFile("UserName"),"Actual and Expected user Names are not matching TC is failed");
	  Utility.takeScreenshot(driver, s);
  }
  @Test
  public void validateAcBalance()
  {
	 dash.getAcBalance();
  }
  
  
  @AfterMethod
  public void logOutFromNeostox() 
  {
	  dash.clickOnLogOutButton();
	  
  }
  
  @AfterClass
  public void closeTheNeostoxApp() 
  {
	  driver.close();
  }
  
  
}

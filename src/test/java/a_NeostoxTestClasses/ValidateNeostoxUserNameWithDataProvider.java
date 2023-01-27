package a_NeostoxTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import a_NeoStoxPOMClasses.NeostoxDashboardPage;
import a_NeoStoxPOMClasses.NeostoxHomePage;
import a_NeoStoxPOMClasses.NeostoxPasswordPage;
import a_NeoStoxPOMClasses.NeostoxSignInPage;
import a_NeoStoxPOMClasses.Utility;


@Listeners(a_NeostoxTestClasses.Listener.class)
public class ValidateNeostoxUserNameWithDataProvider extends Base {
	
	NeostoxDashboardPage dash;
	NeostoxHomePage home;
	NeostoxPasswordPage pwd;
	NeostoxSignInPage signIn;
	String s="TCID-1111";
	
  
	
	
  
  @BeforeMethod
  public void launchAppAndSignInToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
  {
	  launchBrowser();
	  home=new NeostoxHomePage(driver);
	  dash=new NeostoxDashboardPage(driver);
	  signIn=new NeostoxSignInPage(driver);
	  pwd=new NeostoxPasswordPage(driver);
	  
	  
  }
  
//Note: TestNG comes up with DataProvider to automate the process of providing test cases for execution. 
  //DataProvider helps with data-driven test cases that carry the same methods but can be run multiple times with different data sets. 
  //It also helps in providing complex parameters to the test methods.
  
  @Test
  public void validateUserNameFromNeostox(String mobileNo, String password, String userName) throws EncryptedDocumentException, IOException, InterruptedException 
  {
	  home.clikOnSinInButton();
	  Utility.implicitWait(driver, 1000);
	  signIn.enterMobileNumber(mobileNo);
	  signIn.clickOnSignInButton();
	  Utility.implicitWait(driver, 1000);
	  pwd.enterPassword(password);
	  
	  Thread.sleep(1000);
	  pwd.clickOnSubmitButton();
	  Utility.implicitWait(driver, 500);
	  
	  dash.handlePopUp(driver);
	  Thread.sleep(500);
	  
	  Assert.assertEquals(dash.getUserText(), userName,"Actual and Expected user Names are not matching TC is failed");
	  Utility.takeScreenshot(driver, s);
  }
  @Test
  public void validateAcBalance(String mobileNo, String password) throws EncryptedDocumentException, IOException, InterruptedException
  {
	  home.clikOnSinInButton();
	  Utility.implicitWait(driver, 1000);
	  signIn.enterMobileNumber(mobileNo);
	  signIn.clickOnSignInButton();
	  Utility.implicitWait(driver, 1000);
	  pwd.enterPassword(password);
	  
	  Thread.sleep(1000);
	  pwd.clickOnSubmitButton();
	  Utility.implicitWait(driver, 500);
	  
	  dash.handlePopUp(driver);
	  Thread.sleep(500);
	 dash.getAcBalance();
	 Assert.assertNull(dash.getAcBalance(), "Account Balance is not null, TC is failed");
  }
  
  
  @AfterMethod
  public void logOutFromNeostox() 
  {
	  dash.clickOnLogOutButton();
	  driver.close();
  }
  
  @DataProvider(name="loginDetailsForValidiatingUserName")
  public String[][] getLoginDetails1()
  {
	  
	return null;
	  
  }
  
  
  
  
}

package a_NeostoxTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import a_NeoStoxPOMClasses.NeostoxDashboardPage;
import a_NeoStoxPOMClasses.NeostoxHomePage;
import a_NeoStoxPOMClasses.NeostoxPasswordPage;
import a_NeoStoxPOMClasses.NeostoxSignInPage;
import a_NeoStoxPOMClasses.Utility;


@Listeners(a_NeostoxTestClasses.Listener.class)
public class ValidateNeostoxUserName extends Base {
	
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
	  signIn.enterMobileNumber(Utility.readDataFromExcel(0, 0));
	  signIn.clickOnSignInButton();
	  Utility.implicitWait(driver, 1000);
	  
	  pwd.enterPassword(Utility.readDataFromExcel(0, 1));
	  Thread.sleep(1000);
	  
	  pwd.clickOnSubmitButton();
	  Utility.implicitWait(driver, 500);
	  
	  dash.handlePopUp(driver);
	  Thread.sleep(500);
  }
  
  
  @Test
  public void validateUserNameFromNeostox() throws EncryptedDocumentException, IOException 
  {
	  //Assert.fail();
	  Assert.assertEquals(dash.getUserText(), Utility.readDataFromExcel(0, 2),"Actual and Expected user Names are not matching TC is failed");
	  Utility.takeScreenshot(driver, s);
  }
  @Test
  public void validateAcBalance()
  {
	 dash.getAcBalance();
	 Assert.assertNull(dash.getAcBalance(), "Account Balance is not null, TC is failed");
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

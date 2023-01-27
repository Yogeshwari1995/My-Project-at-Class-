package a_NeoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeostoxSignInPage 
{

	//1 Data member should be declared globally with access level private using @findBy Annotation
	@FindBy(xpath = "//input[@aria-label='mobilenumber']") private WebElement userIdField;
	@FindBy(id = "lnk_signup1") private WebElement signInButton;
	
	//2 Initialize within a constructor with access level public using pagefactory
	
	public  NeostoxSignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3 Utilize within a method with access level public
	public void enterMobileNumber(String a)
	{
		userIdField.sendKeys(a);
		Reporter.log("Entered mobile no ", true);
	}
	public void clickOnSignInButton()
	{
		
		signInButton.click();
		Reporter.log("clicked on sign in button ", true);
	}

}

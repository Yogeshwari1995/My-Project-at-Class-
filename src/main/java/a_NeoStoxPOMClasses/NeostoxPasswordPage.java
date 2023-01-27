package a_NeoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeostoxPasswordPage
{
	//1. Data member should be declared globally with access level as private with @FindBy method
		@FindBy(id = "txt_accesspin") private WebElement passwordTextBox;
		@FindBy(id = "lnk_submitaccesspin") private WebElement submitButton;
		
		//2.Initialize within the constructor with access level public
		
		public NeostoxPasswordPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//3 Utilize within a method with access level public
		public void enterPassword(String b)
		{
			passwordTextBox.sendKeys(b);
			Reporter.log("Entered password ", true);
		}
		
		public void clickOnSubmitButton()
		{
			
			submitButton.click();
			Reporter.log("Clicked on submit button ", true);
		}

}

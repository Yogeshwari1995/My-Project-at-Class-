package a_NeoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeostoxDashboardPage 
{
	
	//1. Declare the variable globally by providing ptivate access with @FindBy method
	
		@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement popupOkButton;
		@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closeButton;
		@FindBy(xpath = "//span[text()='Hi Yogeshwari bhoyar']") private WebElement actualText;
		@FindBy(xpath = "//span[text()='Hi Yogeshwari bhoyar']") private WebElement profileText;
		@FindBy(id = "lnk_logout") private WebElement logOutButton;
		@FindBy(id = "lbl_curbalancetop") private WebElement acBalance;
		
		//2. Initialize within the constructor with public access
		public NeostoxDashboardPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//3. Utilize within the method with access level public
		public void handlePopUp(WebDriver driver) throws InterruptedException
		{
			if(popupOkButton.isDisplayed())
			{
				//Utility.scrollingToElement(driver, popupOkButton);
				popupOkButton.click();
				Reporter.log("Clicked on ok popup button", true);
				Thread.sleep(1000);
				//Utility.scrollingToElement(driver, closeButton);
				//closeButton.click();
				//Reporter.log("Clicked on close popup button", true);
				Reporter.log("Pop has been handled ", true);
			}
			else
			{
				Reporter.log("The popUp is not found", true);
			}
		}
		
		public String getUserText()
		{
//			String text = actualText.getText();
//			String expectedText="Hi Yogeshwari bhoyar";
//			System.out.println("The User Name on the profile is "+text);
//			
//			if(text.equals(expectedText))
//			{
//				System.out.println("Test Case is Passed");
//			}
//			else {
//				System.out.println("Test Case is Failed");
//			}
//			return expectedText;
			
			String actualUserName = actualText.getText();
			Reporter.log("getting actual user Name", true);
			Reporter.log("Actual user name is --> "+actualUserName, true);
			return actualUserName;
	    }
		
		public String getAcBalance()
		{
			String balance = acBalance.getText();
			Reporter.log("The available balance is "+balance, true);
			return balance;
		}
		public void nothing()
		{
			
		}
		
		public void clickOnLogOutButton()
		{
			profileText.click();
			logOutButton.click();
			Reporter.log("Clicked on log out button" , true);
		}
		
	

}

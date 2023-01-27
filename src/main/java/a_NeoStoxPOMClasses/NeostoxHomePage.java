package a_NeoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeostoxHomePage 
{

	//1 Data member should be declared globally with access level private using @findBy Annotation
	
		@FindBy(xpath = "(//a[@class='nav-link'])[7]") private WebElement signInButton;
		
		//2 Initialize within a constructor with access level public using pagefactory
		
		public NeostoxHomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//3 Utilize within a method with access level public
		public void clikOnSinInButton()
		{
			signInButton.click();
			Reporter.log("Clicked on Home page's sign in button  ", true);
		}
		
}
